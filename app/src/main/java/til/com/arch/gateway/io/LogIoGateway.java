package til.com.arch.gateway.io;

import android.util.Log;

import til.com.arch.entity.PingResponse;

public class LogIoGateway implements IoGateway {
    @Override
    public void write(PingResponse data) {
        Log.v("Data dumped", data.toString());
    }
}
