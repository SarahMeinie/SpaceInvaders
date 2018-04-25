public class Lives extends DefaultCritter{
  public Lives(double x){
    super(0, 0, x, 0.95, 0);
  }
  
  public void draw(){
    StdDraw.picture(x, 0.95, "heart.png", 0.045, 0.045);
  }
  
}
