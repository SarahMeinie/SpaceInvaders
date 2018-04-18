public class Missile extends DefaultCritter{
  
  public Missile(Shooter protagonist){ //the missile has the same initial direction and position as the shooter
    super(0.5*Math.sin(Math.toRadians(protagonist.get_theta())), 0.5*Math.cos(Math.toRadians(protagonist.get_theta())) ,protagonist.get_x()+0.03, protagonist.get_y(), protagonist.get_theta());
  }
  
  public void move(){
    y += dy;
    x += dx;
    draw();
  }
  
  public void touching_wall(){ //if the bullet touches the wall, invert the velocity
    dx = -dx;
    dy = -dy;
  }
  
  public void draw(){
    //move();
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(x, y, 0.01);
  }
  
}