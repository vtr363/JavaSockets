package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable {

    private static String ip;

    public String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Cliente.ip = ip;
    }

    public void run(){
        try (Socket cliente = new Socket(Cliente.ip, 10000)) {
            System.out.println("Conectado ao servidor!" + Cliente.ip);

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

    public Runnable msg(Socket cliente){
        try (Scanner s = new Scanner(cliente.getInputStream())) {
            while(s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            return null;
    }
}
