package br.unifor.grafo.dikstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GrafoUtil {

 public static String VISITADO = "VISITADO";

 public static String NAOVISITADO = "NAOVISITADO";

 public static String RETORNO = "RETORNO";

 public static String CRUZA = "CRUZA";

 public static List<String> pilha = new ArrayList<String>();

 private static boolean go = true;

 private static boolean back = true;

// public static void dethFirstSearch(Vertice vertex) throws VertexException {
//  System.out.println("\nDETH FIRST SEARCH on GRAPH");
//  System.out.print("In�cio V:" + vertex.getName());
//  vertex.setStatus(VISITED);
//  executeDethFirstSearch(vertex);
// }

 public static void executeDethFirstSearch(Vertice vertex)
   throws VertexException {

  for (Aresta edge : vertex.getArestas()) {
   if (edge.getStatus().equals(NAOVISITADO)) {
    Vertice w = Grafo.opposite(vertex, edge);
    if (w.getStatus().equals(NAOVISITADO)) {
     edge.setStatus(VISITADO);
     w.setStatus(VISITADO);
     if (go) {
      System.out.println();
      go = false;
     }
     System.out.print("-> Visita Aresta Peso:" + edge.getPeso() + " V�rtice:"
       + w.getName() + " ");
     back = true;
     executeDethFirstSearch(w);
     if (back) {
      System.out.println();
      back = false;
     }
     System.out.print("-> BACK Aresta Peso:" + edge.getPeso() + " V�rtice:"
       + vertex.getName() + " ");
     go = true;
    }
   }
  }
 }

// public static void breathFirstSearch(Vertice vertex) throws VertexException {
//  System.out.println("\n\nBREATH FIRST SEARCH on GRAPH");
//  Queue<Vertice> queue = new LinkedList<Vertice>();
//  queue.add(vertex);
//  System.out
//    .print("START = V:" + vertex.getId() + "-" + vertex.getName());
//  while (!queue.isEmpty()) {
//   Vertice v = queue.remove();
//   System.out.print("\nBACK = V:" + v.getId() + "-" + v.getName());
//   for (Aresta e : v.getEdges()) {
//    if (e.getStatus().equals(UNVISITED)) {
//     Vertice w = Grafo.opposite(v, e);
//     if (w.getStatus().equals(UNVISITED)) {
//      e.setStatus(VISITED);
//      w.setStatus(VISITED);
//      queue.add(w);
//      System.out.print(" -> GO = E:" + e.getPeso() + " V:"
//        + w.getId() + "-" + w.getName());
//     }
//    }
//   }
//  }
//  System.out.println();
// }

 public static void resetStatus(Grafo graph) {
  for (int i = 0; i < graph.arestas().size(); i++) {
   graph.arestas().get(i).setStatus(NAOVISITADO);
  }
  for (int i = 0; i < graph.vertices().size(); i++) {
   graph.vertices().get(i).setStatus(NAOVISITADO);
  }
 }

 public static void dijkstra(Vertice init) throws VertexException {
  System.out.println("\n\nCaminho M�nimo");

  init.setDist(0);
  PriorityQueue<Vertice> queue = new PriorityQueue<Vertice>();
  queue.add(init);

  while (!queue.isEmpty()) {
   Vertice u = queue.poll();

   for (Aresta e : u.getArestas()) {
    Vertice v = Grafo.opposite(u, e);
    int peso = e.getPeso();
    int distanceThroughU = u.getDist() + peso;
    if (distanceThroughU < v.getDist()) {
     queue.remove(v);
     v.setDist(distanceThroughU);
     v.setAnterior(u);
     queue.add(v);
    }
   }
  }
 }

 public static List<String> getShortestPathTo(Vertice target) {
  List<String> path = new ArrayList<String>();
  for (Vertice vertex = target; vertex != null; vertex = vertex.getAnterior()) {
   path.add(vertex.getName());
  }
  Collections.reverse(path);
  return path;
 }

 public static void printShortestPathTo(Grafo graph) {
  for (Vertice v : graph.vertices()) {
   System.out.println("Distancia para " + v.getName() + ": "
     + v.getDist());
   List<String> path = getShortestPathTo(v);
   System.out.println("Caminho: " + path);
  }
 }
}
