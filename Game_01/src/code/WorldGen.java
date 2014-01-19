package code;

public class WorldGen {

	public static void genWorld() {
		for(int x=0; x != 1200; x++ ){
			for(int y=0; y != 30; y++ ){ //30
				GenLoader.blocks[x][y].setid(0);
			}
			for(int y=30; y != 33; y++ ){
				GenLoader.blocks[x][y].setid(1);
			}
			for(int y=33; y != 1200; y++ ){ //30
				GenLoader.blocks[x][y].setid(10);
			}
		}
		
	}

}
