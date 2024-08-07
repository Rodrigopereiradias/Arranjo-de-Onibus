package aplication;

import java.util.Scanner;

import entity.Onibus;
import entity.Passageiro;

public class Main {

	public static void main(String[] args) {
		
		
		//tecladp
        Scanner Teclado = new Scanner(System.in);
        Onibus onibus = new Onibus(1);
       
        
        
        for (int i = 0; i < onibus.getTotalVagas(); i++) {
        	
            System.out.println("Banco " + (i + 1));
            
            System.out.print("Nome: ");
            String nome = Teclado.next();
            
            System.out.print("CPF: ");
            String cpf = Teclado.next();
            cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            
            System.out.print("Idade: ");
            int idade = Teclado.nextInt();
            
            System.out.print("Sexo (M/F): ");
            
            boolean sexo = Teclado.next().equalsIgnoreCase("M");

            Passageiro passageiro = new Passageiro(nome, cpf, idade, sexo);
            onibus.adicionaPassageiro(passageiro, i);
        }

        System.out.println("\nPassageiros no ônibus:");
        onibus.mostraVagas();

        System.out.println("\nInformações detalhadas dos passageiros:");
        onibus.mostrarInformacoesPassageiros();
    }
}
