package testing;

import java.io.IOException;

import xyz.marstonconnell.engine.Engine;
import xyz.marstonconnell.engine.render.Sprite;

public class RogueLike {
	Engine engine;
	
	public RogueLike() throws IOException {
		engine = new Engine(1080, 720, "roguelike");
		System.out.println("Starting RogueLike Game...");
		Sprite i = engine.getAssetMan().createSprite("characters/robot", 20, 40, 64, 64);
		engine.addSprite(i);
		
	}
	
	public static void main(String[] args) {
		try {
			RogueLike rl = new RogueLike();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
