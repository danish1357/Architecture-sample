package til.com.arch.views;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import til.com.arch.R;
import til.com.arch.controller.PingController;
import til.com.arch.databinding.ActivityMainBinding;
import til.com.arch.gateway.io.FileIoGateway;
import til.com.arch.gateway.request.RequestURLPingRequestGateway;
import til.com.arch.interpreter.PingRequestInteractor;
import til.com.arch.presenter.PingPresenter;

public class MainActivity extends AppCompatActivity {

    private PingPageViewHolder pingPageViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        pingPageViewHolder = new PingPageViewHolder(binding);
        pingPageViewHolder.bind(new PingController(new PingPresenter(), new PingRequestInteractor(new RequestURLPingRequestGateway(), new FileIoGateway("pingresponse.bin") {
            @Override
            protected Context getContext() {
                return MainActivity.this;
            }
        })));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pingPageViewHolder.unbind();
    }
}
