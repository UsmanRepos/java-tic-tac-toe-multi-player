/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayertictactoe;

/**
 *
 * @author Usman_Aslam
 */
public class MultiPlayerTictactoe {
    
    public static void main(String[] args)
    {
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        while(lf.flag)
        {
            System.out.println(lf.flag);
        }

        WaitingWindow ww = new WaitingWindow();
        ww.setVisible(true);
        System.out.println("Enter game");
        Game gameObj = new Game(ww);
    }
}
