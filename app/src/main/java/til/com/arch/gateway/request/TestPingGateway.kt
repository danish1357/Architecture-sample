package til.com.arch.gateway.request

import til.com.arch.request.PingRequest
import til.com.arch.request.PingResponseListener

class TestPingGateway : RequestPingGateway {
    override fun executePing(pingRequest: PingRequest, pingResponseListener: PingResponseListener) {
        //TODO
    }
}