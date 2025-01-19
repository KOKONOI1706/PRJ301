public abstract class Tiger extends Animal implements Eat,Walk{
    private int numberOfStripes;
    private double speed;
    private int soundLevelOfRoar ;

    public Tiger() {
       super("Tiger");
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getSoundLevelOfRor() {
        return soundLevelOfRor;
    }

    public void setSoundLevelOfRor(int soundLevelOfRor) {
        this.soundLevelOfRor = soundLevelOfRor;
    }
    @Override
    public void eatingCompleted(){
        System.out.println("Tiger: I have eaten meat");
    }
    @Override
    public void wallk(){
        System.out.println("I am walking at the speed" + speed + "mph");

    }
}
