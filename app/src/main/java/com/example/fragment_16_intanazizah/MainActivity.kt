package com.example.fragment_16_intanazizah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_16_intanazizah.fragment.HomeFragment
import com.example.fragment_16_intanazizah.fragment.NotificationsFragment
import com.example.fragment_16_intanazizah.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationsFragment = NotificationsFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentfragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentfragment(homeFragment)
                R.id.menu_notification -> makeCurrentfragment(notificationsFragment)
                R.id.menu_settings-> makeCurrentfragment(settingsFragment)
            }

            true
        }
    }

    private fun makeCurrentfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}