
public interface Critter {
 
 public void setPosition(double x, double y);
 public void setVelocity(double vx, double vy);
 public double get_VelocityY();
 public double get_VelocityX();
 public double get_theta();
 public double get_x();
 public void set_theta(double theta);
 public void rotate_anti();
 public void rotate_clock();
 public void move_right();
 public void move_left();
}