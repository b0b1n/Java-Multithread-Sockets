package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client() throws IOException{
		Socket socket = new Socket("localhost",2022);
		System.out.println("Connection to the server established");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner keyboard = new Scanner(System.in);
		
		String message = in_socket.readLine();
		System.out.println(" 'Mr.Server' says ::: "+ message);
		message = keyboard.nextLine();
		out_socket.println(message);
		
		socket.close();
		System.out.println(socket.isClosed() ? "socket is closed." : " socket not closed yet."); 
		
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
