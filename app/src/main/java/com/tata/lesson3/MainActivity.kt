package com.tata.lesson3

import android.content.Intent
import android.icu.text.IDNA
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment as Fragment1

lateinit var bottomNavigationMenu: BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment1? = null
            when (item.itemId) {
                R.id.calculator_page -> {
                    fragment = CalculatorFragment()
                }
                R.id.sanpin_page -> {
                    val googleLink = Uri.parse("http://google.com")
                    val openBrowserIntent = Intent(Intent.ACTION_VIEW, googleLink)
                    val chooser = Intent.createChooser(openBrowserIntent, "browser")

                    startActivity(chooser)

                }
                R.id.info_page -> {
                    fragment = InfoFragment()
                }
            }
            replaceFragment(fragment!!)
            true

        }

        bottomNavigationMenu.selectedItemId=R.id.calculator_page

    }

    fun replaceFragment(fragment: Fragment1) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}