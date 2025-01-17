/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseralearning;

import java.util.Scanner;

/**
 *
 * @author GIGABYTE
 */
public class CourseraLearning {

    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        chainedConditions chain = new chainedConditions();
        chain.whereToGo(300);
        int loopVar = 12;

        do {
            System.out.println("The number: " + loopVar + " gives the condition (loopVar <10) as: " + (loopVar < 10));
        } while (loopVar < 10);

    }

}
