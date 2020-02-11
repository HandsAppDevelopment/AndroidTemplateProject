package ru.handsapp.template.presentation

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.distribute.Distribute
import ru.handsapp.template.BuildConfig
import ru.handsapp.template.R
import ru.handsapp.template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //region Properties

    private val INTRO_DELAY: Long = 1000 // 1 sec

    private lateinit var navController: NavController
    private lateinit var navBottomView: BottomNavigationView

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodelmain = mainViewModel

        navBottomView = binding.bottomNavView
        navController = findNavController(R.id.nav_host_fragment)
        navBottomView.setupWithNavController(navController)

        // Убрать FragmentIntro из BackStack
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.navigation_intro, true).build()

        Handler().postDelayed({
            navController.navigate(R.id.navigation_order_list, null, navOptions)
        }, INTRO_DELAY)
    }

    //endregion

    //region Private Methods

    //endregion

    //region Other

    // Управление кнопкой "Назад" в toolbar используя NavController
    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

    // Переходим по меню используя NavController
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    //endregion
}
