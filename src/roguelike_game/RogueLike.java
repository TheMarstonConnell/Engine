package roguelike_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import roguelike_game.entity.EntityBase;
import roguelike_game.entity.player.PlayerBase;
import xyz.marstonconnell.engine.Engine;
import xyz.marstonconnell.engine.render.Camera;
import xyz.marstonconnell.engine.render.Sprite;

public class RogueLike {
	Engine engine;
	
	ArrayList<EntityBase> entities;
	Timer initialTime;
	Timer finalTime;
	PlayerBase player;
	Sprite inventory;
	public RogueLike() throws IOException {
		engine = new Engine(1080, 720, "roguelike");
		System.out.println("Starting RogueLike Game...");
		
		init();
		
		player = new PlayerBase("robot", 40, 40, 64, 64, engine.getAssetMan(), 10);
		player.createImage();
		engine.addSprite(player);
		entities.add(player);
		Sprite background = engine.getAssetMan().createSprite("tiles/wood", -200, -200, 1000, 1000, 1);
		inventory = new Sprite(0,0,100,100,100);
		inventory.setImage(inventory.createColor(255, 0, 0));
		engine.addSprite(background);
		engine.addSprite(inventory);
		inventory.setVisible(false);
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
		if (keys.contains(KeyEvent.VK_I)) {
			System.out.println("dab");
				if (inventory.isVisible() == false){
				System.out.println();
				inventory.setVisible(true);
			}
			else {
				inventory.setVisible(false);
				
			}
			
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
