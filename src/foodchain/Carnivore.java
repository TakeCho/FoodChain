package foodchain;

import java.awt.Color;
import java.awt.Point;

public class Carnivore extends MapObject{
	
	Sfmt s;
	int view = 4;
	
	Carnivore(int x,int y,int radius,int w,int h,int tile,Sfmt s){
		this.pos = new Point(x,y);
		this.radius = radius;
		this.color = Color.red;		
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
	
	
	@Override
	Map action(Map map){
		Map m = new Map();
		
		int x = this.pos.x;
		int y = this.pos.y;
		
		int dis = s.NextInt(4);
		
		for(MapObject mo: map){
			if(((x-view*this.radius) > mo.pos.x || mo.pos.x > (x+view*this.radius))  ||  ((y-view*this.radius) > mo.pos.y || mo.pos.y > (y+view*this.radius))){
				
				//判定外なので
				//なにもしない
				this.color = Color.RED;
				
			}else if(mo.color.equals(Color.GREEN)){
				dis = 4;
				//this.color = Color.PINK;
					if((x - mo.pos.x)>0 && (y - mo.pos.y)>0 && Sight(1,1) && Sight(2,1)){this.pos.x -= w/tile; this.pos.y -= h/tile; break;}     //左上にえさ  
					if((x - mo.pos.x)==0 && (y - mo.pos.y)>0 && Sight(2,1)){this.pos.y -= h/tile; break;}     									 //上にえさ 
					if((x - mo.pos.x)< 0 && (y - mo.pos.y)>0 && Sight(3,1) && Sight(2,1)){this.pos.x += w/tile; this.pos.y -= h/tile; break;}    //右上にえさ  
					if((x - mo.pos.x)>0 && (y - mo.pos.y)==0 && Sight(1,1)){this.pos.x -= w/tile; break;}     									 //左にえさ  
					if((x - mo.pos.x)< 0 && (y - mo.pos.y)==0 && Sight(3,1)){this.pos.x += w/tile; break;}     									 //右にえさ  
					if((x - mo.pos.x)>0 && (y - mo.pos.y)<0 && Sight(0,1) && Sight(1,1)){this.pos.x -= w/tile; this.pos.y += h/tile; break;}     //左下にえさ  
					if((x - mo.pos.x)==0 && (y - mo.pos.y)<0 && Sight(0,1)){this.pos.y += h/tile; break;}     									 //下にえさ  
					if((x - mo.pos.x)< 0 && (y - mo.pos.y)<0 && Sight(0,1) && Sight(3,1)){this.pos.x += w/tile; this.pos.y += h/tile; break;}    //右下にえさ 		
			}
		}
			
		switch(dis){
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
