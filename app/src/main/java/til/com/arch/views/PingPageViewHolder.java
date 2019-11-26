package til.com.arch.views;

import android.view.View;

import til.com.arch.controller.PingController;
import til.com.arch.databinding.ActivityMainBinding;
import til.com.arch.request.URLPingRequest;

public class PingPageViewHolder {

    private ActivityMainBinding viewBinding;

    private PingController pingController;

    public PingPageViewHolder(ActivityMainBinding viewBinding) {
        this.viewBinding = viewBinding;
    }

    void bind(PingController pingController) {
        this.pingController = pingController;
        viewBinding.setViewHolder(this);
        viewBinding.setPing(this.pingController.getPingPresenter().getPingModel());
    }

    void unbind() {
        pingController = null;
    }

    public void onRequestClicked(View view) {
        pingController.submitRequest(view.getContext(), new URLPingRequest("https://www.google.com/"));
    }


    public void onResetClicked(View view) {
        pingController.reset();
    }

}
