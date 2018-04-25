public class health extends DefaultCritter{
  public health(double x){
    super(0, 0, x, 0.85, 0);
  }
  
  public void draw(){
    StdDraw.picture(x, 0.85, "health.png", 0.045, 0.045);
  }
  
}