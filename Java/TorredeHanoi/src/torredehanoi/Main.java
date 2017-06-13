/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torredehanoi;

import java.util.Scanner;

/**
 *
 * @author andrei metodo recursivo para el problema de la torre de hanoi este se
 * basa en un aspecto muy importante que es tener tres torres y n discos los
 * cuales debe hacer ciertos movimientos para solucionar este problema. el
 * problema se realiza ,con recursividad
 * @author Jorge Andrei Bayona leal
 * @licencia @licence https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite el numero de discos que debe ser mayor a 3");
        int n;
        n = sc.nextInt();

        Main solucion = new Main();
        solucion.solucionHanio(n, 1, 2, 3);// ingresa los discos y la columna 1,2,4 
    }

    public void solucionHanio(int discos, int columna1, int columna2, int columna3) {
        // si llega a ser ==1 tiene que mover de la 1 a la 2
        if (discos == 1) {// caso base 
            System.out.println(" mover discos de la columna " + columna1 + " a la columna " + columna3);
        } else {
            //dominio
            // si no llega a ser asi se disminuye 1 y pasa a ser de la  yse cambian las posiciones
            solucionHanio(discos - 1, columna1, columna3, columna2);// se alterna las columnas 
            System.out.println(" mover discos de la columna " + columna1 + " a la columna " + columna3);
            solucionHanio(discos - 1, columna2, columna1, columna3); // se vuelve  alternar 
        }
    }

}
