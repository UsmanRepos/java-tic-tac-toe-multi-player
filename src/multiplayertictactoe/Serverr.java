
package multiplayertictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usman_Aslam
 */
public class Serverr {
    int count;
    int game;
    WaitingWindow ww;
    Socket s1 ,s2;
    
    public Serverr()
    {
        count = 0;
        game = 0; 
        s1 = null;
        s2 = null;
    }
    public void server_main()
    {
        try
        {
            ServerSocket ss = new ServerSocket(3456);
            System.out.println("Server Started\nWating for Client on " + ss.getLocalPort());
            while(true)
            {
                s2 = ss.accept();
                System.out.println("Just Connected to " + s2 + "\n");
                
                count++;
                
                if(count % 2 == 1)
                {
                    s1 = s2;
                    ww = new WaitingWindow();
                    ww.setVisible(true);
                    continue;
                }
                ww.dispose();
                game++;
                
                Thread t = new ClientHandler(s1,s2);
                t.run();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Serverr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args)
    {
        Serverr server = new Serverr();
        server.server_main();
    }
    static class ClientHandler extends Thread
    {
    
    
        final DataInputStream dis1, dis2;
        final DataOutputStream dos1, dos2;
        final Socket s1,s2;
    
        public ClientHandler(Socket s1, Socket s2) throws IOException
        {
            this.s1 = s1;
            this.s2 = s2;
            this.dis1 = new DataInputStream(s1.getInputStream());
            this.dis2 = new DataInputStream(s2.getInputStream());
            this.dos1 = new DataOutputStream(s1.getOutputStream());
            this.dos2= new DataOutputStream(s2.getOutputStream());
        }
        @Override
        public void run() 
        {
            String receive;
            String toreturn;
            String name = null;
            
            
            while(true)
            {
                try
                {
                    dos1.writeUTF("Your Turn");
                    receive = dis1.readUTF();
                    
                    dos2.writeUTF(receive);
                    receive = dis2.readUTF();
                    
                    
                    
                    
                    
                
                    /*if(receive.equals("Exit"))
                    {
                        System.out.println("Closing The Network of Client: " + this.s);
                    
                        names.remove(name);
                        writers.remove(dos);
                    
                        for(DataOutputStream dos: writers)
                        {
                            dos.writeUTF(name + " has Left");
                        }   
                        this.s.close();
                        this.dis.close();
                        this.dos.close();

                        break;
                    }
                
                    for(DataOutputStream doss: writers)
                    {
                        //if(!doss.equals(dos))
                        //{
                            doss.writeUTF(name + " : " + receive);
                        //}

                    }*/
                
                }
                catch(IOException e)
                {
                    System.out.println(e);
                } 
            
            }
        }
    }   
}
