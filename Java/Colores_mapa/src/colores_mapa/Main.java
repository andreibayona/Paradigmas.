/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colores_mapa;

import java.util.Scanner;

/**
 * colorea el mapa 
 * @author Jorge Andrei Bayona Leal
 * @licence  https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Main ma=new Main();
 
        Scanner sc = new Scanner(System.in);
        System.out.println("obtener datos del mapa:fila ");
        int n;
        n = sc.nextInt();
        System.out.println("obtener datos del mapa: columna");
        int m;
        m = sc.nextInt();
        int matriz[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }
        System.out.println("numero de colores");
        int color;
        color = sc.nextInt();
        ma.GrafoColor(matriz,color);
       

    }
    private int vect, colores;
    private int color[];
    private int Grafo[][];

    public void GrafoColor(int mat[][],int x){
        vect=mat.length;
        colores= x;
        color= new int[x];
        Grafo=mat;
        try {
            Solucion(0);
            System.out.println("no hay solucion al mapa");
        } catch (Exception e) {
            System.out.println("si hay solucion");
            imprimir();
        }
    }
    public void Solucion(int vec) throws Exception{
        if (vec==vect) 
            throw new Exception("solucion");
            
            for (int i = 1; i <= colores; i++) {
                if (verifica(vect, i)) {
                    color[vect] = i;
                    Solucion(vect + 1);
                    color[vect] = 0;
                }
            }
        

    }

    public boolean verifica(int vec, int x) {
        for (int i = 0; i < vec; i++) {
            if (Grafo[vec][i] == 1 && x == color[i]) {
                return false;

            }
            return true;
        }
        return true;
    }
    public void imprimir(){
    for (int i = 0; i < vect; i++) {
        System.out.println("colores"+color[i]+"");
        System.out.println("");
    }
}

}
