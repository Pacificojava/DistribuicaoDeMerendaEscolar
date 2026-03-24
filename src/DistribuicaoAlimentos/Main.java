package DistribuicaoAlimentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		

		Alimentos alimento = new Alimentos();
		Scanner scanner = new Scanner(System.in);
		List<Alimentos> listadeAlimentos = new ArrayList<>();

		alimento.adicionarAlimentos(listadeAlimentos, scanner);
			
	}



	}

