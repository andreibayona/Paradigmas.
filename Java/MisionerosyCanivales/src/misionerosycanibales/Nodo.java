/*
.
 */
package misionerosycanibales;

/**
 *
 * @author Jorge Andrei Bayona leal
 * @licencia  https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 */
public class Nodo {

    // movimientos posibles  C representa canivales u M representa missioneros 
    public static String C = "C"; // un solo canibal 
    public static String CC = "CC"; // 2 Canibales
    public static String M = "M";   // 1 misionero
    public static String MM = "MM"; // 2 missioneros
    public static String MC = "MC"; // 1 misionero y un canibal

    private String ultimomovimiento; // guarda el ultimo movimiento

    //Numero maximo de personas que puede trasladar
    private final int maximoCanoa = 2;

    public int getMaximoCanoa() {
        return maximoCanoa;
    }

 

  

    // [misioneros,canibales,barca] representa la orilla izquierda
    private int misioneros;
    private int canibales;
    private int canoa; //1 orilla izquierda, 0 orilla derecha

    public Nodo() {
        //3 misioneros, 3 canibales y la barca en la orilla izquierda
        misioneros = 3;
        canibales = 2;
        canoa = 1;
        ultimomovimiento = "";
    }

    public Nodo(Nodo estado) {
        ultimomovimiento = estado.ultimomovimiento;
        misioneros = estado.misioneros;
        canibales = estado.canibales;
        canoa = estado.canoa;
    }

    public int getMisioneros() {
        return misioneros;
    }

    public int getCanibales() {
        return canibales;
    }

    public int getCanoa() {
        return canoa;
    }

   
    
// contiene los estados de los get los cuales estan los intrumentos en el algoritmo
    public int[] obtenerEstado() {
        int[] estado = new int[3];
        estado[0] = getMisioneros();
        estado[1] = getCanibales();
        estado[2] = getCanoa();
        return estado;
    }

  
  
    
    
    
//  movimientos  
    public void MoverM() {
        if (getCanoa() == 1) {
            canoa = 0;
            misioneros--;
        } else {
            canoa = 1;
            misioneros++;
        }
        ultimomovimiento = M;
    }

    public void moverMM() {
        if (getCanoa() == 1) {
            canoa = 0;
            misioneros = getMisioneros() - 2;
        } else {
            canoa = 1;
            misioneros = getMisioneros() + 2;
        }
        ultimomovimiento = MM;
    }

    public void moverC() {
        if (getCanoa() == 1) {
            canoa = 0;
            canibales--;
        } else {
            canoa = 1;
            canibales++;
        }
        ultimomovimiento = C;
    }

    public void moverCC() {
        if (getCanoa() == 1) {
            canoa = 0;
            canibales = getCanibales() - 2;
        } else {
            canoa = 1;
            canibales = getCanibales() + 2;
        }
        ultimomovimiento = CC;
    }

    public void moverMC() {
        if (getCanoa() == 1) {
            canoa = 0;
            misioneros--;
            canibales--;
        } else {
            canoa = 1;
            misioneros++;
            canibales++;
        }
        ultimomovimiento = MC;
    }

    public boolean puedeMover(String mov) {
        if (ultimomovimiento.equals(mov)) {
            return false; //evito repetir ultimo
        }
        if (mov.equals(M)) {
            if (getCanoa() == 1) {
                return getMisioneros() >= 1
                        && !estadoPeligroso(misioneros - 1, canibales);
            } else {
                return 3 - getMisioneros() >= 1
                        && !estadoPeligroso(misioneros + 1, canibales);
            }
        }
        if (mov.equals(MM)) {
            if (getCanoa() == 1) {
                return getMisioneros() >= 2
                        && !estadoPeligroso(misioneros - 2, canibales);
            } else {
                return 3 - getMisioneros() >= 2
                        && !estadoPeligroso(misioneros + 2, canibales);
            }
        }
        if (mov.equals(C)) {
            if (getCanoa() == 1) {
                return getCanibales() >= 1
                        && !estadoPeligroso(misioneros, canibales - 1);
            } else {
                return 3 - getCanibales() >= 1
                        && !estadoPeligroso(misioneros, canibales + 1);
            }
        }
        if (mov.equals(CC)) {
            if (getCanoa() == 1) {
                return getCanibales() >= 2
                        && !estadoPeligroso(misioneros, canibales - 2);
            } else {
                return 3 - getCanibales() >= 2
                        && !estadoPeligroso(misioneros, canibales + 2);
            }
        }
        if (mov.equals(MC)) {
            if (getCanoa() == 1) {
                return getMisioneros() >= 1 && getCanibales() >= 1
                        && !estadoPeligroso(misioneros - 1, canibales - 1);
            } else {
                return 3 - getMisioneros() >= 1 && 3 - getCanibales() >= 1
                        && !estadoPeligroso(misioneros + 1, canibales + 1);
            }

        }
        return false;
    }

    private boolean estadoPeligroso(int m, int c) {// restriciones que tiene el problema
        return (m < c && m != 0) || (m > c && m != 3);
    }

    public int resultante() {// muestra la posicion resultante
        int res = getMisioneros() + getCanibales();
        return res;
    }
      public String imprimirEstado() {//imprime el estado
        int[] estado = obtenerEstado();
        return "M:" + Math.abs(estado[0]) + " C:" + Math.abs(estado[1]) + " Canoa:" + Math.abs(estado[2]) + "-------" + "M:" + (3 - estado[0]) + " C:" + (2 - estado[1]) + " Canoa:" + (1 - estado[2]);
    }
}
