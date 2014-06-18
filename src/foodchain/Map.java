package foodchain;

import java.util.ArrayList;

public class Map extends ArrayList<MapObject>{
	
	@Override
	public boolean add(MapObject e){
		if(e == null)	{return false;}
		
		return super.add(e);
		}
}
