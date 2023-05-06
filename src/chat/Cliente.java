package chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable{

    public String ip;
    private Socket cliente;
    private BufferedWriter out;

    public Cliente(String ip) {
        this.ip = ip;
    }

    public void run(){
        try {
            cliente = new Socket(this.ip, 10000);
            System.out.println("Cliente conectado ao servidor!");

            out = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));


            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) throws IOException{
        // Scanner s = new Scanner(msg);
        // while(s.hasNextLine()){
        //     out.println(s.nextLine());p
        // }
        // s.close();
        out.write(msg);
        out.newLine();
        out.flush();
        System.out.println(msg);
    }
}