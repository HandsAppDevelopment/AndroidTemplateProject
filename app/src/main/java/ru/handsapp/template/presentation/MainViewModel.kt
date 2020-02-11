package ru.handsapp.template.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //region Properties

    //endregion

    //region LiveData

    // BottomNavigationView включен по умолчанию на всех фрагментов приложения
    private val isBottomNavVisible = MutableLiveData<Boolean>(true)

    fun setBottomNavVisible(isVisible: Boolean) {
        isBottomNavVisible.value = isVisible
    }

    fun isBottomNavVisible(): LiveData<Boolean> = isBottomNavVisible

    //endregion

    //region Interactions

    //endregion
}