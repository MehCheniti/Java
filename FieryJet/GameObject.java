public interface GameObject{

  // Called every physically possible time.
  public void render(RenderHandler renderer, int xZoom, int yZoom);

  // Called at a 60 FPS rate.
  public void update(Game game);

}
