public class DefaultCritter implements Critter {
 
 private double x   = 0.5;
 private double y   = 0.1;
 private double vx;
 private double vy;
 private int radius;
 private int health;
 private double dx  = 0.02;
 private double theta = 0;
 private double deg = 5;
 private double min_angle=-90;
 private double max_angle=90;
 private double min_x=0.05;
 private double max_x=0.95;
 
  public void setPosition(double posx, double posy){
   this.x = posx;
   this.y = posy;
  }

  public void setVelocity(double velocityx, double velocityy){
   this.vx = velocityx;
   this.vy = velocityy;
  }
  
  public double get_VelocityY(){
    return x;
  }
  public double get_VelocityX(){
    return y;
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
   
  public double get_theta(){
   return theta;
  }
  
  public void set_x(double posx){
    x = posx;
  }
  public double get_x(){
   return x;
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
}
  
