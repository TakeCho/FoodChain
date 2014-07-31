/*
 *  いずれ実装プレイヤー
 *  キャラクター設定（肉食、草食、植物）
 *  任意に動かしてそれぞれの繁栄のために頑張る
 */


package foodchain;

import java.awt.Color;
import java.awt.Point;

public class Player extends MapObject {
	
	Player(int x,int y,int radius,int w,int h,int tile){
		this.pos = new Point(x,y);
		this.radius = radius;
		this.color = Color.red;		
		this.tile = tile;
		this.w = w;
		this.h = h;	
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
		
		
		switch(0){
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





