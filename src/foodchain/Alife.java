/*
 * 赤は肉食
 * 緑は草食
 * 青は植物
 * 
 * 肉食は草食を食べる
 * 草食は植物を食べる
 * 肉食と植物は干渉しない
 * 
 * 
 * 実装したいこと
 * プレイヤーの実装
 * 視野の実装（肉食は追う、草食は逃げる）
 *　植物の増殖、数
 */





package foodchain;

class Alife {
	
	public static void main(String[] args){
		
//サイズ指定
		int width = 600;
		int height = 600;
		int tile = 40;
		Map map = new Map();
		God god = new God(width,height,tile);
		//Wall wall = new Wall(width,height,tile);
		int ratio_w = width / tile;
		int ratio_h = height / tile;
		
		
//フレーム生成		
		Frame frame = new Frame("食物連鎖を想定した人工生命",width+10,height+30);
		frame.setVisible(true);
		
		FrameAndField faf = new FrameAndField(width,height,tile,map);
		frame.add(faf);
	
		
//ここから生命呼び出し
		int seed = (int)System.currentTimeMillis();  //メルセンヌツイスタ生成
		Sfmt s = new Sfmt(seed); 
		
		int x,y;
	
//生命の個数設定		
		int carnivore = 20;
		int herbivore = 30;
		int plant = 30;
		
		
//肉食動物生成
		while(carnivore > 0){
			x = s.NextInt(tile);
			y = s.NextInt(tile);
			if(x<=2 || x>=tile-2 || y<=2 || y>=tile-2){continue;}
			
			int seedtmp = s.NextInt(100000);        //突然変異用乱数（未実装）
			
		if(god.create(new Carnivore((2*x+1)*ratio_w/2,(2*y+1)*ratio_h/2,(int)(ratio_h*0.4),width,height,tile, new Sfmt(seedtmp)), map)){
			carnivore--;
		}
		}	

		
//草食動物生成
		while(herbivore > 0){
			x = s.NextInt(tile);
			y = s.NextInt(tile);
			if(x<=2 || x>=tile-2 || y<=2 || y>=tile-2){continue;}
			
			int seedtmp = s.NextInt(100000);        //突然変異用乱数（未実装）
			
		if(god.create(new Herbivore((2*x+1)*ratio_w/2,(2*y+1)*ratio_h/2,(int)(ratio_h*0.4),width,height,tile, new Sfmt(seedtmp)), map)){
			herbivore--;
		}
		}
		

//植物生成
				while(plant > 0){
					x = s.NextInt(tile);
					y = s.NextInt(tile);
					if(x<=2 || x>=tile-2 || y<=2 || y>=tile-2){continue;}
						
					int seedtmp = s.NextInt(100000);        //突然変異用乱数（未実装）
					
				if(god.create(new Plant((2*x+1)*ratio_w/2,(2*y+1)*ratio_h/2,(int)(ratio_h*0.4),width,height,tile, new Sfmt(seedtmp)), map)){
					plant--;
				}
				}
						
			
//Playerクラスからプレイヤーの生成、ゲーム要素の導入（未実装）
/*if(false){
god.create(new Player((2*2+1)*ratio_w/2,(2*2+1)*ratio_h/2,(int)(ratio_h*0.4),width,height,tile), map);
}			
*/		

//ここでループ
int time = 3000;
		while(time>0){
			try{
				Thread.sleep(100);
				time-=100;
			}catch(Exception e){
				System.out.println(e);
			}
			
			map = god.update(map);
			faf.setMap(map);
			faf.repaint();
			
			
			
		}
		
		int count_c = 0;
		int count_h = 0;
		int count_p = 0;
		
		for(MapObject m: map){
			if(m.getClass().getName().equals("foodchain.Carnivore")){count_c++;}
		    if(m.getClass().getName().equals("foodchain.Herbivore")){count_h++;}
		    if(m.getClass().getName().equals("foodchain.Plant")){count_p++;}
		}
		
		System.out.println("肉食残数 : "+count_c);
		System.out.println("草食残数 : "+count_h);
		System.out.println("植物残数 : "+count_p);

		//map.clear();
		
	}
	}
	
