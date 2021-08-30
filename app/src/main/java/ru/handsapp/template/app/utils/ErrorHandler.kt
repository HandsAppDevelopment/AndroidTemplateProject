package ru.handsapp.template.app.utils

import ru.handsapp.template.R
import ru.handsapp.template.presentation.MainViewModel

class ErrorHandler(private val viewModel: MainViewModel) {

    fun handleHTTPStatusCode(statusCode: Int) {

        when (statusCode) {
            400 -> {
                viewModel.errorMessageRes.value = R.string.network_error_message_400
                LogHandler.d("srv", "error 400 - Не заполнены обязательные поля")
            }
            else -> {
                viewModel.errorMessageRes.value = R.string.network_error_message_default
                LogHandler.d("srv", "error default - Не известная ошибка")
            }
        }
    }

    fun handleThrowable(t: Throwable) {
        t.localizedMessage?.let {
            viewModel.errorMessage.value = it
        }
    }

    fun handleMessageError(text: ErrorMessages) {
        viewModel.messageError.value = text
    }

    fun handleMessageText(text: String) {
        viewModel.errorMessage.value = text
    }
}