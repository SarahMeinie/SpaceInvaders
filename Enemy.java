public class Enemy extends DefaultCritter{
  int temp = 0;   
  
  public Enemy(double vx, double vy, double x, double y){
    super(vx, vy, x, y, 0,0);
  }
  
  public void draw(){
    StdDraw.picture(x, y, "enemy2.png", 0.06, 0.06);
  }
  
  public void draw(int i){
    StdDraw.picture(x, y, "enemy.png", 0.06, 0.06);
  }
  
  public void move(int i){
    if(temp==0) {
      x += vx;
      if(x>0.92) {
        y -= vy;
        temp = 1;
        x -= vx;
      }else{
        
        temp = 0;
      }
    }
    
    if(temp==1) {
      x -= vx;
      if(x<0.06) {
        y -= vy;
        temp = 0;
        x += vx;
      }else{
        
        temp = 1;
      }
    }
    
    if(i==0) {
     draw();
    } else {
     draw(i);
    }
  }
}
