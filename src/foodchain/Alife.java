package foodchain;

class Alife {
	
	public static void main(String[] args){
		
		int width = 800;
		int height = 800;
		
		Frame frame = new Frame("食物連鎖を想定した人工生命",width+20,height+50);
		frame.setVisible(true);
		
		FrameAndField faf = new FrameAndField(width,height);
		frame.add(faf);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println(e);
			}
			
			
			
		}
	}
}
