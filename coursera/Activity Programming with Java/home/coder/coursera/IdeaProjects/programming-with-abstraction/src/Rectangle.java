public class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float calculateArea() {
        float area = width * height;
        return area;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with width: " + this.width + " height: " + this.height);
    }

    @Override
    public String lineColor() {
        return "";
    }

    @Override
    public float perimeter() {
        return 2 * this.width + 2 * this.height;
    }
}
