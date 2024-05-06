package com.example.libreriap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libreriap2.adapter.BookAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el HomeFragment al iniciar la MainActivity
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
        
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Mostrar el fragmento o Activity Home
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, HomeFragment())
                    fragmentTransaction.commit()
                    true
                }
                R.id.navigation_books -> {
                    // Mostrar el fragmento BookListFragment
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, BookListFragment())
                    fragmentTransaction.commit()
                    true
                }
                else -> false
            }
        }

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        // Configurar el ActionBarDrawerToggle
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        // Configurar el click del elemento del menú
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_about -> {
                    // Abrir la Activity AcercaDeActivity
                    startActivity(Intent(this, AcercaDeActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

}