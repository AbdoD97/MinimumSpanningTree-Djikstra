/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds2.bonus;

/**
 *
 * @author Kondos
 */
public class Vertex {
    
    int num, cost, path;
    Boolean known;

    public Vertex(int num, int cost, int path, Boolean known) {
        this.num = num;
        this.cost = cost;
        this.path = path;
        this.known = known;
    }
    
}
