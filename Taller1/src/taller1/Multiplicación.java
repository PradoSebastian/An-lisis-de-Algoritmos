/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author prado
 */
public class Multiplicación 
{
    
    public static void main(String[] args) 
    {
        Multiplicación m = new Multiplicación();
    }
    
    public Multiplicación()
    {
        Scanner leer = new Scanner(System.in);
        
//        System.out.println("Ingrese el primer factor: ");
//        int primerI = leer.nextInt();
//        
//        System.out.println("Ingrese el segundo factor: ");
//        int segundoI = leer.nextInt();
//                
//        ArrayList<Integer> resultado = multiplicar(cambiarItoA(primerI), cambiarItoA(segundoI));
//        
//        System.out.println("");
//              
//        System.out.println("El resultado del producto es: " + cambiarAtoI(resultado));
    }
    
    private ArrayList<Integer> cambiarItoA(int numero)
    {
        ArrayList<Integer> arreglo = new ArrayList<>();
         
        int n;
         
        do
        {
            n = numero%10;
            numero /= 10;
            arreglo.add(n);
        }while(numero != 0);
         
        Collections.reverse(arreglo);
                
        return arreglo; 
    }
    
     private int cambiarAtoI(ArrayList<Integer> numero)
    {
        int resultado = 0, c = 1;
        
        for (int i = numero.size(); i > 0; i--) 
        {
            resultado += numero.get(i-1) * c ;
            c *= 10;
        }
        
        return resultado;
    }
     
//    private ArrayList<Integer> multiplicar (ArrayList<Integer> primero, ArrayList<Integer> segundo)
//    {
//        ArrayList<Integer> resultado = new ArrayList<>();
//        resultado.add(0);
//        ArrayList<Integer> subRes = new ArrayList<>();
//        
//        int tamA = primero.size(), tamB = segundo.size();
//        
//        int k, j, c, n1 = 0, d = 0;
//        
//        if(tamA == tamB)
//        {
//            for(int i=tamB; i>0; i--)
//            {
//                j = segundo.get(i-1);
//                
//                for(int m = 0; m<n1; m++)
//                {
//                    subRes.add(0);
//                }
//                
//                for(int l = tamA; l>0; l--)
//                {                    
//                    k = primero.get(l-1);
//                    c = k*j + d;
//                    subRes.add(c%10);
//                    d = c/10;
//                }
//                subRes.add(d);
//                n1++;
//                Collections.reverse(subRes);
//                subRes = cambiarItoA(cambiarAtoI(subRes));
//                resultado = Suma.sumar(subRes, resultado);
//            }
//        }
//        
//        return resultado;
//    }
    
}
