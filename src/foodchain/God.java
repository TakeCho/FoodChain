package foodchain;

import java.awt.Color;
import java.awt.Point;

public class God {
	
	int width;
	int height;
	int tile;
	
	God(int width, int height,int tile){
		this.width = width;
		this.height = height;
		this.tile = tile;
	}
	
	
	Map update(Map map){
		Map newMap = new Map();
		Map m = map;
		
		for(MapObject mo: m){
			newMap.addAll(filter(mo,m,newMap));
		}
		
		return newMap;
	}
	
	
	Map filter(MapObject mo, Map nowMap, Map nextMap){
		
		Map newMap = new Map();
		Map actMap = mo.action(nowMap);
		MapObject newMo = null;
		
		
		for(MapObject actMo: actMap){
			newMo = outOfBoundsFilter(actMo);
			
			if(canCreate(newMo, nextMap)){
				newMap.add(newMo);
			}
		}
		
		if(actMap.size() == 1 && newMap.size() == 0){
			if(canCreate(mo, nextMap)){newMap.add(mo);}
			
			//return newMap;
			}
		return newMap;
	}
	
	
	
	MapObject outOfBoundsFilter(MapObject mo){ 
		if(mo.pos.x-mo.radius < 0
				|| mo.pos.y-mo.radius < 0
				|| mo.pos.x+mo.radius > width
				|| mo.pos.y+mo.radius > height)
					return null;
				return (MapObject)mo;
	}
	
	boolean create(MapObject mo, Map map){
		if(outOfBoundsFilter(mo) == null || !canCreate(mo,map)){
			return false;
		}
		map.add(mo);
		return true;
	}
	
	
	boolean canCreate(MapObject mo, Map map){
		for(MapObject mo2: map){
			if(collision(mo,mo2)){
				return false;
		}
		}
			return true;
			}
	
	
	boolean collision(MapObject mo1, MapObject mo2){
	/*	System.out.println("mo:x = "+mo1.pos.x);
		System.out.println("mo:y = "+mo1.pos.y);
		System.out.println("mo2:x = "+mo2.pos.x);
		System.out.println("mo2:y = "+mo2.pos.y);
		*/
		
		
		int r = mo1.radius + mo2.radius;
		
		if(getDistance2(mo1.pos, mo2.pos) <= r*r  && mo1.color.equals(Color.RED) && mo2.color.equals(Color.BLUE)){return false;}
		if(getDistance2(mo1.pos, mo2.pos) <= r*r  && mo1.color.equals(Color.BLUE) && mo2.color.equals(Color.RED)){return false;}
		
		
		if(getDistance2(mo1.pos, mo2.pos) <= r*r && !mo1.color.equals(mo2.color)){return true;}               //falseだと消えない
		
		
		return false;
	}
	
	int collosion_enemy(MapObject mo1, MapObject mo2){
		int r = 2*(mo1.radius + mo2.radius);    //視野　自分の２倍
		
		return 1;
	}
	
	
	
	int getDistance2(Point a,Point b){
		int dx = a.x - b.x;
		int dy = a.y - b.y;
		
		return dx*dx + dy*dy;
	}
	
	
	}
	
	
