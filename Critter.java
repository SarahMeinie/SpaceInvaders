
public interface Critter {
 
 public void set_VelocityX(double velocityx);
 public void set_VelocityY(double velocityy);
 public double get_theta();
 public double get_x();
 public void set_y(double posy);
 public void set_x(double posx);
 public void set_theta(double theta);
 public void rotate_anti();
 public void rotate_clock();
 public void move_right();
 public void move_left();
}