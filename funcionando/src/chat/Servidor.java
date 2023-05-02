package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor implements Runnable{
    public void run(){

        try (ServerSocket server = new ServerSocket(10000)) {
            System.out.println("Porta 10000 aberta, aguardando conexão");
            Socket client = server.accept();
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