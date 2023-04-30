package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor implements Runnable {

    private static String ip;
    private static int porta = 10000;
    private static ArrayList<Socket> listaClientes = new ArrayList<Socket>();
    private Socket client;

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
            while(true){
               this.client = server.accept();
               listaClientes.add(client);
               new Thread(SubServ(client)).start();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Runnable SubServ(Socket client) {
        
        System.out.println("Conexão do cliente "+client.getInetAddress().getHostAddress());


        Scanner in;
        PrintStream out;
        try {
            in = new Scanner(client.getInputStream());
            out = new PrintStream(client.getOutputStream());
        } catch (IOException e) {
            return null;
        }
        String line;
        while (in.hasNextLine()) {
            
            line = in.nextLine();
            for (Socket c : listaClientes) {

                try {
                    out = new PrintStream(c.getOutputStream());
                    out.println(line);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        }
        return null;
        
    }

}
