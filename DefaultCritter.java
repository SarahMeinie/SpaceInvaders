public class DefaultCritter implements critter {
	private double x;
	private double y;
	private double vx;
	private double vy;
	private int radius;
	private int health;
	private double dx;
	private double theta;
	private double deg;
	private double min_x;
	private double max_x;
	private double min_angle;
	private double max_angle;
	
  public void setPosition(int x, int y){
	  this.x = x;
	  this.y = y
  }
 
  //do we need getters?

  public void setVelocity(int vx, int vy){
	  this.vx = vx;
	  this.vy = vy;
  }
  
  public double get_theta(){
	  return theta;
  }
 
  public double get_x(){
	  return x;
  }
  
  public void set_theta(double theta){
	  this.theta = theta;
	  if (theta < min_angle){
		  this.theta = min_angle;
	  }
	  if (theta > max_angle){
		  this.theta = max_angle;
	  }
  	}
 
  }
  
