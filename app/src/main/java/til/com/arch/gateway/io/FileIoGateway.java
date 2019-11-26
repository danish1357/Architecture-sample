package til.com.arch.gateway.io;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;

import til.com.arch.entity.PingResponse;

public abstract class FileIoGateway implements IoGateway {
    private String fileName;

    public FileIoGateway(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(PingResponse response) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput(fileName, Context.MODE_PRIVATE));
            outputStreamWriter.write(response.getData());
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    protected abstract Context getContext();
}
