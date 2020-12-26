package Cars;
//import javazoom.jl.decoder.JavaLayerException;

//import javazoom.jl.player.Player;

import java.awt.Color;


import sun.audio.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Timer;
import java.io.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class work extends JPanel implements ActionListener,KeyListener{//to use paintcomponent 

	
	private static final String AudioPlayer = null;
	private int space;//space between the opponent cars
	private int width=40;//width of the cars
	private int height=76;//height of the cars
	private int speed;//speed of the opponent cars
	private int speed2=speed;
	private int WIDTH=500;//width of frame
	private int HEIGHT=700;//width of frame
	private int move=20;
	private int count=0;
	private int n=5;
	
	public static Clip clip;
	
	private static ArrayList <Rectangle> ocars;
	private ArrayList <Rectangle> line;
	private Random rand;//to make opponents come randomly
	BufferedImage car1;
	BufferedImage car2;
	BufferedImage grass;
	BufferedImage road;
	BufferedImage tree;
	BufferedImage mountain;
	static Boolean linef=true;
	public static boolean play=true;

	//public static final String SONG="C:\\\\Users\\\\DELL\\\\eclipse-workspace\\\\CarRace\\\\res2\\\\Textures2\\\\Smoke On The Water With.mp3";
	
	Timer t;
	private static Rectangle car;
	
	public void work() throws IOException {
		car1=ImageIO.read(new File("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\ocar.png"));
		car2=ImageIO.read(new File("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\car.png"));
		grass=ImageIO.read(new File("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\grass.png"));
		tree=ImageIO.read(new File("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\tree1.png"));
		mountain=ImageIO.read(new File("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\mountain.png"));
		music("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\234.wav");
		t=new Timer(20,this);
		rand=new Random();//object of random
		ocars=new ArrayList<Rectangle>();//to make opponent cars 
		line=new ArrayList<Rectangle>();
		car=new Rectangle(WIDTH/2-90,HEIGHT-80,width,height);//car object to position our car
		space=300;
		speed=2;
		addKeyListener(this);
		setFocusable(true);

		addocars(true);
		addocars(true);
	//	addocars(true);
		addline(true);
		addline(true);
		addline(true);
		addline(true);
		addline(true);
		addline(true);
		addline(true);
		
		t.start();
		
	}
	
	public void addline(Boolean first) {
		int x=WIDTH/2-2;
		int y=700;
		int width=4;
		int height=100;
		int space=120;
		if(first) {
			line.add(new Rectangle(x,y-(line.size()*space),width,height));
		}else {
			line.add(new Rectangle(x,line.get(line.size()-1).y-space,width,height));
		}
	}
	
	public void addocars(boolean first) {//to add opponent cars and set their speed,width etc.
		int positionx=rand.nextInt()%2;//to take any random integer
		int x=0;
		int y=0;
		int Width=width;
		int Height=height;
				if(positionx==0) {//if even
					x=WIDTH/2-60;//opponent will come on left side
				}else {//if odd
					x=WIDTH/2+10;//opponent will come right side
				}
		if(first) {//to add spaces between the first and the second car
			ocars.add(new Rectangle(x,y-80-(ocars.size()*space),Width,Height));//position of first opponent car
		}else {
			ocars.add(new Rectangle(x,ocars.get(ocars.size()-1).y-350,Width,Height));//position of second opponent car
		}
		n=n+5;//to add score
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
	//	Graphics2D g2=(Graphics2D)g;
		//g.setColor(Color.green);
		g.drawImage(grass, 0, 0, WIDTH, HEIGHT, null);
		//g.drawImage(mountain, 0, 0, 500, 40, null);
		//g.fillRect(0,0,WIDTH,HEIGHT);//to make the grasses green
		//g.drawImage(road, WIDTH/2-130,0,230,HEIGHT,null);
		
		g.setColor(Color.DARK_GRAY);
	    g.fillRect(WIDTH/2-100,0,200,HEIGHT);//to make the road grey
		//g.setColor(Color.red);
		//g.fillRect(car.x, car.y, car.width, car.height);//to make my car rectangle red
	  //  g2.setStroke(new BasicStroke(10));
		g.setColor(Color.white);
		//g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);//to make the white lines in between the road
		//g.drawLine(WIDTH/2, 400, WIDTH/2, 550);
       for(Rectangle rect:line) {
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
       }
		//g.fillRect((WIDTH/2)-5, 50, (WIDTH/2), 200);
		g.drawImage(car1, car.x, car.y, null);//to draw the image of the car
		//g.drawImage(tree, 80, h1, null);
	   // g.drawImage(tree, 360, h2, null);
	  /*  g.drawImage(rock, 450, h2+150, null);
	    g.drawImage(rock,30 , h2-290, null);
	    g.drawImage(rock,400 , h2-420, null);
	    g.drawImage(rock,50 , h2+400, null);
	    g.drawImage(tree, 80, h3, null);
	    g.drawImage(tree, 360, h4, null);
		if(h1>300)
		g.drawImage(tree, 80, h5, null);
		if(h2>450)
		g.drawImage(tree, 360, h6, null);*/
	//	g.setColor(Color.black);
		//g.drawImage(boundary,WIDTH/3-17, 0, 30, HEIGHT,null);
	//	g.drawLine(WIDTH/3-17, 0, WIDTH/3-17, HEIGHT);//to draw the black outline on both side of the road
	//	g.setColor(Color.black);
	 //   g.drawLine(WIDTH/2+100, 0,WIDTH/2+100, HEIGHT);
		//g.setColor(Color.ORANGE);
		//ro+=2;
		for(Rectangle rect:ocars) {
			
			//g.fillRect(rect.x, rect.y, rect.width, rect.height);// to draw the opponent orange rectangles
			g.drawImage(car2, rect.x, rect.y, null);// to draw the image of the opponent cars
			g.drawImage(tree, 110, rect.y-40, null);
			g.drawImage(tree, 360, rect.y+150, null);	
			
			
			
		}
		//drawImage(mountain, 0, 2, 148, 45,  null);
		//g.drawImage(mountain, 352, 2, 152, 45, null);
		
		for(Rectangle r:ocars){
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));//set font of score
			g.drawString("Score:"+n,6,350);//print score
			if(r.intersects(car)) {
				g.setColor(Color.orange);
				g.setFont(new Font("serif",Font.BOLD,90));//set font of game over
				g.drawString("Game Over",20,300);//print
				//g.drawString("Score:"+n,200,150);
				car.y=r.y+height;//top push the cars backward by opponent
				play=false;
				t.stop();//to stop the game after crashing
				clip.stop();
			}
			}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Rectangle rect;
		count++;
	  
		for(int i=0;i<ocars.size();i++) {
			rect=ocars.get(i);
			if(count%1000==0) {
				speed++;
				if(move<10) {
					move+=10;
				}
			}
			rect.y+=speed;
			
		}
		//cars crashing with opponent
		for(Rectangle r:ocars){
			//if(r.intersects(car)) {
				//car.y=r.y+height;
			//	ocars.remove(rect);
				//addocars(false);
			//}
		}
		for(int i=0;i<ocars.size();i++) {
			rect=ocars.get(i);
			if(rect.y+30>HEIGHT) {
				ocars.remove(rect);
				addocars(false);
				
			}
		}
		
		for(int i=0;i<line.size();i++) {
			rect=line.get(i);
			if(count%1000==0) {
				speed2++;
			}
			rect.y+=speed;
			
		}
		
		for(int i=0;i<line.size();i++) {
			rect=line.get(i);
			if(rect.y>HEIGHT) {
				line.remove(rect);
				addline(false);
				
			}
		}
		
		repaint();
		//music("C:\\\\\\\\Users\\\\\\\\DELL\\\\\\\\eclipse-workspace\\\\\\\\CarRace\\\\\\\\res2\\\\\\\\Textures2\\\\\\\\123.wav");
		
	}
	//moving
	public void moveup() {
		if(car.y-move<0) {
			//System.out.println("\b");
		}else {
			car.y-=move;
		/*	h1+=move;
			h2+=move;
			h3+=move;
			h4+=move;
			h5+=move;
			h6+=move;*/
		}
	}

	public void movedown() {
		if(car.y+move+car.height>HEIGHT-7) {
			//System.out.println("\b");
		}else {
			car.y+=move;
			/*h1-=move;
			h2-=move;
			h3-=move;
			h4-=move;
			h5-=move;
			h6-=move;*/
		}
	}
	
	public void moveleft() {
		if(car.x-move<WIDTH/2-70) {
			//System.out.println("\b");
		}else {
			car.x-=move;
		}
	}
	
	public void moveright() {
		if(car.x+move>WIDTH/2+30) {
			//System.out.println("\b");
		}else {
			car.x+=move;
		
		}
	}
