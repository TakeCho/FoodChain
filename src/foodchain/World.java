package foodchain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel{
	
	int field_W;
	int field_H;
	
	
	World(int width, int height){
		
		field_W = width;
		field_H = height;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, field_W, field_H);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, field_W, field_H);
}
	
	

}


class Frame extends JFrame{
	int frame_W = 800;
	int frame_H = 800;
	
	Frame(String title, int width, int height){
		
		setTitle(title);
		setSize(frame_W,frame_H);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	
}