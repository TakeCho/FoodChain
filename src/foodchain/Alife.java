package foodchain;

class Alife {
	
	public static void main(String[] args){
		
		int width = 800;
		int height = 800;
		
		Frame frame = new Frame("�H���A����z�肵���l�H����",width+20,height+50);
		frame.setVisible(true);
		
		World world = new World(width,height);
		frame.add(world);
	}
//s
}
