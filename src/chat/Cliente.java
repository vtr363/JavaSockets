package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable {
    private static String ip;
    private int porta = 10000;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        Cliente.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void run() {

        try (Socket cliente = new Socket(Cliente.ip, porta)) {
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
