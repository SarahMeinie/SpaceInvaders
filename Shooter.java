public class Shooter extends DefaultCritter{
  private double angle = 0;
  
  public Shooter(double vx, double dy, double x, double y, double theta){
    super(0.01, 0, 0.5, 0.1, 0);
  }

  public void move_shooter(){
    x = x + dx;
    angle = angle + theta;

    draw_shooter();
  }
  
  public void draw_shooter(){
    StdDraw.picture(x, 0.1, "shooter.png", 0.1, 0.1, angle);
  } 
}
