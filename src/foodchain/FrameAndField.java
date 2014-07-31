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
	Wall wall;
	int ratio_w;
	int ratio_h;

	
	FrameAndField(int width, int height, int tile,Map map){
		
		field_W = width;
		field_H = height;
		field_T = tile;
		this.map = map;
		wall = new Wall(width,height,tile);
		ratio_w = field_W / field_T;
		ratio_h = field_H / field_T;

		
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
		g.drawLine(i*ratio_w, 0, i*ratio_w, field_H);
		g.drawLine(0 ,i*ratio_h, field_W, i*ratio_h);
		}
		
		wall.paint(g);
		
		for(MapObject mo:map){
			mo.paint(g);
		}
}
	
	

}


class Frame extends JFrame{
	/*int frame_W = 800;
	int frame_H = 800;
	*/
	Frame(String title, int width, int height){
		
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	
}