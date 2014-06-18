package foodchain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameAndField extends JPanel{
	
	int field_W;
	int field_H;
	int field_T;
	Map map;
	
	FrameAndField(int width, int height, int tile,Map map){
		
		field_W = width;
		field_H = height;
		field_T = tile;
		this.map = map;
		
	}
	
	void setMap(Map m){
		map = m;
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, field_W, field_H);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, field_W, field_H);
		
		for(int i=1;i<=field_T;i++){    //分割タイルの生成
		g.drawLine(i*field_W/field_T, 0, i*field_W/field_T, field_H);
		g.drawLine(0 ,i*field_H/field_T, field_W, i*field_H/field_T);
		}
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