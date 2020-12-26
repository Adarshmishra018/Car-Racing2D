package Cars;

import java.awt.Color;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.MenuItem;

public class Car extends JFrame{
	public static boolean t2=true;
	
	public static void main(String[] args) throws IOException{
	
		JFrame app=new JFrame();//object of Jframe
		work w = null;//instance of clss work
		w = new work();
		try {
			w.work();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.add(w);//add work to frame
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to exit frame on cut button
		app.setSize(500,720);//size of frame
		app.setVisible(true);//to make frame visible
		app.setTitle("Car Racing 2D");//to set title of the frame
        app.setResizable(false);//to make frame resisable
       //// JPanel panel=new JPanel();
       // panel.setBackground(java.awt.Color.DARK_GRAY);
       // button button=new button("Play");
       // app.add(button);
       // app.add(panel);
       // app.setVisible(true);
        //panel.setVisible(true);
        //app.setVisible(true);
	      
	 }
}
