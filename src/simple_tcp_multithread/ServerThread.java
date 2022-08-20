package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Runnable is a template for an object that  is meant to be executed by a thread
 */
public class ServerThread implements Runnable {
	/*
	 * socket is defined private because we don't want other thread/classes to
	 * access it
	 */
	private Socket socket;
	private ServerMain server_main;
	
	public ServerThread(Socket socket, ServerMain server_main) {
		this.socket = socket;
		this.server_main = server_main;
	}

	@Override
	public void run() {
		try {
			int client_number = server_main.getClientNumber();
			System.out.println("Client "+client_number+" has connected");
			// I/O buffers:
			/*
			 * Data coming from the client to the socket
			 */
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/*
			 * Outgoing data sent from the server to the client
			 */
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			out_socket.println("Welcome Client "+client_number+"! What can I call you ?"); // sending a message to the Client
			String message = in_socket.readLine(); // Storing what the Client wrote ("Thanks Mr.Server!")
			System.out.println(" 'Mr.Client' says ::: " + message); // display Client's message in the console

			socket.close();
			System.out.println("Client "+client_number+" is disconnected.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
