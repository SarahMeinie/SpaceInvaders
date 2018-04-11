public class Shooter extends DefaultCritter{
    //needs to override default functionality 
  private double dx  = 0.02;
  private double x   = 0.5;
  private double y   = 0.1;
  private double deg = 5;
  private double theta = 0;
  private double min_angle=-90;
  private double max_angle=90;
  private double min_x=0.05;
  private double max_x=0.95;
  private double h=0.1;
  private double w=0.1;
  
  
  public double get_theta(){
  return theta;
 }
 
 public double get_x(){
  return x;
 }
 

  public void draw_shooter(){
      this.x = x;
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.picture(x, y, "shooter.png", w, h, theta);
      StdDraw.show(20);
  }
  
   public void set_theta(double theta)
 {
  this.theta = theta;
  if (theta < min_angle){
   this.theta = min_angle;
  }
  if (theta > max_angle){
   this.theta = max_angle;
  }
 }

public void move_left(){
  x -= dx;
  if (x < min_x){
   x = min_x;
  }
 }

 public void move_right(){
  x += dx;
  if (x > max_x){
   x = max_x;
  }
 }

 public void rotate_anti(){
 theta = theta - deg;
  if (theta < min_angle){
   theta = min_angle;
  }
 }

 public void rotate_clock(){
   theta = theta + deg;
  if (theta > max_angle){
   theta = max_angle;
  }
 }
 
 


}