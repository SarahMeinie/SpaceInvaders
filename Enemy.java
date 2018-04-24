public class Enemy extends DefaultCritter{
  int temp = 0;   
  
  public Enemy(double vx, double vy, double x, double y){
    super(vx, vy, x, y, 0);
  }
  
  public void draw(){
    StdDraw.picture(x, y, "alien.png", 0.1, 0.1);
  }
  public void draw(int i){
	    StdDraw.picture(x, y, "alien2.png", 0.1, 0.1);
	  }
  
  public void move(int i){
    if(temp==0) {
      x += vx;
      if(x>0.9) {
        y -= vy;
        temp = 1;
      }else temp = 0;
    }
    if(temp==1){
      x -= vx;        
      if(x<0.05) {
        y -= vy;
        temp = 0;
      }else  temp = 1;
    }
    if(i==0) {
    	draw();
    } else {
    	draw(i);
    }
  }
}
