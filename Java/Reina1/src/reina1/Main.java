/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reina1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author andre
 */
public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   static  PrintWriter out= new PrintWriter(System.out);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int x0;
        int x1;
        int y0;
        int y1;
        String reina="";
        
        while(!(reina=br.readLine()).equals("0 0 0 0")){
            String[] contenedorR= reina.split("a");
            x0= Integer.parseInt(contenedorR[0]);
            y0= Integer.parseInt(contenedorR[1]);
            x1= Integer.parseInt(contenedorR[2]);
            y1= Integer.parseInt(contenedorR[3]);
            
            if (x0==x1 && y0==y1) {
             out.println(0);
            }else if (x0 == x1 || y0 == y1 || Math.abs(y1 - y0) == Math.abs(x1 - x0)) {
                out.println(1);
            }else{
                out.println(2);
            }
                  
            
        }
        // TODO code application logic here
    }
    
}
