package xyz.marstonconnell.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.google.gson.Gson;

import xyz.marstonconnell.engine.asset_manager.AssetManager;
import xyz.marstonconnell.engine.render.Camera;
import xyz.marstonconnell.engine.render.CustomCompare;
import xyz.marstonconnell.engine.render.Sprite;

public class Engine extends JFrame {

	private final String GameID;

	private Point mousePos = new Point(0, 0);

	private ArrayList<Integer> keysDown;

	boolean[] mouseClicks = { false, false, false };

	private ArrayList<Sprite> sprites;
	private Camera camera;

	// Drawing Strategy
	private Graphics2D graphics;
	private BufferStrategy strategy;

	private Gson gson;
	private Timer updateTick;
	private Timer renderTick;

	private int fps = 60;

	private AssetManager assetMan;

	int width;
	int height;

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	public Engine(int width, int height, String id) {

		this.setSize(width + this.getInsets().left * 2, height + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.width = width;
		this.height = height;

		this.GameID = id;

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				mousePos = new Point((int) (e.getPoint().x - getInsets().left),
						(int) (e.getPoint().y - getInsets().top));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
			}

		});

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				int dex = e.getButton() - 1;

				mouseClicks[dex] = false;

			}

			@Override
			public void mousePressed(MouseEvent e) {

				int dex = e.getButton() - 1;

				mouseClicks[dex] = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (keysDown.contains(e.getKeyCode())) {
					int dex = keysDown.indexOf(e.getKeyCode());
					keysDown.remove(dex);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (!keysDown.contains(e.getKeyCode())) {
					keysDown.add(e.getKeyCode());
				}

			}
		});

		init();
	}

	public boolean addSprite(Sprite toAdd) {

		boolean added = sprites.add(toAdd);
		sortSprites();
		return added;
	}

	public void sortSprites() {
		Collections.sort(sprites, new CustomCompare());
	}

	private void init() {

		System.out.println("Starting JavaEngine by Marston Connell & Spencer Antliff...");
		gson = new Gson();

		assetMan = new AssetManager(GameID);

		sprites = new ArrayList<Sprite>();
		camera = new Camera();
		keysDown = new ArrayList<Integer>();

		updateTick = new Timer(50, null);
		renderTick = new Timer(1000 / fps, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				redraw();
				showDrawing();
			}
		});

		updateTick.start();
		renderTick.start();
		createBufferStrategy(2);
	}

	private void redraw() {
		strategy = getBufferStrategy();
		graphics = (Graphics2D) strategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		int left = this.getInsets().left;
		int top = this.getInsets().top;

		for (int i = 0; i < sprites.size(); i++) {
			Sprite sp = sprites.get(i);
			if (sp.isVisible()) {
				if ((sp.getX() + left - camera.getX() <= this.getWidth()
						|| !(sp.getX() + left - camera.getX() + sp.getWidth() <= 0))
						&& (sp.getY() + top - camera.getY() <= this.getHeight()
								|| !(sp.getY() + top - camera.getY() + sp.getHeight() <= 0))) {
					g2d.drawImage(sp.getImage(), (int) (sp.getX() + left - camera.getX()),
							(int) (sp.getY() + top - camera.getY()), (int) sp.width, (int) sp.height, null);

				}
			}

		}

	}

	public void showDrawing() {
		graphics.dispose();
		strategy.show();
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public Timer getUpdateTick() {
		return updateTick;
	}

	public Timer getRenderTick() {
		return renderTick;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

	}

	public static void main(String[] args) {
		Engine engine = new Engine(1000, 800, "Engine");
	}

	public AssetManager getAssetMan() {
		return assetMan;
	}

	public void setAssetMan(AssetManager assetMan) {
		this.assetMan = assetMan;
	}

	public String getGameID() {
		return GameID;
	}

	public Point getMousePos() {
		return mousePos;
	}

	public ArrayList<Integer> getKeysDown() {
		return keysDown;
	}

	public ArrayList<Sprite> getSprites() {
		return sprites;
	}

	public Gson getGson() {
		return gson;
	}

}
