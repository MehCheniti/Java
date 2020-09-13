public abstract class GUIButton implements GameObject{

protected Sprite sprite;
protected Rectangle rect;
protected boolean fixed;

  public GUIButton(Sprite sprite, Rectangle rect, Boolean fixed){
    this.sprite = sprite;
    this.rect = rect;
    this.fixed = fixed;
  }

  // Called every physically possible time.
  public void render(RenderHandler renderer, int xZoom, int yZoom) {}

  public void render(RenderHandler renderer, int xZoom, int yZoom,
  Rectangle interfaceRect){
    renderer.renderSprite(sprite, rect.x + interfaceRect.x, rect.y +
    interfaceRect.y, xZoom, yZoom, fixed);
  }

  // Called at a 60 FPS rate.
  public void update(Game game) {}

  // Called whenever the mouse is clicked on the canvas.
  public boolean handleMouseClick(Rectangle mouseRectangle, Rectangle camera,
  int xZoom, int yZoom){
    if (mouseRectangle.intersects(rect)){
      activate();
      return true;
    }

    return false;
  }

  public abstract void activate();

}
