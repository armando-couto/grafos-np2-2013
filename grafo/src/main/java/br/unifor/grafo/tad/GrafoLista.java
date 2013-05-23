package br.unifor.grafo.tad;

import java.util.List;

/**
 * 
 * @author armandocouto
 *
 */
public class GrafoLista extends Grafo implements GrafoTad {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	private int[] lista;
	
	/**
	 * 
	 */
	public GrafoLista() { super(); }

	/**
	 * @param aresta
	 * @param vertice
	 * @param ponderado
	 * @param representacao
	 * @param dirigido
	 */
	public GrafoLista(List<Aresta> aresta, Integer vertice, Boolean ponderado, Integer representacao, Boolean dirigido) {
		super(aresta, vertice, ponderado, representacao, dirigido);
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		System.out.println("teste");
	}

	/**
	 * @return the lista
	 */
	public int[] getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(int[] lista) {
		this.lista = lista;
	}
}