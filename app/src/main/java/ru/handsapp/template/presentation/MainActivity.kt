package ru.handsapp.template.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.handsapp.template.R
import ru.handsapp.template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //region Properties

    private val introDelay: Long = 1000 // 1 sec

    private lateinit var navController: NavController
    private lateinit var navBottomView: BottomNavigationView

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
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

        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.navigation_order_list, null, navOptions)
        }, introDelay)

        // Наблюдение за сообщениями об ошибках
        mainViewModel.errorMessageRes.observe(this, { error ->
            Toast.makeText(this, resources.getText(error), Toast.LENGTH_SHORT).show()
        })

        mainViewModel.errorMessage.observe(this, { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        })

        mainViewModel.messageError.observe(this, { error ->
            Toast.makeText(this, resources.getText(error.messageRes), Toast.LENGTH_SHORT).show()
        })
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
