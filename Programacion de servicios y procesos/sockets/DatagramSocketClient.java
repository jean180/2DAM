import java.util.*;
import java.net.*;
import java.io.*;

public class DatagramSocketClient {
	
	InetAddress serverIP;
	int serverPort;
	DatagramSocket socket;
	
	public void init(String host, int port) throws SocketException, UnknownHostException{
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}

	public void runClient() throws IOException{
		
		byte [] receivedData = new byte[1024];
		byte [] sendingData;

		//a l’inici
		sendingData = getFirstRequest();

		//el servidor atén el port indefinidament
		while(mustContinue(sendingData)){
	
			DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);
			
			//enviament de la resposta
			socket.send(packet);

			//creació del paquet per rebre les dades
			packet = new DatagramPacket(receivedData, 1024);

			//espera de les dades, maximo 5 segundos
			socket.setSoTimeout(5000);
			try{
				socket.receive(packet);
			
				//processament de les dades rebudes i obtenció de la resposta
				sendingData = getDataToRequest(packet.getData(), packet.getLength());
			}catch(SocketTimeoutException e){
			}
		}
	}


	private byte[] getDataToRequest(byte[] data, int length) {
		//procés diferent per cada aplicació
		return data;
	}

	private byte[] getFirstRequest() {
		//procés diferent per cada aplicació
		return new byte[1024];
	}

	private boolean mustContinue(byte[] sendingData) {
		//procés diferent per cada aplicació
		return true;
	}
}
