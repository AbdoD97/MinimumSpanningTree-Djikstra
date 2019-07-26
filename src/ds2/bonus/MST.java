/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds2.bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kondos
 */
public class MST {

    int rows, start;
    int[][] input;
            ArrayList<Vertex> custArr = new ArrayList<Vertex>();


    public MST(int rows, int start) {
        this.rows = rows;

        this.start = start;
        input = new int[rows][rows];
    }

    void fillInput(String[] args) {
        if (args.length== 0 ){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.rows; j++) {
                System.out.println("Input element on row " + i + " on column " + j);
                Scanner sc = new Scanner(System.in);
                // System.out.println(rows);
                input[i][j] = sc.nextInt();
            }
        }}
        else 
        {
            int filler = 0;
            for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.rows; j++) {
                
                // System.out.println(rows);
                input[i][j] = Integer.parseInt(args[filler]);
                filler++;
                
            }
        }
        }
    }

    void print() {
        int sum=0;
        System.out.println(Arrays.deepToString(input));
        System.out.println(" Number of Vertices = " + custArr.size());
        for(int i =0; i<custArr.size(); i++)
        {
                System.out.println(custArr.get(i).num + " " + custArr.get(i).known + " " + custArr.get(i).cost + " " + custArr.get(i).path + " ");
        }
        for(int i =0; i<custArr.size(); i++)
        {
            if(custArr.get(i).cost != 9999)
            sum+= custArr.get(i).cost;
            
        }
        System.out.println("Total Weight = " + sum);
    }

    void node() {

        for (int m = 0; m < rows; m++) {

            Vertex verta = new Vertex(m, 9999, -1, false);
            custArr.add(verta);
        }
        custArr.get(start).cost = 0;

        findMin(start);
    }

    void findMin(int cheapest) {
       custArr.get(cheapest).known = true;

        for (int x = 0; x < rows; x++) {
            if (input[cheapest][x] <= custArr.get(x).cost && custArr.get(x).known == false && input[cheapest][x] !=0) {
                custArr.get(x).cost = input[cheapest][x];
                custArr.get(x).path = cheapest;

            }
            
        }
        for(int i =0; i<custArr.size(); i++){
        if (custArr.get(i).known == false && !isisolated(i))
        {
        findCheap();
        }
        }
    }
    void findCheap()
    {
        int cheap = 9999;
        int index = 0;
        for (int x=0; x<custArr.size(); x++)
        {
            if(custArr.get(x).cost < cheap && custArr.get(x).known == false)
                    {
                        cheap = custArr.get(x).cost;
                        index = custArr.get(x).num;
                    }
        }
        findMin(index);
    }

    boolean isisolated(int i)
    {
        for (int x=0; x<rows; x++)
        {
            if (input[i][x] !=0)
                return false;
        }
        
        return true;
        
    }
}
