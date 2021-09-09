/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

/**
 *
 * @author joam0
 */
public class Sim {
    int ancho; 
    int largo;
    int[][] tablero;

    public Sim(int width, int height) {
        this.ancho = width;
        this.largo = height;

        this.tablero = new int[width][height];
    }
}
