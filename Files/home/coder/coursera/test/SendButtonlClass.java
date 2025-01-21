class SendButtonlClass extends AbstractButtonClass{
    String sendTo;
    String message;

    @Override
    public void buttonPressed() {
        System.out.println("Sending" + this.message + " to " + this.sendTo);
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }
}
