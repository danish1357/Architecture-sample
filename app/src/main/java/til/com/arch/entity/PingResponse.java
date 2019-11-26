package til.com.arch.entity;

public class PingResponse {
    private String data;

    public PingResponse(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}
