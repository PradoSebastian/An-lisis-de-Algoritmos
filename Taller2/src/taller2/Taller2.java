/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author prado
 */
public class Taller2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Taller2 t = new Taller2();
       int n = 0; 
       ArrayList<Integer> elementos = new ArrayList<>();
       
       elementos = t.generarAleatorio(4442);
       
//       elementos.add(1);
//       elementos.add(3); 
//       elementos.add(1);
//       elementos.add(0);
//       elementos.add(7);
//       elementos.add(2);
       /**      elementos.add(13); elementos.add(3); elementos.add(4); elementos.add(2); elementos.add(4); elementos.add(5); elementos.add(7); elementos.add(11);elementos.add(3);elementos.add(12);
       elementos.add(3); elementos.add(3); elementos.add(3); elementos.add(2); elementos.add(5); elementos.add(8); elementos.add(9); elementos.add(11);elementos.add(3);elementos.add(12);
       */
               
       elementos = (ArrayList<Integer>) t.mergeSort(elementos);
        
       //Collections.sort(elementos);
       //n = t.funcion17(elementos, 0,elementos.size()-1);
       
        //elementos = t.func14(elementos);
       //n = t.func15(elementos, 11); 
       System.out.println(elementos);
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
    
    public ArrayList<Integer> func14(ArrayList<Integer> elementos)
    {
        ArrayList<Integer> auxiliar= new ArrayList<>();
        
        Collections.sort(elementos);

        int anterior = elementos.get(0);
        
        auxiliar.add(elementos.get(0));
        
        for (Integer e : elementos) 
        {
            if(anterior != e)
            {
                auxiliar.add(e);
            }
            
            anterior = e;
        }   
        
        return auxiliar;
    }
    
    public int func15(ArrayList<Integer> elementos, int k)
    {
        if(elementos.size()<1)
        {
            return -1;
        }
        int indice=(int) (Math.random() * elementos.size()-1);
        int pivote= elementos.get(indice);
        int mayor,menor,igual, aux;
        mayor=menor=0;
        igual=0;
        
        System.out.println(indice);
        System.out.println(pivote);
        
        for (int i = 0; i < elementos.size(); i++) 
        {
            igual=0;
            for(int h=indice-1; h>=0; h--)
            {
                if(pivote==elementos.get(h))
                {
                    igual++; 
                }
            }
            if(elementos.get(i) < pivote)
            {
                if(i>indice)
                {
                    aux = elementos.get(i);
                    for(int j = i; j>indice-igual;j--)
                    {
                        elementos.set(j, elementos.get(j-1));
                    }
                    
                    elementos.set(indice-igual, aux);
                    indice++;
                }
            }
            else if(elementos.get(i) > pivote)
            {
                if(i<indice)
                {
                    aux = elementos.get(i);
                    for(int j = i; j<indice ;j++)
                    {
                        elementos.set(j, elementos.get(j+1));
                    }
                    
                    elementos.set(indice, aux);
                    i--;
                    indice--;
                }
            }
            else
            {
                if(i<indice)
                {
                    
                    for(int j = i; j<indice; j++)
                    {
                        elementos.set(j, elementos.get(j+1));
                    }
                    elementos.set(indice-1, pivote);
                    igual++;
                    if(elementos.get(i)!=pivote)
                    {
                        i--;
                    }
                }                
                else if( i>indice )
                {
                    for(int j = i; j>indice; j--)
                    {
                        elementos.set(j, elementos.get(j-1));
                    }
                    indice++;
                    elementos.set(indice-1, pivote);
                    igual++;
                }                
            }
        }
        
        System.out.println(elementos);
        
        igual=0;
        for (Integer e : elementos) 
        {
            if(e<pivote)
                menor++;
            else if(e>pivote)
                mayor++;
            else
                igual++;
        }
        
        System.out.println("menor " + menor);
        System.out.println("mayor " + mayor);
        System.out.println("igual " + igual);
        
        if(menor>k)
        {
            System.out.println(elementos.subList(0, menor));
            return func15(new ArrayList<Integer>(elementos.subList(0, menor)), k);
        }
        else if(menor+igual > k)
        {
            return elementos.get(menor);
        }
        else
        {
            System.out.println(elementos.subList(menor+igual, elementos.size()-1));
            return func15(new ArrayList<Integer>(elementos.subList(menor+igual, elementos.size())), k-menor-igual);
            
        }
    }
    
     public int funcion17(List<Integer> elementos, int inicio, int fin)
    {

        int medio=(fin+inicio)/2;
        
        if(medio >= fin)
        {
            return -1;
        }
        
        if(elementos.get(medio) == medio)
        {
            return medio; 
        }
        else if(elementos.get(inicio) == inicio)
        {
            return inicio; 
        }
        else if(elementos.get(fin) == fin)
        {
            return fin; 
        }
        else if(elementos.get(inicio) > inicio && elementos.get(medio) < medio)
        {
            return funcion17(elementos ,inicio, medio);
        }
        else if(elementos.get(medio+1) >= medio+1 )
        {
            return funcion17(elementos ,medio+1, fin);	
        }
        else
        {
            return -1;
        }

    }
     
    public List<Integer> mergeSort (List <Integer> lista)
    {
        if(lista.size() <= 1) 
            return lista;
        List<Integer> l1 = mergeSort(lista.subList(0, lista.size()/2));
        List<Integer> l2 = mergeSort(lista.subList(lista.size()/2, lista.size()));     
        return intercalar(l1, l2);
    }
    
    public List<Integer> intercalar (List<Integer> l1, List<Integer> l2)
    {
        if(l1.isEmpty())
            return l2;
        else if(l2.isEmpty())
            return l1;
        else
        {
            ArrayList<Integer> l3 = new ArrayList<>();
            if(l1.get(0) < l2.get(0))
            {
                l3.add(l1.get(0));
                l3.addAll(intercalar(l1.subList(1, l1.size()), l2));
                return l3;
            }
            else
            {
                l3.add(l2.get(0));
                l3.addAll(intercalar(l1,l2.subList(1, l2.size())));
                return l3;
            }
        }
    }
     
    public ArrayList<Integer> countingSort (ArrayList<Integer> array) // O(n) + O(n+1)
    {
        ArrayList<Integer> trabajo = new ArrayList<>();
        ArrayList<Integer> resultado = new ArrayList<>();
        
        for (int i = 0; i <= array.size(); i++)   // O(n+1)
        {
            trabajo.add(0);
        }
        
        int aux;
        
        for (Integer a : array)                   // O(n)
        {
            aux = trabajo.get(a);
            trabajo.set(a, aux+1);
        }
        
        for (int i =0; i<trabajo.size();i++)       // O(n)
        {
            for(int j =0; j < trabajo.get(i); j++) // Peor Caso (ninguno se repite) : O(1)
            {
                resultado.add(i);
            }
        }
                
        return resultado;   
    }    
    
}
