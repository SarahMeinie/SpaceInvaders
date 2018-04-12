public class DefaultCritter implements Critter {
  
  private double x   = 0.5;
  private double y   = 0.1;
  private double dx  = 0.01;
  private double dy  = 0.5;
  private double theta = 0;
  private double deg = 5;
  private double min_angle=-90;
  private double max_angle=90;
  private double min_x=0.05;
  private double max_x=0.95;
  private double max_y=0.05;
  private double vx;
  private double vy;
  private int radius;
  private int health;
  
  
  public void set_VelocityX(double velocityx){
    vx = velocityx;}
  
  public void set_VelocityY(double velocityy){
    vy = velocityy;}
  
  
  public double get_theta(){
    return theta;}
  
  public void set_x(double posx){
    x = posx;}
  
  public void set_y(double posy){
    y = posy;}
  public double get_x(){
    return x;}
  
  public double get_y(){
    return y;}
  
  
  public void set_theta(double theta){
    this.theta = theta;
    if (theta < min_angle){
      this.theta = min_angle;
    }
    if (theta > max_angle){
      this.theta = max_angle;
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
  public void move_up(){
    while(y>max_y){
      y -= dy;
      if(y<max_y){
        y = max_y;
      }
    }
  }
}


