package roguelike_game.entity;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import xyz.marstonconnell.engine.asset_manager.AssetManager;
import xyz.marstonconnell.engine.render.Sprite;

public class EntityBase extends Sprite{
	
	//Physics
	float dx = 0;
	float dy = 0;
	float maxDx = 20;
	float maxDy = 20;
	float friction = 0.25f;
	
	AssetManager assetMan;
	String name;

	protected String getPath() {
		return "entity/";
	}
	
	public EntityBase(String name, int x, int y, int width, int height, AssetManager assetMan, int layer) {
		super(x, y, width, height, layer);
		this.assetMan = assetMan;
		this.name = name;
		
		
	}
	
	public void createImage() throws IOException {
		Image img = ImageIO.read(getClass().getClassLoader().getResource(this.assetMan.getAssetPath() + this.getPath() + this.name + ".png"));

		this.setImage(img);
	}
	
	public void setDX(float dx) {
		this.dx = dx;
		
	}
	
	public void setDY(float dy) {
		this.dy = dy;
	}
	
	public void addDX(float dx) {
		setDX(this.dx + dx);
	}
	
	public void addDY(float dy) {
		setDY(this.dy + dy);
	}
	
	public void update() {
		
		if(this.dx > this.maxDx) {
			this.dx = this.maxDx;
		}
		if(this.dy > this.maxDy) {
			this.dy = this.maxDy;
		}
		
		if(this.dx < -this.maxDx) {
			this.dx = -this.maxDx;
		}
		if(this.dy < -this.maxDy) {
			this.dy = -this.maxDy;
		}
		
		this.x += (int) this.dx;
		this.y += (int) this.dy;
		
		applyFriction();
		
		if(Math.abs(this.dx) < 0.03) {
			this.dx = 0f;
		}
		if(Math.abs(this.dy) < 0.03) {
			this.dy = 0f;
		}
			
		
	}
	
	public float getMaxDx() {
		return maxDx;
	}

	public void setMaxDx(float maxDx) {
		this.maxDx = maxDx;
	}

	public float getMaxDy() {
		return maxDy;
	}

	public void setMaxDy(float maxDy) {
		this.maxDy = maxDy;
	}

	public void applyFriction() {
		this.dx = this.dx * (1 - this.friction);
		this.dy = this.dy * (1 - this.friction);
	}

}
