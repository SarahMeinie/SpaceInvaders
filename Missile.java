public class Missile extends DefaultCritter{

  public Missile(double vx, double vy, double x, double y,double theta){ //the missile has the same initial direction and position as the shooter
    super(vx, vy ,x, y, theta);
  }
  
  public void touching_wall(){ //if the bullet touches the wall, invert the velocity
    vx = -vx;
    vy = -vy;
  }
  
  public void move(){
    y = y + vy;
    x = x + vx;
    draw();
  }
  
  
  public void draw(){
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(x, y, 0.01);
  }
  
}