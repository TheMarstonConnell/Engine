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
	float maxDx = 20f;
	float maxDy = 20f;
	float friction = 0.8f;
	
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
		
		this.x += this.dx;
		this.y += this.dy;
		
		applyFriction();
		
		if(Math.abs(this.dx) < 0.02) {
			this.dx = 0f;
		}
		if(Math.abs(this.dy) < 0.02) {
			this.dy = 0f;
		}
		
		System.out.println("DX: " + this.dx + ", DY: " + this.dy);
		
		
	}
	
	public void applyFriction() {
		this.dx = this.dx * this.friction;
		this.dy = this.dy * this.friction;
	}

}
