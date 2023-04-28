
import java.net.SocketException;
import java.net.UnknownHostException;

import chat.Cliente;
import chat.Network;
import chat.Servidor;

public class Main {
    public static void main(String[] args){
        Servidor servidor = new Servidor();

        System.out.println("Seu ip é: " + servidor.getIp());
        System.out.println("Porta: " + servidor.getPorta());

        Cliente cliente = new Cliente();

        

        Thread s = new Thread(servidor);
        Thread c = new Thread(cliente);
        

    }
}
