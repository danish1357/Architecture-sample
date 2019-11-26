package til.com.arch.gateway.io;


import til.com.arch.entity.PingResponse;

public interface IoGateway {
    void write(PingResponse data);
}
