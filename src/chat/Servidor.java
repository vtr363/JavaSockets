package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Servidor implements Runnable {

    private static String ip;
    private static int porta = 10000;

    public Servidor(){
        try {
            Servidor.ip = Conexao.getIpAddress();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getIp() {
        
        return ip;
    }
    
    public String getPorta() {
        return null;
    }

    public void run() {

        try (ServerSocket server = new ServerSocket(Servidor.porta)) {
            System.out.println("Porta 10000 aberta, aguardando conexão");
            Socket client = server.accept();
            Cliente.setIp(client.getInetAddress().getHostAddress());

            System.out.println("Conexão do cliente "+client.getInetAddress().getHostAddress());

            Scanner s = new Scanner(client.getInputStream());
            while(s.hasNextLine()) {
                System.out.println(s.nextLine());
            }

            s.close();
            client.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
