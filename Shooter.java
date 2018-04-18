public class Shooter extends DefaultCritter{
  private double y;
  
  public Shooter(double vx, double dy, double x, double y, double theta){
    super(0.1, dy, x, y, 0);
    dx = super.dx;
    dy = super.dy;
    //x = 0.1*Math.cos(super.theta);
    //y = 0.1*Math.sin(super.theta);
    //y = super.y;
    theta = super.theta;
  }
  public double get_x(){
    return super.x;
  }
  
  public double get_y(){
    return super.y;
  }
  
  public void move_shooter(){
    super.x= super.x + super.dx;
    theta = theta + deg;
    //x = super.dx + x;
    super.y = super.dy + y;
    
    draw_shooter();
  }
  
  public void draw_shooter(){

    //StdDraw.clear(StdDraw.BLACK);
    StdDraw.picture(super.x, super.y, "shooter.png", 0.1, 0.1, super.theta);
    //StdDraw.show(20);
  }
  
}
