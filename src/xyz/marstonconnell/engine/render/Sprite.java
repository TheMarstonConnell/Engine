package xyz.marstonconnell.engine.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sprite extends Rectangle{
	protected Image img;
	private Integer layer = 0;
	
	private boolean visible = true;
	
	public Sprite(int x, int y, int width, int height, Integer layer) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.layer = layer;
	}
	
	public void setImage(Image i) {
		this.img = i;
	}
	
	public Image getImage() {
		return this.img;
	}
	
	
	public BufferedImage createColor(int r, int g, int b) {
		BufferedImage bimg = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		Graphics graph = bimg.getGraphics();
		graph.setColor(new Color(r, g, b));
		graph.fillRect(0, 0, this.width, this.height);
		graph.dispose();
		return bimg;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
