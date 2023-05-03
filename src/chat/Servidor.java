package chat;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Servidor implements Runnable{

    public static String ip;

    

    public Servidor() throws UnknownHostException, SocketException {
        Servidor.ip = this.getIpAddress();
    }



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

    public String getIpAddress() throws UnknownHostException, SocketException{
        DatagramSocket socket = new DatagramSocket();
        socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
        String ip = socket.getLocalAddress().getHostAddress();
        System.out.println(ip);
        socket.close();
        System.out.println("foioi");
        return ip;
    }
}