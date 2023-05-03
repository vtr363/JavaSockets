package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable{

    public String ip;
    private static PrintStream out;
    

    public Cliente(String ip) {
        this.ip = ip;
    }

    public void run(){
        try (Socket cliente = new Socket(this.ip, 10000)) {
            System.out.println("Cliente conectado ao servidor!");

            out = new PrintStream(cliente.getOutputStream());

            Scanner s = new Scanner(System.in);
            while(s.hasNextLine()){
                out.println(s.nextLine());
            }
            s.close();

            
            cliente.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void sendMsg(String msg){
        Scanner s = new Scanner(msg);
        while(s.hasNextLine()){
            out.println(s.nextLine());
        }
        s.close();
    }
}