package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connection {

    private String IP = "localhost";
    private int PORT = 1234;

    private BufferedReader bf;
    private PrintWriter writer;

    public Connection() {
        start(IP, PORT);
    }

    public void start(String ip, int port) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ip адрес сервера: ");
            ip = scanner.nextLine();
            Socket socket = new Socket(ip, port);
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
