package til.com.arch.request;

import til.com.arch.entity.PingResponse;

public interface PingResponseListener {

    void onSuccessfulResponse(PingResponse pingResponse);

    void onError(Exception exception);
}
