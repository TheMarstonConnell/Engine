package roguelike_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import roguelike_game.entity.EntityBase;
import roguelike_game.entity.player.PlayerBase;
import xyz.marstonconnell.engine.Engine;
import xyz.marstonconnell.engine.render.Camera;
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
		
		Sprite background = engine.getAssetMan().createSprite("tiles/wood", -200, -200, 1000, 1000, 1);
		engine.addSprite(background);
		
		Sprite sp = new Sprite(0,0,0,0, 100);
		sp.setImage(sp.createColor(255, 255, 255));
		engine.addSprite(sp);
		
		
		engine.getUpdateTick().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				update();
				
			}
		});
	}
	
	public void update() {
		ArrayList<Integer> keys = engine.getKeysDown();
		
		float entitySpeed = 3f;
		
		if (keys.contains(KeyEvent.VK_A)){
			player.addDX(-entitySpeed);
		}
		else if (keys.contains(KeyEvent.VK_D)){
			player.addDX(entitySpeed);
		}
		if (keys.contains(KeyEvent.VK_S)){
			player.addDY(entitySpeed);
		}
		else if (keys.contains(KeyEvent.VK_W)){
			player.addDY(-entitySpeed);
		}
		
		for(EntityBase entity: entities) {
			entity.update();
		}
		
		centerCamera();
	}
	
	private void init() {
		entities = new ArrayList<EntityBase>();

	}
	
	public void centerCamera() {
		Camera cam = engine.getCamera();
		int width = engine.getWidth();
		int height = engine.getHeight();
		
		int x = player.x;
		int y= player.y;
		
		
		int newX = (int) ((x + player.width / 2) - width / 2);
		int newY = (int) ((y + player.height / 2) - height / 2);
		
		cam.setPos(newX, newY);
		
	}
	
	public static void main(String[] args) {
		try {
			RogueLike rl = new RogueLike();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
