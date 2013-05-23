package br.unifor.grafo.main;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

import br.unifor.grafo.tad.Grafo;
import br.unifor.grafo.tad.GrafoLista;
import br.unifor.grafo.tad.GrafoMatriz;
import br.unifor.grafo.util.Leitor;

/**
 * 
 * @author armandocouto
 *
 */
public class Principal {

//	private static final Logger LOG = ne
	private Leitor leitor = new Leitor();
	private Scanner s = new Scanner(System.in);
	private Grafo grafo = new Grafo();
	private GrafoMatriz grafoMatriz;
	private GrafoLista grafoLista;
	
	/**
	 * Método run.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new Principal().sistema();
	}
	
	private void sistema() {
		try {
			System.out.println("------ Menu ------");
			System.out.println("1 - Ler arquivo txt.");
			System.out.println("2 - Criar grafo.");
			int menuPrincipal = this.s.nextInt();
			
			if (menuPrincipal == 1)
				this.lerMatriz();
			else if (menuPrincipal == 2)
				this.criarGrafo();
			else
				this.opcaoInvalida();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void lerMatriz() throws Exception {
		String caminhoArquivo = "User/armandocouto/Projetos/GrafosNP1_2013/src";
		JFileChooser arquivo = new JFileChooser();
		int retorno = arquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
			File file = new File(caminhoArquivo);
			grafo = (Grafo) leitor.captura(file);
			this.menuGrafo();
		} else {
			throw new Exception();
		}
	}

	private void criarGrafo() {
		try {
			System.out.println("------ Menu Criar Grafo ------");
			System.out.println("Qual vai ser a representação:");
			System.out.println("1 - Matriz de Adjacência.");
			System.out.println("2 - Lista de Adjacência.");
			int menuAdjacencia = this.s.nextInt();
			
			if (menuAdjacencia == 1) {
				grafo.setRepresentacao(1);
				this.matrizAdjacencia();
			} else if (menuAdjacencia == 2) {
				grafo.setRepresentacao(2);
				this.listaAdjacencia();
			} else
				this.opcaoInvalida();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void matrizAdjacencia() {
		try {
			// Saber se é dirigido.
			System.out.println("Grafo é dirigido:");
			int isDirigido = this.s.nextInt();
			if (isDirigido == 0)
				grafo.setDirigido(false);
			else if (isDirigido == 1)
				grafo.setDirigido(true);
			else
				this.opcaoInvalida();
			
			// Saber se é ponderado.
			System.out.println("Grafo é ponderado:");
			int isPonderado = this.s.nextInt();
			if (isPonderado == 0)
				grafo.setPonderado(false);
			else if (isPonderado == 1)
				grafo.setPonderado(true);
			else
				this.opcaoInvalida();
			
			System.out.println("Quantos Vértices:");
			grafo.setVertice(this.s.nextInt());
			this.criarArestas();
			
			this.menuGrafo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void menuGrafo() {
		try {
			System.out.println("------ Menu do Grafo ------");
			System.out.println("1 - Imprimir Grafo.");
			
			int opcao = this.s.nextInt();
			
			switch (opcao) {
			case 1:
				if(grafo.getRepresentacao() == 1)
					this.grafoMatriz.imprimir();
				else if(grafo.getRepresentacao() == 2)
					this.grafoLista.imprimir();
				break;
				
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Montagem do grafo.
	 */
	private void criarArestas() {
		grafoMatriz = new GrafoMatriz();
		grafoMatriz.setAresta(grafo.getAresta());
		grafoMatriz.setDirigido(grafo.getDirigido());
		grafoMatriz.setPonderado(grafo.getPonderado());
		grafoMatriz.setRepresentacao(grafo.getRepresentacao());
		grafoMatriz.setVertice(grafo.getVertice());
		grafoMatriz.setMatriz(new int[grafo.getVertice()][grafo.getVertice()]);
		if (grafo.getPonderado()) {
			for (int i = 0; i < grafo.getVertice(); i++) {
				for (int j = 0; j < grafo.getVertice(); j++) {
					System.out.println("Digite "+i+" de "+j+" o peso:");
					grafoMatriz.getMatriz()[i][j] = this.s.nextInt();
				}
			}
		} else {
			for (int i = 0; i < grafo.getVertice(); i++) {
				for (int j = 0; j < grafo.getVertice(); j++) {
					System.out.println("Digite "+i+" de "+j+":");
					grafoMatriz.getMatriz()[i][j] = this.s.nextInt();
				}
			}
		}
	}

	private void listaAdjacencia() {
		
	}
	
	
	
	private void opcaoInvalida() {
		System.out.println("Opção inválido");
	}
}