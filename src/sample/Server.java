package sample;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static sample.FileOperations.readFromFile;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, ClientInfo> clientMap;
    public List<Player> tmp=new ArrayList<>();
    public List<Player>playerList=new ArrayList();
    private int tmpe=0;
    public Server() throws Exception{
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                if(tmpe==0) {
                    playerList = readFromFile();
                    tmpe = 1;
                }
                serve(clientSocket,playerList);
            }
        } catch (Exception e) {
            System.out.println("server.Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket,List<Player>playerList) throws Exception {

        NetworkUtil networkUtil = new NetworkUtil(clientSocket);

        new ReadThreadServer(clientMap, networkUtil,tmp,playerList);
    }

    public static void main(String args[]) throws Exception {
        Server server = new Server();
    }
}
