package DistribuicaoAlimentos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escolas {
		public String Nomes;
		public int QAlunos;
		public double Destinado;
		
		//CONSTRUTOR VAZIO
			public Escolas() {
		
		}
	
	public void adicionarEscolas(List<Escolas> lista, Scanner scanner) {
        //LAÇO FOR QUE DENTRO DELE CRIEI UM OBJETO DA ESCOLA (escolax), E RECEBENDO TAMBEM O NOME E A QANTIDADE DE ALUNOS 
        for (int i = 0; i < 2; i++) {
        	Escolas escolax = new Escolas();
        
        	System.out.print("Digite o nome da escola: ");
        	escolax.Nomes = scanner.nextLine();
        	System.out.print("Digite a Quantidade de Alunos: ");
        	escolax.QAlunos = scanner.nextInt();
		
        	scanner.nextLine();
        	lista.add(escolax);
        	System.out.println("ESCOLA INCLUIDA NA LISTA\n");
        	}
		
		System.out.println("______________________LISTA DE ESCOLAS_____________________");
		for (Escolas e : lista) {
			
		System.out.println("ESCOLA: " +  e.Nomes + " | QUANTIDADE DE ALUNOS:  " + e.QAlunos);
		
		}
	}

}
