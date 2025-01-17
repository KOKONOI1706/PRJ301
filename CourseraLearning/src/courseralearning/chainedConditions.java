/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseralearning;

/**
 *
 * @author GIGABYTE
 */
public class chainedConditions {

    public void whereToGo(int a) {
        int dollarsToSpareInPocketToday = 500;

        // 1st level "if" condition
        if (dollarsToSpareInPocketToday < 300) {
            System.out.println("I will go to my parents place. No diversions.");
        } else {
            //corresponding "else" body or area of control of 1st "if"

            // checking if interested in games based on luck
            boolean interestedInLuckAndFun = true;

            //2nd level "if" condition
            if (interestedInLuckAndFun) {
                System.out.println("I will go to Las Vegas.");
            } else {
                // 2nd level "else" of 2nd level "if" 

                //checking if interested in history
                boolean interestedInHistory = true;

                //3rd level "if" condition inside 2nd level "else"
                if (interestedInHistory) {
                    System.out.println("I will visit Hoover Dam");
                } else {
                    //3rd level "else" of 3rd level "if"
                    System.out.println("I will visit Area 51 and observe some aliens.");
                }

            }
        }
    }
}
