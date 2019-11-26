package til.com.arch.gateway.request

import til.com.arch.request.PingResponseListener
import til.com.arch.request.PingRequest

interface RequestPingGateway {
     fun executePing(pingRequest: PingRequest, pingResponseListener: PingResponseListener)
}