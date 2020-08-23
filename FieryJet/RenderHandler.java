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
	int xZoom, int yZoom){
		int[] imagePixels = ( (DataBufferInt)
		image.getRaster().getDataBuffer()).getData();
		renderArray(imagePixels, image.getWidth(), image.getHeight(), xPosition,
		yPosition, xZoom, yZoom);
	}

	public void renderSprite(Sprite sprite, int xPosition, int yPosition,
	int xZoom, int yZoom){
		renderArray(sprite.getPixels(), sprite.getWidth(), sprite.getHeight(),
		xPosition, yPosition, xZoom, yZoom);
	}

	public void renderRectangle(Rectangle rectangle, int xZoom, int yZoom){
		int[] rectanglePixels = rectangle.getPixels();

		if (rectanglePixels != null){
			renderArray(rectanglePixels, rectangle.w, rectangle.h, rectangle.x,
			rectangle.y, xZoom, yZoom);
		}
	}

	public void renderArray(int[] renderPixels, int renderWidth,
	int renderHeight, int xPosition, int yPosition, int xZoom, int yZoom){
		 for (int i = 0; i < renderHeight; i++){
 			for (int j = 0; j < renderWidth; j++){
 				for (int yZoomPosition = 0; yZoomPosition < yZoom; yZoomPosition++){
 					for (int xZoomPosition = 0; xZoomPosition < xZoom; xZoomPosition++){
 						setPixel(renderPixels[j + i * renderWidth], ((j * xZoom) +
						xPosition + xZoomPosition), ((i * yZoom) + yPosition +
						yZoomPosition));
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

	private void setPixel(int pixel, int x, int y){
		if (x >= camera.x && y >= camera.y && x <= camera.x + camera.w && y <=
		camera.y + camera.h){
			int pixelIndex = (x - camera.x) + (y - camera.y) * view.getWidth();
			if (pixels.length > pixelIndex && pixel != Game.alpha){
				pixels[pixelIndex] = pixel;
			}
		}
	}

}
