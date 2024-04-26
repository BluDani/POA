package serializacao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	
	public static void main(String[] args) {
		
		Alunos aluno = new Alunos("Levi", "14/03/2004", "123456");
		
		try {
			
			File f = new File("c:/atv4/");
			if(!f.exists()) f.mkdir();
			FileOutputStream arqOOrg = new FileOutputStream("C:\\Users\\danie\\eclipse-workspace\\ATV4\\src\\serializacao\\alunos.Org");
			ObjectOutputStream oOOrg = new ObjectOutputStream(arqOOrg);
			
			oOOrg.writeObject(aluno);
			oOOrg.close();
			
			System.out.println("---------------Antes de alterar a data de nascimento-------------");
			System.out.println(aluno);
			
			aluno.setdataNasc("09/01/1999");
			
			System.out.println("\n\n---------------Depois de alterar a data de nascimento-------------");
			System.out.println(aluno);
			
			FileInputStream arqIOrg = new FileInputStream("C:\\Users\\danie\\eclipse-workspace\\ATV4\\src\\serializacao\\alunos.Org");
			ObjectInputStream iOOrg = new ObjectInputStream(arqIOrg);
			
			aluno = (Alunos) iOOrg.readObject();
			iOOrg.close();
			
			System.out.println("\n\n---------------Depois de recuperar os valores-------------");
			System.out.println(aluno);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}