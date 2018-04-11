public class Shooter extends DefaultCritter{
 private double y   = 0.1;
 private double h=0.1;
 private double w=0.1;
 
  public void draw_shooter(){
      //this.x = x;
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.picture(get_x(), y, "shooter.png", w, h, get_theta());
      StdDraw.show(20);
  }

}
