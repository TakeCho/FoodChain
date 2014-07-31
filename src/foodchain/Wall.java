package foodchain;

import java.awt.Color;
import java.awt.Graphics;

public class Wall {
	
	int w,h,t;
	int ratio_w;
	int ratio_h;
	
	Wall(int w,int h,int t){
		
		this.w = w;
		this.h = h;
		this.t = t;
		
		ratio_w = w / t;
		ratio_h = h / t;
		
	}

	
	void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, w, ratio_h);
		g.fillRect(0, 0, ratio_w, h);
		g.fillRect(w-ratio_w, 0, w,h);
		g.fillRect(0, h-ratio_h, w,h);
		
		
	}
	
}
