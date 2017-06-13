
package misionerosycanibales;

import java.util.Scanner;

/**
 * Canibales y misioneros por medio de una canoa  tiene que pasar un rio el los requisitos son que no pueden haber mas 
 * canibales que misioneros y que en la canoa tienen que ir dos personas
 * @author Jorge Andrei Bayona leal
 * @licence  https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 */
public class Main {

	
	public static void main(String[] args){
		Nodo ma = new Nodo();
                
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverCC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverCC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverMM();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverMC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverMM();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverCC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes"+ma.resultante());
		ma.moverC();
		System.out.println(ma.imprimirEstado());
		System.out.println("Resultantes:"+ma.resultante());
		ma.moverCC();
		System.out.println(ma.imprimirEstado());
		
	}


}