package chat;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Conexao {

    public static String getIpAddress() throws UnknownHostException, SocketException{
        DatagramSocket socket = new DatagramSocket();
        socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
        String ip = socket.getLocalAddress().getHostAddress();
        System.out.println(ip);
        socket.close();
        return ip;
    }
    
    

}
