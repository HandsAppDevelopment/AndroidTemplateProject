package ru.handsapp.template.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.handsapp.template.app.utils.ErrorMessages

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //region Properties

    //endregion

    //region LiveData

    // BottomNavigationView включен по умолчанию на всех фрагментов приложения
    val isBottomNavVisible = MutableLiveData(true)

    // Сообщение об ошибке
    val errorMessageRes = MutableLiveData<Int>()
    var messageError = MutableLiveData<ErrorMessages>()
    val errorMessage = MutableLiveData<String>()

    //endregion

    //region Interactions

    //endregion
}