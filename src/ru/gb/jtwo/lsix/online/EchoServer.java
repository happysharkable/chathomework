package ru.gb.jtwo.lsix.online;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189);
             Socket currentClient = serverSocket.accept()) {
            System.out.println("к нам подключился клиент!");
            DataInputStream in = new DataInputStream(currentClient.getInputStream());
            DataOutputStream out = new DataOutputStream(currentClient.getOutputStream());
            String b = in.readUTF();
            out.writeUTF("Echo: " + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
