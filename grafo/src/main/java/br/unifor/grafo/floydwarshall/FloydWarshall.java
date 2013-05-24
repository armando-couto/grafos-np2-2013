package br.unifor.grafo.floydwarshall;

import java.io.File;
import java.util.Scanner;

public class FloydWarshall {
	public FloydWarshall(){}
	public void iniciarFloydWarshall(){
		Scanner s = new Scanner(System.in);
		System.out.println("Nome do Arquivo:");			
		GrafoFW grafo = new GrafoFW(new File ("res"+File.separator+s.nextLine()+".txt"));

		//Tres fors checando passando por todos vertices atras de uma aresta i a k passando pelo intermediario j, se tiver ele adiciona a areste
		for(int i=0;i<grafo.Vertices();i++){
			for(int j=0;j<grafo.Vertices();j++){
				if(i!=j){
					for(int k=0;k<grafo.Vertices();k++){
						if(k!=j && k!=i){
							if(grafo.getGrafo(j,i) ==1 && grafo.getGrafo(i, k) ==1){
								if(grafo.getGrafo(j,k) == 0){
									/// Adiciona o vertice
									grafo.setGrafo(j, k, 1);
								}
							}
						}
					}
				}
			}
			
			System.out.println(+(i+1)+"� Itera��o: \n");
			grafo.imprimir();
		}
	}
}
