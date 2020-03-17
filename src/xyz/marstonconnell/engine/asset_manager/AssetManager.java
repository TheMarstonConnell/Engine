package xyz.marstonconnell.engine.asset_manager;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import xyz.marstonconnell.engine.render.Sprite;

public class AssetManager {
	final String assetPath;

	public AssetManager(String gameId) {
		assetPath = gameId + "/textures/";
	}

	public Sprite createSprite(String spriteName, int x, int y, int width, int height) throws IOException {
		Image img = ImageIO.read(getClass().getClassLoader().getResource(this.assetPath + spriteName + ".png"));

		

		Sprite sprite = new Sprite(x, y, width, height);
		sprite.setImage(img);

		return sprite;
	}

	public Sprite createSprite(String spriteName, int width, int height) throws IOException {
		return createSprite(spriteName, 0, 0, width, height);
	}

	public Sprite createSprite(String spriteName) throws IOException {
		File file = new File(getClass().getClassLoader().getResource(this.assetPath + spriteName + ".png").getFile());

		Image img = ImageIO.read(file);

		Sprite sprite = new Sprite(0, 0, img.getWidth(null), img.getHeight(null));
		sprite.setImage(img);

		return sprite;
	}
}
