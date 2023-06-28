package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8889;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            String responce = in.readLine();
            System.out.println(responce);
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);
            responce = in.readLine();
            System.out.println(responce);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
