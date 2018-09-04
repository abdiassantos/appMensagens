package tcpclient;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class TCPClient {
    
    public static void main(String[] args) throws Exception{
        
        String hostname = "localhost";
        String sentence;
        String modifiedSentence;
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        try (Socket clientSocket = new Socket(hostname, 6789)) {
            
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            sentence = JOptionPane.showInputDialog("Insira sua Frase!");
            // sentence = inFromUser.readLine();
            
            outToServer.writeBytes(sentence + '\n');
            
            modifiedSentence = inFromServer.readLine();
            
            JOptionPane.showMessageDialog(null, "FROM SERVER: " + modifiedSentence);
            //System.out.println("FROM SERVER:" + modifiedSentence);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro aconteceu ao tentar conexão com o servidor!\nErro: " + ex);
        }
        
    }
    
}
