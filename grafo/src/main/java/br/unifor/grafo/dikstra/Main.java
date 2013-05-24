package br.unifor.grafo.dikstra;

public class Main {

 public static void main(String... args) throws VertexException {

  Grafo g = createGraph();

  printVertices(g);

  printEdges(g);

  Vertice v = g.getVertex(0);
//  GrafoUtil.dethFirstSearch(v);

  GrafoUtil.resetStatus(g);

//  GrafoUtil.breathFirstSearch(v);

  GrafoUtil.resetStatus(g);

  GrafoUtil.dijkstra(v);
  GrafoUtil.printShortestPathTo(g);
 }

 private static void printEdges(Grafo g) {
  System.out.println("N�mero de Arestas = " + g.numArestas());
  for (Aresta edge : g.arestas()) {
   System.out.println("Aresta: " + edge.getV1().getName() + " - " + edge.getV2().getName() +", peso: "+edge.getPeso());
  }
  System.out.println();
 }

 private static void printVertices(Grafo g) {
  System.out.println("Vertices = " + g.numVertices());
  for (Vertice vertex : g.vertices()) {
   System.out.print("Vertice:" + vertex.getName());
   System.out.print(" - Adjacentes");
   for (Vertice va : vertex.getAdjacentes()) {
    System.out.print(" - " + va.getName());
   }
   System.out.println();
  }
 }

 private static Grafo createGraph() throws VertexException {
  Grafo g = new Grafo();
  Vertice v0 = g.insertVertex(0, "V0");
  Vertice v1 = g.insertVertex(1, "V1");
  Vertice v2 = g.insertVertex(2, "V2");
  Vertice v3 = g.insertVertex(3, "V3");
  Vertice v4 = g.insertVertex(4, "V4");
  Vertice v5 = g.insertVertex(5, "V5");
  Vertice v6 = g.insertVertex(6, "V6");
  g.insertEdge(v0, v1, 2);
  g.insertEdge(v0, v2, 3);
  g.insertEdge(v0, v3, 4);
  g.insertEdge(v1, v4, 7);
  g.insertEdge(v1, v2, 1);
  g.insertEdge(v2, v5, 9);
  g.insertEdge(v2, v3, 2);
  g.insertEdge(v3, v6, 1);
  g.insertEdge(v4, v5, 2);
  g.insertEdge(v5, v6, 2);
  return g;
 }
}
