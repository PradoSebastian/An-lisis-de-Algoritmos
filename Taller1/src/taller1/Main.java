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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Main t = new Main();
        
    }
    
    public Main()
    {  
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese 1 para sumar o 2 para multiplicar: ");
        int opcion = leer.nextInt();
        
        ArrayList<Integer> resultado, primerI, segundoI;
        
        System.out.println("");
        
        int n1, n2;
        
        if(opcion == 1)
        {
            System.out.println("Ingrese la cantidad de digitos del primer número: ");
            n1 = leer.nextInt();
            primerI = generarAleatorio(n1);
            //System.out.println("Primer número: " + primerI);
            Imprimir(primerI);
            System.out.println("\n");
            
            System.out.println("Ingrese la cantidad de digitos del segundo número: ");
            n2 = leer.nextInt();
            segundoI = generarAleatorio(n2);
            //System.out.println("Segundo número: " + segundoI);
            Imprimir(segundoI);
            System.out.println("\n");
            
            resultado = sumar(primerI, segundoI);
            
            //System.out.println("Resultado: " + resultado); 
            Imprimir(resultado);
            System.out.println("\n");
        }
        else if (opcion == 2)
        {
            System.out.println("Ingrese la cantidad de digitos del primer número: ");
            n1 = leer.nextInt();
            primerI = generarAleatorio(n1);
            //System.out.println("Primer número: " + primerI);
            Imprimir(primerI);
            System.out.println("\n");
            
            System.out.println("Ingrese la cantidad de digitos del segundo número: ");
            n2 = leer.nextInt();
            segundoI = generarAleatorio(n2);
            //System.out.println("Segundo número: " + segundoI);
            Imprimir(segundoI);
            System.out.println("\n");
            
            resultado = multiplicar(primerI, segundoI);
            
            //System.out.println("Resultado: " + resultado); 
            System.out.println("Resultado: " ); 
            Imprimir(resultado);
            System.out.println("\n");
        }
//
//        if(opcion == 1)
//        {
//            System.out.println("Ingrese el primer sumando: ");
//            primerI = leer.nextInt();
//
//            System.out.println("Ingrese el segundo sumando: ");
//            segundoI = leer.nextInt();
//
//            resultado = sumar(cambiarItoA(primerI), cambiarItoA(segundoI));
//
//            System.out.println("");
//
//            System.out.println("El resultado de la suma es: " + cambiarAtoI(resultado));
//        }
//        else if(opcion == 2)
//        {        
//            System.out.println("Ingrese el primer factor: ");
//            primerI = leer.nextInt();
//
//            System.out.println("Ingrese el segundo factor: ");
//            segundoI = leer.nextInt();
//
//            resultado = multiplicar(cambiarItoA(primerI), cambiarItoA(segundoI));
//
//            System.out.println("");
//
//            System.out.println("El resultado del producto es: " + (resultado));
//        }
        
        
        
    }
    
    private void Imprimir(ArrayList<Integer> numero)
    {
        for (Integer a : numero) {
            System.out.print(a);
        }
    }
    
    private ArrayList<Integer> generarAleatorio(int n)
    {
        ArrayList<Integer> aleatorio = new ArrayList<>();
        
        int numero;
        
        aleatorio.add((int) (Math.random() * 8) + 1);
        
        for(int i = 1; i<n; i++)
        {
            numero = (int) (Math.random() * 9);
            aleatorio.add(numero);
        }
        
        return aleatorio;
    }
    
    private ArrayList<Integer> sumar (ArrayList<Integer> primero, ArrayList<Integer> segundo)
    {
        ArrayList<Integer> resultado = new ArrayList<>();
        int k, j, c, d = 0;
        int tamA = primero.size(), tamB = segundo.size();
        
        if(tamA == tamB)
        {
            for(int i = tamA; i>0; i--)
            {
                k = primero.get(i-1);
                j = segundo.get(i-1);
                c= k+j+d;
                
                if(c>9)
                {
                    resultado.add(c%10);
                    d = 1;
                }
                else
                {
                    resultado.add(c);
                    d = 0;
                }
            }
            
            resultado.add(d);
            Collections.reverse(resultado);
            
        }
        else
        {
            if(tamA < tamB)
            {
                ArrayList<Integer> aux;
                
                aux = primero;
                primero = segundo;
                segundo = aux;
                tamA = primero.size();
                tamB = segundo.size();
                
            }
            for(int i = tamB; i>0; i--)
            {
                k = primero.get(tamA-tamB+i-1);
                j = segundo.get(i-1);
                c= k+j+d;
                
                if(c>9)
                {
                    resultado.add(c%10);                    
                    d = 1;
                }
                else
                {
                    resultado.add(c);
                    d = 0;
                }
            }
            
            for(int l = tamA-tamB; l>0; l--)
            {
                    c = primero.get(l-1) + d;
                    if(c>9)
                    {
                        resultado.add( c%10 );
                        d = 1;
                    }
                    else
                    {
                        resultado.add(c);
                        d = 0;
                    }  
            }
            if(d != 0)
                resultado.add(d);
            Collections.reverse(resultado);
        }
        
        return resultado;
    }
    
    private ArrayList<Integer> multiplicar (ArrayList<Integer> primero, ArrayList<Integer> segundo)
    {
        ArrayList<Integer> resultado = new ArrayList<>();
        resultado.add(0);
        ArrayList<Integer> subRes = new ArrayList<>();
        
        int tamA = primero.size(), tamB = segundo.size();
        
        int k, j, c, n1 = 0, d = 0;
        
        if(tamB>tamA)
        {
            ArrayList<Integer> aux;
            
            aux = primero;
            primero = segundo;
            segundo = aux;
            tamA = primero.size();
            tamB = segundo.size();
            
        }
        
        for(int i=tamB; i>0; i--)
        {
            subRes.clear();
            j = segundo.get(i-1);

            for(int m = 0; m<n1; m++)
            {
                subRes.add(0);
            }

            for(int l = tamA; l>0; l--)
            {                    
                k = primero.get(l-1);
                c = k*j + d;
                subRes.add(c%10);
                d = c/10;
            }
            subRes.add(d);
            d = 0;
            n1++;
            Collections.reverse(subRes);           
            resultado = sumar(subRes, resultado);            
        }
        
        return resultado;
    }
    
}