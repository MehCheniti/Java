public interface GameObject{

  // Called every physically possible time.
  public void render(RenderHandler renderer, int xZoom, int yZoom);

  // Called at a 60 FPS rate.
  public void update(Game game);

  // Called whenever the mouse is clicked on the canvas.
  // Returns true to stop checking clicks.
  public boolean handleMouseClick(Rectangle mouseRectangle, Rectangle camera,
  int xZoom, int yZoom);

}
