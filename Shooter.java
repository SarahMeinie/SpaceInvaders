public class Shooter extends DefaultCritter{
  private double dx = 0.1;
  private double dy = 0.1;
  public Shooter(double vx, double dy, double x, double y, double theta){
    super(0.1, dy, x, y, 0);
  }
  
  public void move_shooter(){
    x = x + dx;
    y = y +dy;
    theta = theta + deg;
    draw_shooter();
  }
  public void move_shooter1(){
    x = x + dx;
    y = y +dy;
    theta = theta + deg;
    draw_shooter1();
  }
  public void move_shooter2(){
    x = x + dx;
    y = y +dy;
    theta = theta + deg;
    draw_shooter2();
  }
  
  
  public void draw_shooter(){
    StdDraw.picture(x, y, "shooter.png", 0.1, 0.1, theta);
  }
  public void draw_shooter1(){
    StdDraw.picture(x, y, "shooter11png.png", 0.12, 0.12, theta);
  }
  public void draw_shooter2(){
    StdDraw.picture(x, y, "shooter33.png", 0.13, 0.13, theta);
  }
  
  
  
}
