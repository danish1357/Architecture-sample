package til.com.arch.gateway.request

import til.com.arch.request.PingResponseListener
import til.com.arch.request.PingRequest

class RequestURLPingRequestGateway : RequestPingGateway {
    override fun executePing(pingRequest: PingRequest, pingResponseListener: PingResponseListener) {
        Thread(Runnable {
            try {
                pingResponseListener.onSuccessfulResponse(pingRequest.execute())
            } catch (e: Exception) {
                pingResponseListener.onError(e)
            }
        }).start()
    }
}