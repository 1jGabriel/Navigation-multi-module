package io.jgabriel.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, navController)
        btm_nav_main.setupWithNavController(navController)
        changeBottomNavigationFragment()
    }

    private fun changeBottomNavigationFragment() {
        btm_nav_main.setOnNavigationItemSelectedListener {
            if (btm_nav_main.menu.findItem(it.itemId).isChecked) {
                false
            } else {
                when (it.itemId) {
                    R.id.nav_feature_one -> {
                        navController.navigate(R.id.nav_feature_one)
                        true
                    }
                    R.id.nav_feature_two -> {
                        navController.navigate(R.id.nav_feature_two)
                        true
                    }
                    R.id.nav_feature_three -> {
                        navController.navigate(R.id.nav_feature_three)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
