package br.unifor.grafo.dikstra;

import java.util.ArrayList;
import java.util.List;


public class Grafo {

 private int numVertices = 0;
 private int numArestas = 0;
 private List<Vertice> vertices = new ArrayList<Vertice>();
 private List<Aresta> arestas = new ArrayList<Aresta>();

 public Vertice getVertex(Integer id) {
  for (Vertice v : vertices) {
   if (v.getId().equals(id)) {
    return v;
   }
  }
  return null;
 }

 public int numVertices() {
  return numVertices;
 }

 public int numArestas() {
  return numArestas;
 }

 public List<Vertice> vertices() {
  return vertices;
 }

 public List<Aresta> arestas() {
  return arestas;
 }

 public Vertice aVertex() {
  return null;
 }

 public int grau(Vertice v) {
  return v.getGrau();
 }

 public List<Vertice> adjacentVertices(Vertice v) {
  return v.getAdjacentes();
 }

 public List<Aresta> incidentEdges(Vertice v) {
  return v.getArestas();
 }

 public List<Vertice> endVertices(Aresta e) {
  List<Vertice> vs = new ArrayList();
  vs.add(e.getV1());
  vs.add(e.getV2());
  return vs;
 }

 public static Vertice opposite(Vertice v, Aresta e) throws VertexException {
  // retorna o ponto final da aresta e diferente de v.
  for (Aresta edge : v.getArestas()) {
   if (edge.equals(e)) {
    if (v.equals(edge.getV1())) {
     return edge.getV2();
    } else {
     return edge.getV1();
    }
   }
  }
  throw new VertexException(VertexException.ID_NO_EXIST, null);
 }

 public boolean areAdjacent(Vertice v, Vertice w) {
  // retorna true se v e w sao adjacentes
  for (Vertice vertex : v.getAdjacentes()) {
   if (vertex.equals(w)) {
    return true;
   }
  }
  return false;
 }

 public Aresta insertEdge(Vertice v, Vertice w, Integer weigth) {
  Aresta e = v.insereAresta(w, weigth);
  w.insereAresta(v, e, weigth);
  v.addAdjacentes(w);
  w.addAdjacentes(v);
  arestas.add(e);
  numArestas++;
  return e;
 }

 public Vertice insertVertex(Integer id, String name) throws VertexException {
  for (Vertice vertex : vertices) {
   if (vertex.getId().equals(id)) {
    throw new VertexException(VertexException.ID_DUPLICATED, id);
   }
  }
  Vertice v = new Vertice(id, name);
  vertices.add(v);
  numVertices++;
  return v;
 }

 public void removeVertex(Vertice v) {
  // remove o vertice v e todas as suas arestas incidentes
  vertices.remove(v);
  numVertices--;
  v.removeTodasArestas();
 }

 public void removeEdge(Aresta e) {
  // remove a aresta e
  e.setV1(null);
  e.setV2(null);
  arestas.remove(e);
 }
}