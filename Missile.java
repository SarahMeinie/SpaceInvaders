public class Missile extends DefaultCritter{
  private double x; 
  private double y;
  
  public Missile(Shooter protagonist){ //the missile has the same initial direction and position as the shooter
    super(protagonist.dx, protagonist.dy ,protagonist.get_x(), protagonist.get_y(), protagonist.get_theta());
  }
  
  public double get_x(){
    return super.x;
  }
  
  public double get_y(){
    return super.y;
  }
  
  public void touching_wall(){ //if the bullet touches the wall, invert the velocity
    super.dx = - super.dx;
    super.dy = - super.dy;
  }
  
  public void move(){
    super.y = super.y + super.dy;
    super.x = super.x + super.dx;
    draw();
  }
  
  public void draw(){
    //this.x = x;
    //StdDraw.clear(StdDraw.BLACK);
    
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(super.x-0.01, super.y, 0.01);
  }
  
}