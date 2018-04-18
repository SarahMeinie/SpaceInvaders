public class Missile extends DefaultCritter{

  public Missile(Shooter protagonist){ //the missile has the same initial direction and position as the shooter
    super(protagonist.dx, 0.5 ,protagonist.get_x(), protagonist.get_y(), protagonist.get_theta());
  }
  
  public void touching_wall(){ //if the bullet touches the wall, invert the velocity
    dx = -dx;
    dy = -dy;
  }
  
  public void move(){
    y = y + dy;
    x = x + dx;
    draw();
  }
  
  public void draw(){
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(x, y, 0.01);
  }
  
}