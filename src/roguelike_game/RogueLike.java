package roguelike_game;

import java.io.IOException;
import java.util.ArrayList;

import roguelike_game.entity.EntityBase;
import roguelike_game.entity.player.PlayerBase;
import xyz.marstonconnell.engine.Engine;
import xyz.marstonconnell.engine.render.Sprite;

public class RogueLike {
	Engine engine;
	
	ArrayList<EntityBase> entities;
	
	public RogueLike() throws IOException {
		engine = new Engine(1080, 720, "roguelike");
		System.out.println("Starting RogueLike Game...");
		
		init();
		
		PlayerBase i = new PlayerBase("robot", 40, 40, 64, 64, engine.getAssetMan(), 10);
		i.createImage();
		engine.addSprite(i);
		
		
		
	}
	
	private void init() {
		entities = new ArrayList<EntityBase>();

	}
	
	public static void main(String[] args) {
		try {
			RogueLike rl = new RogueLike();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
