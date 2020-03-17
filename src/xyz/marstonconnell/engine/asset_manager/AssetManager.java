package xyz.marstonconnell.engine.asset_manager;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import xyz.marstonconnell.engine.render.Sprite;

public class AssetManager {
	private final String assetPath;

	public AssetManager(String gameId) {
		assetPath = gameId + "/textures/";
	}

	public Sprite createSprite(String spriteName, int x, int y, int width, int height, int layer) throws IOException {
		Image img = ImageIO.read(getClass().getClassLoader().getResource(this.getAssetPath() + spriteName + ".png"));

		

		Sprite sprite = new Sprite(x, y, width, height, layer);
		sprite.setImage(img);

		return sprite;
	}

	public Sprite createSprite(String spriteName, int width, int height, int layer) throws IOException {
		return createSprite(spriteName, 0, 0, width, height, layer);
	}

	public Sprite createSprite(String spriteName, int layer) throws IOException {
		File file = new File(getClass().getClassLoader().getResource(this.getAssetPath() + spriteName + ".png").getFile());

		Image img = ImageIO.read(file);

		Sprite sprite = new Sprite(0, 0, img.getWidth(null), img.getHeight(null), layer);
		sprite.setImage(img);

		return sprite;
	}

	public String getAssetPath() {
		return assetPath;
	}
}
