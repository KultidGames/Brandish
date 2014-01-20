package code; //Creation

public class GenLoader {
	protected static Terrain[][] blocks;
	public static void create(){
		blocks  = new Terrain[1200][1200];
		for(int x = 0; x != 1200; x++){
			for(int y = 0; y != 30; y++){
				blocks[x][y] = new Terrain();
			}
		}
		WorldGen.genWorld();
	}
	public static void blocks() {
		// TODO Auto-generated method stub
		
	}
}
