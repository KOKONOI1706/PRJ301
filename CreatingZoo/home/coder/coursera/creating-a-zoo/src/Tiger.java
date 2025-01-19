public abstract class Tiger extends Animal implements Eat,Walk{
    private int numberOfStripes = 456;
    private double speed = 123;
    private int soundLevelOfRoar = 50;

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
    public void walking() {

    }
}
