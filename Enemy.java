public class Enemy extends DefaultCritter{
  int temp = 0;   
  
  public Enemy(double vx, double vy, double x, double y){
    super(vx, vy, x, y, 0);
  }
  
  public void draw(){
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.filledCircle(x,y,0.025);
  }
  public void move(){
    if(temp==0) {
      x += vx;
      if(x>0.9) {
        y -= vy;
        temp = 1;
      }else temp = 0;
    }
    if(temp==1){
      x -= vx;        
      if(x<0.04) {
        y -= vy;
        temp = 0;
      }else  temp = 1;
    }
    draw();
  }
}
