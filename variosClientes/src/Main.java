
import java.util.Scanner;

import chat.Cliente;
import chat.Servidor;

public class Main {
    public static void main(String[] args){
        Servidor servidor = new Servidor();

        Cliente cliente = new Cliente();
        System.out.println("enscolha a opção:\n1 - Abrir Servidor\n2 - Entrar em servidor\n3 - sair");
        
        Scanner scanner = new Scanner(System.in);
        String resp = scanner.nextLine();

        Thread s = new Thread(servidor);
        Thread c = new Thread(cliente);

        boolean run = true;
        while(run){

            switch (resp) {
                case "1":
                    s.start();
                    System.out.println("Seu ip é: " + servidor.getIp());
                    System.out.println("Porta: " + servidor.getPorta());
                    
                    Cliente.setIp(servidor.getIp());
                    c.start();   
                    
                    break;
                case "2":
                    System.out.println("Digite o ip do servidor");
                    resp = scanner.nextLine();
                    scanner.close();
                    c.start();
                    
                    
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        scanner.close();
        

    }
}
