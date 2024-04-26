package agenda;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Buscar {
	
	public static void pesquisa() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			FileReader leitura = new FileReader("C:\\Users\\\\danie\\eclipse-workspace\\ATV3\\src\\agenda\\agenda.txt");
			BufferedReader brLeitura = new BufferedReader(leitura);
			
			System.out.print("Digite um nome: ");
			String nomeBusca = sc.nextLine();
			
			while(brLeitura.ready()) {
				
				String str = brLeitura.readLine();
				String aux[] = str.split("-");
				
				if(nomeBusca.equals(aux[0])) {
					
					System.out.println("\nTelefone: ");
					System.out.println(aux[1]);
				}
			}

			brLeitura.close();
			leitura.close();
			

		} 
		catch(FileNotFoundException e){
			
			e.printStackTrace();
		} 
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
}