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
        char grade ;
        int score = 89;
        switch (score / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        System.out.println(grade);
    }
}