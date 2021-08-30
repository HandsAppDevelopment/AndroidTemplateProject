package ru.handsapp.template.presentation.fragments.order_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.handsapp.template.app.utils.ErrorHandler
import ru.handsapp.template.presentation.MainViewModel

class OrderListViewModel(application: Application) : AndroidViewModel(application) {

    //region Properties

    lateinit var errorHandler: ErrorHandler

    //endregion

    //region LiveData

    // Иницилизация ErrorHandler
    fun setErrorHandler(mainViewModel: MainViewModel) {
        errorHandler = ErrorHandler(mainViewModel)
    }

    //endregion

    //region Interactions

    //endregion
}