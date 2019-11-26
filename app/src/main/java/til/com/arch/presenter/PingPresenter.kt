package til.com.arch.presenter

import til.com.arch.entity.PingPage
import til.com.arch.entity.PingResponse
import til.com.arch.request.PingResponseListener
import java.lang.Exception

class PingPresenter : PingResponseListener {

    private val pingModel: PingPage = PingPage()

    fun onStartLoading() {
        pingModel.progressBarVisible = true
        pingModel.requestButtonVisible = false
        pingModel.messageDisplayed = "Loading.."
    }

    override fun onSuccessfulResponse(pingResponse: PingResponse?) {
        pingModel.progressBarVisible = false
        pingModel.requestButtonVisible = false
        pingModel.resetButtonVisible = true
        pingModel.messageDisplayed = "success"
    }

    override fun onError(exception: Exception) {
        pingModel.progressBarVisible = false
        pingModel.requestButtonVisible = false
        pingModel.resetButtonVisible = true
        pingModel.messageDisplayed = exception.message
    }

    fun onReset() {
        pingModel.messageDisplayed = "Welcome"
        pingModel.requestButtonVisible = true
        pingModel.resetButtonVisible = false
    }

    fun getPingModel(): PingPage? {
        return pingModel
    }


}