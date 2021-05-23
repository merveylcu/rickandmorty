package com.merveylcu.rickandmorty.service.util

import android.content.Context
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.core.AppConstants
import com.merveylcu.rickandmorty.util.NetworkManager
import com.merveylcu.rickandmorty.util.extensions.dialog
import com.merveylcu.rickandmorty.util.extensions.getStr
import com.merveylcu.rickandmorty.util.extensions.noNetworkConnectivityError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object NetworkHandler {

    suspend fun <T> sendRequest(
        context: Context,
        request: suspend () -> Response<T>,
        isAsync: Boolean = false
    ): AppResult<T> {
        return withContext(Dispatchers.IO) {
            if (NetworkManager.isNetworkAvailable(context)) {
                if (!isAsync) {
                    AppConstants.lastActivity?.showLoading()
                }
                try {
                    val response = request.invoke()
                    if (!isAsync) {
                        AppConstants.lastActivity?.hideLoading()
                    }
                    if (response.isSuccessful) {
                        handleSuccess(response)
                    } else {
                        handleApiError(response)
                    }
                } catch (e: Exception) {
                    if (!isAsync) {
                        AppConstants.lastActivity?.hideLoading()
                        AppConstants.lastActivity?.dialog(context.getStr(R.string.error_occurred)) {
                            positiveButton(context.getStr(R.string.ok)) { }
                        }?.show()
                    }
                    AppResult.Error(e)
                }
            } else {
                context.noNetworkConnectivityError()
            }
        }
    }

    fun <T> handleApiError(resp: Response<T>): AppResult.Error {
        val error = ApiErrorUtils.parseError(resp)
        return AppResult.Error(Exception(error.message))
    }

    fun <T> handleSuccess(response: Response<T>): AppResult<T> {
        response.body()?.let {
            return AppResult.Success(it)
        } ?: return handleApiError(response)
    }
}