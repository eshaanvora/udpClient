import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
*  UDP Client Program.
*  Connects to a UDP Server
*  Receives lines of input from keyboard until user types "Goodbye" & sends each line to server
*  Receives modified response (which is capitalized to UPPER CASE) from server and displays it after each line is sent
*
*  @author: Eshaan Vora
*     email: EshaanVora@gmail.com
*     date: 02/27/2022
*  @version: 3.1
*
* Reference: geeksforgeeks.org/working-udp-datagramsockets-java/
*/

class MyUdpClient {
  public static void main(String[] args) throws Exception {

    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

    DatagramSocket clientSocket = new DatagramSocket();

    InetAddress ipAddress = InetAddress.getByName("localhost");

    //SET NULL FOR LATER INITIALIZATION
    //VARIABLES WILL BE INITIALZIED WHEN USED TO STORE SENTENCE INFO
    byte[] sendData = null;
    byte[] receiveData = null;
    DatagramPacket sendPacket = null;
    DatagramPacket receivePacket = null;

    String sentence = "";
    String modifiedSentence = "";

    //PROMPT USER FOR SENTENCES UNITL USER TYPES "Goodbye"
    //SEND RESPONSES TO SERVER AFTER EACH SENTENSE, UNTIL USER QUITS
    while (true) {

      if (sentence.equals("Goodbye")) {
        break;
      }

      System.out.println("Type a Sentence");
      sentence = inFromUser.readLine();

      sendData = new byte[1024];
      receiveData = new byte[1024];

      //Encode string to byte array
      sendData = sentence.getBytes();
      //Send packet to the specified socket: 9876
      sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 9876);
      clientSocket.send(sendPacket);

      receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);

      //Encode byte array to String
      modifiedSentence = new String(receivePacket.getData());

      System.out.println("FROM SERVER: " + modifiedSentence);
    }

    //CLOSE SOCKET AFTER USER QUITS
    clientSocket.close();
  }
}
