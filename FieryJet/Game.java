import java.io.File;
import java.io.IOException;

import java.lang.Thread;
import java.lang.Runnable;

import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;

import javax.imageio.ImageIO;

import javax.swing.JFrame;



public class Game extends JFrame implements Runnable{

public static int alpha = 0xFFFFC0CB;
private Canvas canvas = new Canvas();
private RenderHandler renderer;
private SpriteSheet sheet;
private SpriteSheet playerSheet;
private int selectedTileID = 2;
private Rectangle testRectangle = new Rectangle(30, 30, 100, 100);
private Tiles tiles;
private Map map;
private GameObject[] objects;
private KeyboardListener keyListener = new KeyboardListener(this);
private MouseEventListener mouseListener = new MouseEventListener(this);
private Player player;
private int xZoom = 3;
private int yZoom = 3;

	public Game(){
		// Make the program shutdown when you exit out.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the position and size of the frame.
		setBounds(0,0, 1920, 1080);

		// Put the frame in the center of the screen.
		setLocationRelativeTo(null);

		// Add the graphics component.
		add(canvas);

		// Make the frame visible.
		setVisible(true);

		// Create the object for buffer strategy.
		canvas.createBufferStrategy(3);

		renderer = new RenderHandler(getWidth(), getHeight());

		// Load assets.
		BufferedImage sheetImage = loadImage("Tiles.png");
		sheet = new SpriteSheet(sheetImage);
		sheet.loadSprites(16, 16);
		BufferedImage playerSheetImage = loadImage("Player.png");
		playerSheet = new SpriteSheet(playerSheetImage);
		playerSheet.loadSprites(20, 26);

		// Player animated sprites.
		AnimatedSprite playerAnimations = new AnimatedSprite(playerSheet, 5);

		// Load tiles.
		tiles = new Tiles(new File("Tiles.txt"), sheet);

		// Load map.
		map = new Map(new File("Map.txt"), tiles);

		//testImage = loadImage("Grass.png");
		//testSprite = sheet.getSprite(3, 3);

		testRectangle.generateGraphics(3, 12345);

		// Load SDK GUI.
		GUIButton[] buttons = new GUIButton[tiles.size()];
		Sprite[] tileSprites = tiles.getSprites();

		for (int i = 0; i < buttons.length; i++){
			Rectangle tileRectangle = new Rectangle(0, i * (16 * xZoom + 2), 16 *
			xZoom, 16 * yZoom);
			buttons[i] = new SDKButton(this, i, tileSprites[i], tileRectangle);
		}

		GUI gui = new GUI(buttons, 5, 5, true);

		// Load objects.
		objects = new GameObject[2];
		player = new Player(playerAnimations);
		objects[0] = player;
		objects[1] = gui;

		// Add listeners.
		canvas.addKeyListener(keyListener);
		canvas.addFocusListener(keyListener);
		canvas.addMouseListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);
	}

	private BufferedImage loadImage(String path){
		try{
			BufferedImage loadedImage = ImageIO.read(Game.class.getResource(path));
			BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(),
			loadedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null);
			return formattedImage;
		} catch (IOException e){
			e.printStackTrace();
			return null;
		}
	}

	public void update(){
		for (int x = 0; x < objects.length; x++){
			objects[x].update(this);
		}
	}

	public void handleCTRL(boolean[] keys){
		if (keys[KeyEvent.VK_S]){
			map.saveMap();
		}
	}

	public void leftClick(int x, int y){
		Rectangle mouseRectangle = new Rectangle(x, y, 1, 1);
		boolean stoppedChecking = false;

		for (int i = 0; i < objects.length; i++){
			if (!stoppedChecking){
				stoppedChecking = objects[i].handleMouseClick(mouseRectangle,
				renderer.getCamera(), xZoom, yZoom);
			}
		}

		if (!stoppedChecking){
			x = (int) Math.floor((x + renderer.getCamera().x) / (16.0 * xZoom));
			y = (int) Math.floor((y + renderer.getCamera().y) / (16.0 * yZoom));
			map.setTile(x, y, selectedTileID);
		}
	}

	public void rightClick(int x, int y){
		x = (int) Math.floor((x + renderer.getCamera().x) / (16.0 * xZoom));
		y = (int) Math.floor((y + renderer.getCamera().y) / (16.0 * yZoom));
		map.removeTile(x, y);
	}

	public void render(){
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics graphics = bufferStrategy.getDrawGraphics();
		super.paint(graphics);
		map.render(renderer, xZoom, yZoom);

		for (int y = 0; y < objects.length; y++){
			objects[y].render(renderer, xZoom, yZoom);
		}

		renderer.render(graphics);
		graphics.dispose();
		bufferStrategy.show();
		renderer.clear();
	}

	public void changeTile(int tileID){
		selectedTileID = tileID;
	}

	public int getSelectedTile(){
		return selectedTileID;
	}

	public void run(){
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		int i = 0;
		int x = 0;

		// long 2^63.
		long lastTime = System.nanoTime();

		// 60 frames per second.
		double nanoSecondConversion = 1000000000.0 / 60;

		double changeInSeconds = 0;

		while (true){
			long now = System.nanoTime();
			changeInSeconds += (now - lastTime) / nanoSecondConversion;
			while (changeInSeconds >= 1){
				update();
				changeInSeconds--;
			}
			render();
			lastTime = now;
		}
	}

	public KeyboardListener getKeyListener(){
		return keyListener;
	}

	public MouseEventListener getMouseListener(){
		return mouseListener;
	}

	public RenderHandler getRenderer(){
		return renderer;
	}

	public static void main(String[] args){
		Game game = new Game();
		Thread gameThread = new Thread(game);

		gameThread.start();
	}

}
