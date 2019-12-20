package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connection {

    private BufferedReader bf;
    private PrintWriter writer;

    public Connection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ip адрес сервера:");
        String ip = scanner.nextLine();
        System.out.println("Введите порт сервера: ");
        int port = scanner.nextInt();
        start(ip, port);
    }

    private void start(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedReader getBf() {
        return bf;
    }

    public void setBf(BufferedReader bf) {
        this.bf = bf;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public void writeMessage(String message) {
        writer.println(message);
    }
}
