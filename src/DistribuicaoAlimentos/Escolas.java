package DistribuicaoAlimentos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escolas {
		public String Nomes;
		public int QAlunos;
		
		//CONSTRUTOR VAZIO
			public Escolas() {
		
		}
	
	public static void main(String[] args) {
		//INICIALIZEI O SCANNER
        Scanner scanner = new Scanner(System.in);
        List<Escolas> ListadeEscolas = new ArrayList<>();
        
        //LAÇO FOR QUE DENTRO DELE CRIEI UM OBJETO DA ESCOLA (escolax), E RECEBENDO TAMBEM O NOME E A QANTIDADE DE ALUNOS 
        for (int i = 0; i < 1; i++) {
        	Escolas escolax = new Escolas();
        
        	System.out.print("Digite o nome da escola: ");
        	escolax.Nomes = scanner.nextLine();
        	System.out.print("Digite a Quantidade de Alunos: ");
        	escolax.QAlunos = scanner.nextInt();
		
        	scanner.nextLine();
        	ListadeEscolas.add(escolax);
        	System.out.println("ESCOLA INCLUIDA NA LISTA\n");
        	}
		
		System.out.println("______________________LISTA DE ESCOLAS_____________________");
		for (Escolas e : ListadeEscolas) {
			
		System.out.println("ESCOLA: " +  e.Nomes + " | QUANTIDADE DE ALUNOS:  " + e.QAlunos);
		
		}
	}

}
