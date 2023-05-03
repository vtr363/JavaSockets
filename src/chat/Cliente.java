package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable{
    public void run(){
        try (Socket cliente = new Socket("10.136.64.9", 10000)) {
            System.out.println("Cliente conectado ao servidor!");

            Scanner s = new Scanner(System.in);
            PrintStream out = new PrintStream(cliente.getOutputStream());

            
            
            while(s.hasNextLine()) {
                out.println(s.nextLine());
            }

            out.close();
            s.close();
            cliente.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}