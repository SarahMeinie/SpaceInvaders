public class Missile extends DefaultCritter{

  public Missile(double dx, double dy, double x, double y,double theta){ //the missile has the same initial direction and position as the shooter
    super(dx, dy ,x, y, theta,0);
  }
  


  public void move(){
    y = y + dy;
    x = x + dx;
    draw();
  }
  public void move1(){
    y = y + dy;
    x = x + dx;
    draw1();
  }
  public void move2(){
    y = y + dy;
    x = x + dx;
    draw2();
  }
    public void move_enemy_missile(){
    y = y + dy;
    draw_enemy_missile();
  }
  
  public void draw(){
    StdDraw.picture(x, y, "missile.png", 0.05, 0.03, theta);
  }
  
  public void draw1(){
StdDraw.picture(x, y, "missile1.png", 0.05, 0.03, theta);
  }
  
  public void draw2(){
StdDraw.picture(x, y, "missile2.png", 0.05, 0.03, theta);
  }
  
  public void draw_enemy_missile(){
   StdDraw.picture(x, y, "enemy_missile.png", 0.035, 0.03, theta);
  }
}