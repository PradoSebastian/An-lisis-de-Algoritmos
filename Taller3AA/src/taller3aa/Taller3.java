/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3aa;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author sistemas
 */
public class Taller3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Taller3 t = new Taller3();
        ArrayList<Articulo> articulos = new ArrayList<>();
        
        articulos.add(new Articulo("oro", 15, 10000));
        articulos.add(new Articulo("plata", 1, 3000));
        articulos.add(new Articulo("Plumas", 14, 500));
        articulos.add(new Articulo("Lapices", 2, 300));
        articulos.add(new Articulo("pintura", 5, 4000));
        articulos.add(new Articulo("monaLisa", 11, 8000));
        articulos.add(new Articulo("pc", 20, 9000));
        articulos.add(new Articulo("celular", 3, 1000));
        
        System.out.println("Resultado Primer Punto con num = 8: "+ t.numSumas(8));
        System.out.println("");

        System.out.println("Resutado Mochila Original: "+ t.mejorTulaO(articulos, 15));
        System.out.println("");

        System.out.println("Resutado Mochila Modificado: "+ Maleta.ToString(t.mejorTula2(articulos, 15)));
        System.out.println("");

        System.out.println("Resutado Mochila Mejora Espacial: "+ t.mejorTula3(articulos, 15));
        System.out.println("");

        List<Double> p = new ArrayList<>();
        p.add(0.7);
        p.add(0.5);
        p.add(0.3);
        p.add(0.6);
        p.add(0.2);
        p.add(0.1);
        p.add(0.1);
        System.out.println("la probabilidad de que 5 monedas caigan cara es: "+t.countingHeads(7, 5, p));
        
        System.out.println("Resutado potencia : "+ t.potencia(2, 10));
        System.out.println("");

        ArrayList<Integer> a = new ArrayList<>();
        a.add(31);
        a.add(4);
        a.add(60);
        a.add(-4);
        a.add(80);
        a.add(9);
        a.add(37);
        ArrayList<Integer> b = new ArrayList<>();  
        b.add(31);
        b.add(4);
        b.add(60);
        b.add(-4);
        b.add(80);
        b.add(9);
        b.add(37);
        System.out.println("Resultado sub Cadena mas larga: " + t.scml(a, b));

    }
   
    public int numSumas (int num)
    {
        ArrayList<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(1);
        c.add(2);
        c.add(4);
        
        for (int i = 5; i <= num; i++) 
        {
            c.add(c.get(i-1)+c.get(i-3)+c.get(i-4));
        }
        
        return c.get(num);
    }
    
    public float mejorTulaO(ArrayList<Articulo> articulos, int pesoTula)
    {
        ArrayList<ArrayList<Float>> c = new ArrayList<>();
                
        for (int i = 0; i <= articulos.size(); i++) 
        {
            ArrayList<Float> aux = new ArrayList<>();
            for (int j = 0; j <= pesoTula; j++) 
            {
                aux.add(Float.valueOf(0));
            }
            c.add(aux);
        }
        
        for (int i = 1; i <= articulos.size(); i++) 
        {  
            for (int j = 1; j <= pesoTula; j++) 
            {
                if(articulos.get(i-1).getPesoKg()>j)
                {
                    c.get(i).set(j,c.get(i-1).get(j));
                }
                else
                {
                    c.get(i).set(j,Float.max(c.get(i-1).get(j), c.get(i-1).get(j-articulos.get(i-1).getPesoKg()) + articulos.get(i-1).getValorMonetario()));
                }
            }
            System.out.println("Cache: " + c.get(i));
        }
        System.out.println("");
        return c.get(articulos.size()).get(pesoTula);
    }
    
    public Maleta mejorTula2(ArrayList<Articulo> articulos, int pesoTula)
    {
        ArrayList<ArrayList<Maleta>> c = new ArrayList<>();
               
        for (int i = 0; i <= articulos.size(); i++) 
        {
            ArrayList<Maleta> aux = new ArrayList<>();
            for (int j = 0; j <= pesoTula; j++) 
            {
                Maleta mal = new Maleta();
                aux.add(mal);
            }
            c.add(aux);
        }
        
        for (int i = 1; i <= articulos.size(); i++) 
        {  
            for (int j = 1; j <= pesoTula; j++) 
            {
                if( articulos.get(i-1).getPesoKg()>j )
                {
                    c.get(i).get(j).copiarMaleta(c.get(i-1).get(j));
                }
                else
                {
                    Maleta m = Maleta.MaxValor(c.get(i-1).get(j), c.get(i-1).get(j - articulos.get(i-1).getPesoKg()), articulos.get(i-1));
                    c.get(i).get(j).copiarMaleta(m);
                    if(m.equals(c.get(i-1).get(j-articulos.get(i-1).getPesoKg())))
                    {
                       c.get(i).get(j).insertarArticulo(articulos.get(i-1));
                    }            
                }
            }
        }
        
        return c.get(articulos.size()).get(pesoTula);
    }
    
    public float mejorTula3(ArrayList<Articulo> articulos, int pesoTula)
    {
        ArrayList<Float> c1 = new ArrayList<>();
        ArrayList<Float> c2 = new ArrayList<>();
      
        for (int j = 0; j <= pesoTula; j++) 
        {
            c1.add(Float.valueOf(0));
            c2.add(Float.valueOf(0));
        }
        
        for (int i = 1; i <= articulos.size(); i++) 
        {  
            for (int j = 1; j <= pesoTula; j++) 
            {
                if(articulos.get(i-1).getPesoKg()>j)
                {
                    c2.set(j,c1.get(j));
                }
                else
                {
                    c2.set(j,Float.max(c1.get(j), c1.get(j-articulos.get(i-1).getPesoKg()) + articulos.get(i-1).getValorMonetario()));
                }
            }
            for (int k=0; k<c2.size(); k++) 
            {
                c1.set(k, c2.get(k));
                c2.set(k, Float.valueOf(0));
            }
        }
        return c1.get(pesoTula);
    }
    
    public String punto4_6 (ArrayList<Integer> lista)
    {
        ArrayList<Integer> c1 = new ArrayList<>();
        ArrayList<Integer> c2 = new ArrayList<>();
        int n = lista.size();
        String resp = "No se puede";
        
        c1.add(0);
        c2.add(0);
        
        for(int i = 1; i <= n; i++) 
        {
            c1.add(c1.get(i-1) + lista.get(i-1));
            c2.add(c2.get(i-1) + lista.get(n-i));
        }
        
        for (int i = 0; i <= n; i++) 
        {
            if(c1.get(i) == c2.get(n-i))
                resp = "Se puede";
        }
        
        resp += " partir en dos conjuntos que suman lo mismo";
        
        return resp;
        
    }
    
    public static int potencia(int b, int n){ 
        List<Integer> c = new ArrayList<>(); 
        c.add(b);
        int i=1; 
        int k = 0; 
        while(i<n){ 
            if(n/2<i){ 
                c.add(c.get(k)*b); 
                i+=1;
            }else{ 
               c.add(c.get(k)*c.get(k)); 
                i=i*2; 
            } 
            k++; 
        } 
        return c.get(k); 
    } 

    public int scml (ArrayList<Integer> a, List<Integer> b)
    {
        ArrayList<ArrayList<Integer>>  c = new ArrayList<>();
        int n = a.size(), m = b.size();
        ArrayList<Integer> aux;
        
        for(int i = 0; i <= n; i++)
        {
            aux = new ArrayList<>();
            for(int j = 0; j<= m; j++)
            {
                aux.add(0);
            }
            c.add(aux);
        }
        
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(a.get(i-1).equals(b.get(j-1)))
                {
                    c.get(i).set(j, c.get(i-1).get(j-1)+1);
                }
                else
                {
                    c.get(i).set(j, Integer.max(c.get(i).get(j-1), c.get(i-1).get(j)));
                }
            }
        }
        
        return c.get(n).get(m);
    }
    
    public double countingHeads(int n, int k, List<Double> p) 
    {
        List<ArrayList<Double>> c= new ArrayList<>();
        ArrayList<Double> aux;
        for (int i = 0; i <= n; i++) 
        {
            aux = new ArrayList<>();
            for (int j= 0; j <= k ; j++)
            {
                aux.add(0.0);  
            }
            c.add(aux); 
        }
        c.get(0).set(0, 1.0);
        for(int i = 1; i<=n; i++)
        {
            c.get(i).set(0, (1-p.get(i-1))*c.get(i-1).get(0));
        }
        
        for (int i= 1; i <= n ; i++) 
        {
            for (int j = 1; j <= k; j++) 
            {
                c.get(i).set(j, (c.get(i-1).get(j)*(1-p.get(i-1)))+(c.get(i-1).get(j-1)*(p.get(i-1))));
            }
        }
        return c.get(n).get(k);  
    }
}
