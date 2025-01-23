public class Circle extends Shape {
    private float radius;

    public Circle(float r) {
        this.radius = r;
    }

    @Override
    public float calculateArea() {
        float area = (float) Math.PI * this.radius * this.radius;
        return area;
    }

    public void draw() {
        System.out.println("Drawing Circle with Radius: " + this.radius);
    }

    @Override
    public String lineColor() {
        return "cc";
    }

    @Override
    public float perimeter() {
        return (float) Math.PI * this.radius;
    }

}
