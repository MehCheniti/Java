public class Rectangle{

public int x, y, w, h;
private int[] pixels;

  Rectangle(int x, int y, int w, int h){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  Rectangle(){
    this(0, 0, 0, 0);
  }

  public void generateGraphics(int color){
    pixels = new int[w * h];

    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        pixels[j + i * w] = color;
      }
    }
  }

  public boolean intersects(Rectangle otherRectangle){
    if (x > otherRectangle.x + otherRectangle.w || otherRectangle.x > x + w){
      return false;
    }

    if (y > otherRectangle.y + otherRectangle.h || otherRectangle.y > y + h){
      return false;
    }

    return true;
  }

  public void generateGraphics(int borderWidth, int color){
    pixels = new int[w * h];

    for (int i = 0; i < pixels.length; i++){
      pixels[i] = Game.alpha;
    }

    // Top part.
    for (int i = 0; i < borderWidth; i++){
      for (int j = 0; j < w; j++){
        pixels[j + i * w] = color;
      }
    }

    // Left part.
    for (int i = 0; i < h; i++){
      for (int j = 0; j < borderWidth; j++){
        pixels[j + i * w] = color;
      }
    }

    // Right part.
    for (int i = 0; i < h; i++){
      for (int j = w - borderWidth; j < w; j++){
        pixels[j + i * w] = color;
      }
    }

    // Bottom part.
    for (int i = h - borderWidth; i < h; i++){
      for (int j = 0; j < w; j++){
        pixels[j + i * w] = color;
      }
    }
  }

  public int[] getPixels(){
    if (pixels != null){
      return pixels;
    } else{
      System.out.println("Attempted to retrieve pixels from a Rectangle " +
      "without generated graphics.");
    }

    return null;
  }

  public String toString(){
    return "[" + x + ", " + y + ", " + w + ", " + h + "]";
  }

}
