public class Missile extends DefaultCritter{
   private double h=0.1;
 private double w=0.1;
 private double x; 
 private double y;
 
 public Missile(double xx, double yy){
   this.x = xx;
   this.y = yy;
 }
 
  public void draw(){
      //this.x = x;
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.picture(x, y, "bullet.png", w, h, get_theta());
      StdDraw.show(20);
  }
}