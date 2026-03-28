package DistribuicaoAlimentos;
import java.util.List;
import java.util.Scanner;

public class Alimentos {
	String Nome;
	float qGramas = 1000;
	
	public Alimentos() {

	}

	public void adicionarAlimentos(List<Alimentos> lista, Scanner scanner) {
        // adicionar alimentos a lista
		 for (int i = 0; i < 2; i++) {
			Alimentos alimento = new Alimentos();

			System.out.println("ADICIONE UM ALIMENTO Á LISTA: ");
			alimento.Nome = scanner.nextLine();
			
			System.out.println("ADICIONE A QUANTIDADE EM GRAMAS (1 kilo = 1000gramas): ");
			alimento.qGramas = scanner.nextInt();
		    
			
			System.out.println(alimento.Nome + " | " + alimento.qGramas +" GRAMAS");
				
				scanner.nextLine();
				lista.add(alimento);
				System.out.println("ALIMENTO INCLUIDO NA LISTA!\n");
			
			}

		 System.out.println("____________________LISTA DE ALIMENTOS NO ESTOQUE___________________");
			for (Alimentos e : lista) {
				
			System.out.println("---> ALIMENTO: " +  e.Nome + "\nQUANTIDADE EM GRAMAS:  " + e.qGramas);
			System.out.println("__________________________");
			}
	}



	}

