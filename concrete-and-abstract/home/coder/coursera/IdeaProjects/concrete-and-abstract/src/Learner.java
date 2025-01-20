//TODO 12: make Learner class implement Assessment interface
public class Learner {
    //TODO 1: declare instance variables
    Learner(...) {
        //TODO 2: complete constructor
    }

    public String toString() {
        return "Name: " + this.name + " " + "Course: " + this.course.subject.title;
    }
}

    //TODO 13: override assignmentScore() method

    //TODO 14: override quizScore() method

    public double calculateGrade() {
        int maxAssignmentMarks, maxQuizMarks;
        //TODO 17: calculate gradeScore as per the instructions above
        return this.gradeScore;
    }
}
