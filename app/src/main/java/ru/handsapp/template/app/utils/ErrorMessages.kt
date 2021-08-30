package ru.handsapp.template.app.utils

import androidx.annotation.StringRes
import ru.handsapp.template.R

enum class ErrorMessages(
    @StringRes val messageRes: Int
) {
    NoInternetConnection(R.string.internet_connection_error_text);
}