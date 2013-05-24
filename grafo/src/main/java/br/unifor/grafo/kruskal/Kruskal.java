package br.unifor.grafo.kruskal;

import java.util.TreeSet;

public class Kruskal
{
    public static void main(String[] args)
    {
        //TreeSet � usado para classificar as arestas antes de passar para o algoritmo
        TreeSet<Aresta> arestas = new TreeSet<Aresta>();

        //Sample problem - replace these values with your problem set
        arestas.add(new Aresta("0", "1", 2)); 
        arestas.add(new Aresta("0", "3", 1)); 
        arestas.add(new Aresta("1", "2", 3)); 
        arestas.add(new Aresta("2", "3", 5)); 
        arestas.add(new Aresta("2", "4", 7)); 
        arestas.add(new Aresta("3", "4", 6)); 
        arestas.add(new Aresta("4", "5", 4));

        System.out.println("Grafo");
        KruskalArestas vv = new KruskalArestas();

        for (Aresta aresta : arestas) {
            System.out.println(aresta);
            vv.insereAresta(aresta);
        }

        System.out.println("Kruskal");
        int total = 0;
        for (Aresta aresta : vv.getArestas()) {
            System.out.println(aresta);
            total += aresta.getPeso();
        }
        System.out.println("Peso Total: " + total);
    }
}