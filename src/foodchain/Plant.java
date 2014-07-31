package foodchain;

import java.awt.Color;
import java.awt.Point;

public class Plant extends MapObject{
		Sfmt s;
		
		Plant(int x,int y,int radius,int w,int h,int tile,Sfmt s){
			this.pos = new Point(x,y);
			this.radius = radius;
			this.color = Color.BLUE;		
			this.tile = tile;
			this.w = w;
			this.h = h;
			this.s = s;		
		}
		
		
		boolean Sight(int direction,int distance){
			
			switch(direction){
			
			case 0:                        //上
				if(pos.y-distance*(h/tile) <= h/tile){return false;}
				break;
				
			case 1:                        //右
				if(pos.x+distance*(w/tile) >= w-(w/tile)){return false;}
				break;
				
			case 2:                        //下
				if(pos.y+distance*(h/tile) >= h-(h/tile)){return false;}
				break;
				
			case 3:                       //左
				if(pos.x-distance*(w/tile) <= w/tile){return false;}
				break;
			}
			return true;
		}
		
		int Sight_Enemy(int direction,int distance){
			return 1;
			
		}
		
		
		@Override
		Map action(Map map){
			Map m = new Map();
			
			
			
			switch(s.NextInt(4)){
			case 0:
				if(Sight(0,1)){this.pos.y -= h/tile;}
				break;
				
			case 1:
				if(Sight(1,1)){this.pos.x += w/tile;}
				break;
				
			case 2:
				if(Sight(2,1)){this.pos.y += h/tile;}
				break;
				
			case 3:
				if(Sight(3,1)){this.pos.x -= w/tile;}
				break;
			}
			
			m.add(this);
			return m;
		}
	
	}
