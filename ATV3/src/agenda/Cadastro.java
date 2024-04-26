package agenda;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cadastro {
	public static void cadastrar(){
		
		try {
			FileWriter escrita = new FileWriter("C:\\Users\\danie\\eclipse-workspace\\ATV3\\src\\agenda\\agenda.txt", true);
			
			BufferedWriter bwEscrita = new BufferedWriter(escrita);
			Scanner sc = new Scanner(System.in);
			
		    System.out.print("Digite [Nome-Telefone]: ");
			bwEscrita.write(sc.nextLine());
			bwEscrita.newLine();
			
			bwEscrita.close();
			escrita.close();
			
			System.out.print("Cadastrado efetuado com sucesso!");
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
	}
}
