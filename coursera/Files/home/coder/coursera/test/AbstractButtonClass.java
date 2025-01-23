import java.awt.event.ActionEvent;

abstract class AbstractButtonClass {
    String caption;
    public abstract void buttonPressed();

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
