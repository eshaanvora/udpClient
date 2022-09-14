import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
*  UDP Server Program
*  Listens on a UDP port
*  Receives a line of input from a UDP client
*  Returns an upper case version of the line to the client.
*
*  @author: Michael Fahy
*
*  @version: 3.1
*/

class UdpServer {
  public static void main(String[] args) throws Exception {
    DatagramSocket serverSocket = null;

    try {
      serverSocket = new DatagramSocket(9876);
    } catch (Exception e) {
      System.out.println("Failed to open UDP socket");
      System.exit(0);
    }
    byte[] receiveData = null;
    byte[] sendData  = null;

    while (true) {
      //Server should always keep running, waiting for client connections
      System.out.println("Waiting for client response");
      receiveData = new byte[1024];
      sendData  = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      serverSocket.receive(receivePacket);
      //Encode byte array to String
      String sentence = new String(receivePacket.getData());
      System.out.println("FROM CLIENT: " + sentence);

      InetAddress ipAddress = receivePacket.getAddress();

      int port = receivePacket.getPort();

      String capitalizedSentence = sentence.toUpperCase();
      //Encode String to byte array
      sendData = capitalizedSentence.getBytes();

      DatagramPacket sendPacket =
          new DatagramPacket(sendData, sendData.length, ipAddress, port);

      serverSocket.send(sendPacket);
    }
  }
}
