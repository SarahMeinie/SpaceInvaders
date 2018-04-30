public class Enemy extends DefaultCritter{
  int temp = 0;   
  
  public Enemy(double dx, double dy, double x, double y){
    super(dx, dy, x, y, 0,0);
  }
  
  public void draw(){
    StdDraw.picture(x, y, "enemy2.png", 0.06, 0.06);
  }
  
  public void draw(int i){
    StdDraw.picture(x, y, "enemy.png", 0.06, 0.06);
  }
  
  public void move(int i){
    if(temp==0) {
      x += dx;
      if(x>0.92) {
        y -= dy;
        temp = 1;
        x -= dx;
      }else{
        
        temp = 0;
      }
    }
    
    if(temp==1) {
      x -= dx;
      if(x<0.06) {
        y -= dy;
        temp = 0;
        x += dx;
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
