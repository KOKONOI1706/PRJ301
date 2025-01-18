package test;

class Parent {
    protected String protectedField = "protected";
    private String privateField = "private";
    public String publicField = "public";
}

class Child extends Parent {
    public void printSuperFields() {
        System.out.println(super.protectedField);
    }
}

public class ModuleQuiz_M3L3 {
    public static void main(String[] args) {
        Child child = new Child();
        child.printSuperFields();

    }
}