/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds2.bonus;

import java.util.Scanner;

/**
 *
 * @author Kondos
 */
public class DS2Bonus {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        if(args.length ==0)
        {
                        Scanner sc = new Scanner(System.in);
                System.out.println("Please enter vertices number  ");
              int  rows= sc.nextInt();
                              System.out.println("Please enter starting node  ");

              int start = sc.nextInt();
   MST a = new MST (rows,start);
   a.fillInput(args);
     a.node();
   a.print();
        }
        else
        {
               MST a = new MST ((int) Math.sqrt(args.length-1),Integer.parseInt(args[args.length-1]));
   a.fillInput(args);
     a.node();
   a.print();
        }
 
    }
    
}
