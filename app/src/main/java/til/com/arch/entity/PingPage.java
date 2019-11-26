package til.com.arch.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import til.com.arch.BR;

public class PingPage extends BaseObservable {
    Boolean requestButtonVisible;
    Boolean progressBarVisible;
    Boolean resetButtonVisible;
    String messageDisplayed;

    public PingPage() {
        this(true, false, false, "Welcome");
    }

    public PingPage(Boolean requestButtonVisible, Boolean progressBarVisible, Boolean resetButtonVisible, String messageDisplayed) {
        this.requestButtonVisible = requestButtonVisible;
        this.progressBarVisible = progressBarVisible;
        this.resetButtonVisible = resetButtonVisible;
        this.messageDisplayed = messageDisplayed;
    }

    @Bindable
    public Boolean getRequestButtonVisible() {
        return requestButtonVisible;
    }

    public void setRequestButtonVisible(Boolean requestButtonVisible) {
        this.requestButtonVisible = requestButtonVisible;
        notifyPropertyChanged(BR.requestButtonVisible);
    }

    @Bindable
    public Boolean getProgressBarVisible() {
        return progressBarVisible;
    }

    public void setProgressBarVisible(Boolean progressBarVisible) {
        this.progressBarVisible = progressBarVisible;
        notifyPropertyChanged(BR.progressBarVisible);
    }

    @Bindable
    public Boolean getResetButtonVisible() {
        return resetButtonVisible;
    }

    public void setResetButtonVisible(Boolean resetButtonVisible) {
        this.resetButtonVisible = resetButtonVisible;
        notifyPropertyChanged(BR.resetButtonVisible);
    }

    @Bindable
    public String getMessageDisplayed() {
        return messageDisplayed;
    }

    public void setMessageDisplayed(String messageDisplayed) {
        this.messageDisplayed = messageDisplayed;
        notifyPropertyChanged(BR.messageDisplayed);
    }
}
