package til.com.arch.controller

import android.content.Context
import til.com.arch.request.PingRequest
import til.com.arch.interpreter.PingRequestInteractor
import til.com.arch.presenter.PingPresenter

class PingController(executePingPresenter: PingPresenter, pingRequestInteractor: PingRequestInteractor) {

    private val pingPresenter: PingPresenter = executePingPresenter
    private val pingRequestInteractor: PingRequestInteractor = pingRequestInteractor

    fun submitRequest(context: Context, pingRequest: PingRequest) {
        pingPresenter.onStartLoading()
        pingRequestInteractor.executePing(pingRequest, context, pingPresenter)
    }

    fun reset() {
        pingPresenter.onReset()
    }

    fun getPingPresenter(): PingPresenter? {
        return pingPresenter
    }

}

