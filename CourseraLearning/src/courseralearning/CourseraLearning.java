/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseralearning;

import java.util.Scanner;

/**
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
        int x = 12;

        if (x > 10) {
            System.out.print("A");

            if (x < 20) {
                System.out.print("E");
            } else {
                System.out.print("X");
            }

        } else {
            System.out.print("Z");
        }

    }

}
