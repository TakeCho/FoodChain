package foodchain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class MapObject {
	
	Point pos;
	int radius;
	Color color;
	int tile;
	int w,h;
	
	Map action(Map map){
		Map m = new Map();
		m.add(this);
		return m;
	}
	
	
	void paint(Graphics g){
		g.setColor(color);
		g.fillOval(pos.x-radius, pos.y-radius, radius*2, radius*2);
	}

}
