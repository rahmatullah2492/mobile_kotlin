package com.example.kuliahapps

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.kuliahapps.fragment.ExploreFragment
import com.example.kuliahapps.fragment.HomeFragment
import com.example.kuliahapps.fragment.Profilragment
import com.example.kuliahapps.fragment.GaleryFragment

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val subscriptionFragment = GaleryFragment()
        val libraryFragment = Profilragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_explore -> makeCurrentFragment(exploreFragment)
                R.id.menu_subscription -> makeCurrentFragment(subscriptionFragment)
                R.id.menu_library-> makeCurrentFragment(libraryFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }

    }
}