package agenda;

import java.util.Scanner;

public class Menu {
	

    public void processamento() {
    	
    	Scanner sc = new Scanner(System.in);
    	
        int opcao;
        
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Fechar programa");
            
            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                	Cadastro.cadastrar();
                    break;
                case 2:
                	Buscar.pesquisa();
                    break;
                case 3:
                    System.out.println("Fechando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }
}

