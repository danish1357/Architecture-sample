package til.com.arch.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import til.com.arch.entity.PingResponse;

public class URLPingRequest implements PingRequest {
    String uRL;

    public URLPingRequest(String uRL) {
        this.uRL = uRL;
    }

    @Override
    public PingResponse execute() throws IOException {
        URL url = null;
            url = new URL(uRL);
        HttpURLConnection conn = null;
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

        String line = null;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            builder.append(line);
            builder.append("\n");
        }
        String html = builder.toString();
        return new PingResponse(html);
    }
}