//	@Override
/*	public void keyPressed1(KeyEvent e) {
		
		
	}*/

	//@Override
	int i=1;
	int j=1;
	public void keyReleased(KeyEvent e) {
		
	
		int key=e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			moveup();
			break;
		case KeyEvent.VK_DOWN:
			movedown();
			break;
		case KeyEvent.VK_LEFT:
			moveleft();
			break;
		case KeyEvent.VK_RIGHT:
			moveright();
			break;	
		case KeyEvent.VK_SPACE:
			//music("C:\\\\\\\\Users\\\\\\\\DELL\\\\\\\\eclipse-workspace\\\\\\\\CarRace\\\\\\\\res2\\\\\\\\Textures2\\\\\\\\234.wav");
			if(i%2==1) {
			    clip.stop(); 
			}else {
				clip.start();
			}
			i++;
			//clip.loop(100);
			break; 
		case KeyEvent.VK_ENTER:
			if(j%2==1) {
			t.stop();
			clip.stop();
			}else {
				t.restart();
				clip.start();
			}
			j++;
			break;
		
		default:
			break;
		}
	}

	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

 public static void music(String filepath) {
	
	 try {
	
		 AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File("C:\\Users\\DELL\\eclipse-workspace\\CarRace\\src\\Cars\\icons\\234.wav").getAbsoluteFile());
		 clip=AudioSystem.getClip();
		 clip.open(audioInputStream);
		 clip.start();
		 clip.loop(1000000);
		 
		 	 }catch(Exception ex) {
		
		
	 }
	 
 }


 }
 







