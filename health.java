public class health extends DefaultCritter{
  public health(double x){
    super(0, 0, x, 0.85, 0,0);
  }
  
  public void draw(){
    StdDraw.picture(x, 0.94, "heart.png", 0.023, 0.023);
  }
  
}