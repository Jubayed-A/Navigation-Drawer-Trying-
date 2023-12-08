package com.example.tryingnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // id declaration
        drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        navigationView = findViewById<NavigationView>(R.id.navigationView)
        toolbar = findViewById<Toolbar>(R.id.toolbar)

        // step 1 setUp toolbar
        setSupportActionBar(toolbar)

        // step 2  action bar toggle
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.OpenDrawer,
            R.string.CloseDrawer
        )

        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        // step 3 click on item
        navigationView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.optNotes -> {
                    Toast.makeText(this, "Notes open Successfully", Toast.LENGTH_SHORT).show()
                }

                R.id.optHome -> {
                    Toast.makeText(this, "Home open Successfully", Toast.LENGTH_SHORT).show()
                }

                R.id.optSetting -> {
                    Toast.makeText(this, "Setting open Successfully", Toast.LENGTH_SHORT).show()
                }

                R.id.optLogout -> {
                    Toast.makeText(this, "Logout open Successfully", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show()
                }
            }

            // if item select drawer close
            drawerLayout.closeDrawer(GravityCompat.START)

            true
        }

    }

    // step 4 on back method code here
    override fun onBackPressed() {
        //  check that drawer is open or not when user press back button
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

}