import java.sql.SQLOutput;

public class WatADriver extends Robot {


    /** TODO 12: Make this class "WatADriver"
     *           a child class of
     *           the "Robot" class
     */

    /**
     * TODO 17: Implement the abstract methods
     *           methods setChoice and takeAction
     *           of the parent class "Robot"
     */
    @Override
    public void takeAction() {
        System.out.println("Watadriver will drive or fly here");
    }

    @Override
    public void setChoice() {
        System.out.println("Inside choice setting of WatADriver");
    }
    /** TODO 18:  Inside the method "setChoice"
     *             display
     *            "Inside choice setting of WatADriver”
     *            and
     *            inside "takeAction" display “WatADriver will
     *            drive or fly here”
     */


}

