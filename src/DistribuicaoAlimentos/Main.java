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
		
		Escolas escola = new Escolas();
		List<Escolas> listadeEscolas = new ArrayList<>();
		
		escola.adicionarEscolas(listadeEscolas, scanner);
		
		// Calcular totais
		int TotalAlimento = 0;
		for (Alimentos a : listadeAlimentos) {
		    TotalAlimento += a.qGramas;
		}
		
		int TotalAlunos = 0;
		for (Escolas e : listadeEscolas) {
		    TotalAlunos += e.QAlunos;
		}
		
		// Calcular Destinado para cada escola
		System.out.println("\n______________________DISTRIBUIÇÃO DE ALIMENTOS_____________________");
		for (Escolas e : listadeEscolas) {
		    e.Destinado = (double)(TotalAlimento * e.QAlunos) / TotalAlunos;
		    System.out.println("ESCOLA: " + e.Nomes + " | DESTINADO: " + e.Destinado + " gramas");
		}
		
		scanner.close();
	}



	}

