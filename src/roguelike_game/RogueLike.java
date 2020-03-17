package roguelike_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import roguelike_game.entity.EntityBase;
import roguelike_game.entity.player.PlayerBase;
import xyz.marstonconnell.engine.Engine;
import xyz.marstonconnell.engine.render.Sprite;

public class RogueLike {
	Engine engine;
	
	ArrayList<EntityBase> entities;
	
	PlayerBase player;
	
	public RogueLike() throws IOException {
		engine = new Engine(1080, 720, "roguelike");
		System.out.println("Starting RogueLike Game...");
		
		init();
		
		player = new PlayerBase("robot", 40, 40, 64, 64, engine.getAssetMan(), 10);
		player.createImage();
		engine.addSprite(player);
		entities.add(player);
		
		engine.getUpdateTick().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				update();
			}
		});
		
	}
	
	public void update() {
		ArrayList<Integer> keys = engine.getKeysDown();
		
		if (keys.contains(KeyEvent.VK_A)){
			player.addDX(-1f);
		}
		if (keys.contains(KeyEvent.VK_D)){
			player.addDX(1f);
		}
		if (keys.contains(KeyEvent.VK_S)){
			player.addDY(1f);
		}
		if (keys.contains(KeyEvent.VK_W)){
			player.addDY(-1f);
		}
		
		for(EntityBase entity: entities) {
			entity.update();
		}
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
