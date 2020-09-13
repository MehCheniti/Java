import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;



public class RenderHandler{

private BufferedImage view;
private Rectangle camera;
private int[] pixels;

	public RenderHandler(int width, int height){
		// Create a BufferedImage that will represent our view.
		view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		camera = new Rectangle(0, 0, width, height);

		// Create an array for pixels.
		pixels = ( (DataBufferInt) view.getRaster().getDataBuffer()).getData();
	}

	// Renders our array of pixels to the screen.
	public void render(Graphics graphics){
		graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
	}

	// Renders our image to our array of pixels.
	public void renderImage(BufferedImage image, int xPosition, int yPosition,
	int xZoom, int yZoom, boolean fixed){
		int[] imagePixels = ( (DataBufferInt)
		image.getRaster().getDataBuffer()).getData();
		renderArray(imagePixels, image.getWidth(), image.getHeight(), xPosition,
		yPosition, xZoom, yZoom, fixed);
	}

	public void renderSprite(Sprite sprite, int xPosition, int yPosition,
	int xZoom, int yZoom, boolean fixed){
		renderArray(sprite.getPixels(), sprite.getWidth(), sprite.getHeight(),
		xPosition, yPosition, xZoom, yZoom, fixed);
	}

	public void renderRectangle(Rectangle rectangle, int xZoom, int yZoom,
	boolean fixed){
		int[] rectanglePixels = rectangle.getPixels();

		if (rectanglePixels != null){
			renderArray(rectanglePixels, rectangle.w, rectangle.h, rectangle.x,
			rectangle.y, xZoom, yZoom, fixed);
		}
	}

	public void renderRectangle(Rectangle rectangle, Rectangle offset, int xZoom,
	int yZoom, boolean fixed){
		int[] rectanglePixels = rectangle.getPixels();

		if (rectanglePixels != null){
			renderArray(rectanglePixels, rectangle.w, rectangle.h, rectangle.x +
			offset.x, rectangle.y + offset.y, xZoom, yZoom, fixed);
		}
	}

	public void renderArray(int[] renderPixels, int renderWidth,
	int renderHeight, int xPosition, int yPosition, int xZoom, int yZoom,
	boolean fixed){
		 for (int i = 0; i < renderHeight; i++){
 			for (int j = 0; j < renderWidth; j++){
 				for (int yZoomPosition = 0; yZoomPosition < yZoom; yZoomPosition++){
 					for (int xZoomPosition = 0; xZoomPosition < xZoom; xZoomPosition++){
 						setPixel(renderPixels[j + i * renderWidth], ((j * xZoom) +
						xPosition + xZoomPosition), ((i * yZoom) + yPosition +
						yZoomPosition), fixed);
 					}
 				}
 			}
 		}
	}

	public Rectangle getCamera(){
		return camera;
	}

	public void clear(){
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}

	private void setPixel(int pixel, int x, int y, boolean fixed){
		int pixelIndex = 0;

		if (!fixed){
			if (x >= camera.x && y >= camera.y && x <= camera.x + camera.w && y <=
			camera.y + camera.h){
				pixelIndex = (x - camera.x) + (y - camera.y) * view.getWidth();
			}
		} else{
			if (x >= 0 && y >= 0 && x <= camera.w && y <= camera.h){
				pixelIndex = x + y * view.getWidth();
			}
		}

		if (pixels.length > pixelIndex && pixel != Game.alpha){
			pixels[pixelIndex] = pixel;
		}
	}

}
