package til.com.arch.request;

import til.com.arch.entity.PingResponse;

public interface PingRequest {
    PingResponse execute() throws Exception;
}
