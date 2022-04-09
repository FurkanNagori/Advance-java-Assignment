package bean;

public class MessageBean {
    private String message;

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    private String buttonText;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setButtonAction(String buttonAction) {
        this.buttonAction = buttonAction;
    }

    public String getMessage() {
        return message;
    }

    public String getButtonAction() {
        return buttonAction;
    }

    private String buttonAction;
}
