package til.com.arch.interpreter

import android.content.Context
import til.com.arch.entity.PingResponse
import til.com.arch.gateway.io.IoGateway
import til.com.arch.gateway.request.RequestPingGateway
import til.com.arch.request.PingRequest
import til.com.arch.request.PingResponseListener
import til.com.arch.util.Utils
import java.lang.Exception

class PingRequestInteractor(requestPingGateway: RequestPingGateway, ioGateway: IoGateway) {
    private val requestPingGateway: RequestPingGateway = requestPingGateway
    private val ioGateway: IoGateway = ioGateway

    fun executePing(pingRequest: PingRequest, context: Context, pingResponseListenerExternal: PingResponseListener) {

        if (!Utils.hasInternetAccess(context)) {
            pingResponseListenerExternal.onError(Exception("Network Unavailable"))
            return
        }

        val pingResponseListener: PingResponseListener = object : PingResponseListener {
            override fun onError(exception: Exception) {
                pingResponseListenerExternal.onError(exception)
            }

            override fun onSuccessfulResponse(pingResponse: PingResponse) {
                pingResponseListenerExternal.onSuccessfulResponse(pingResponse)
                ioGateway.write(pingResponse)
            }
        }

        requestPingGateway.executePing(pingRequest, pingResponseListener)
    }
}