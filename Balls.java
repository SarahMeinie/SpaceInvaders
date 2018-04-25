public class Balls extends DefaultCritter {
  private double radius;
  
  //Initial values
//    rx = 0.05;
//    ry = 0.95;
//    vx = 0.1;
//    vy = 0.1;
//    radius = 0.04;
  public Balls(double vx, double vy, double x, double y, double radi) {
    super(vx, vy, x, y, 0);
    radius = radi;   // set Radius for Enemies
  }
  
//  public void move() {
//    if ((rx + vx > 1.0) || (rx + vx < 0.0)) {
//      vx = -vx;
//      ry = ry - vy;
//      
//    }else{
//    //if ((ry + vy > 1.0) || (ry + vy < 0.0)) vy = -vy;
//    rx = rx + vx;
//    }
//  }
  
   public void move_left(){
    this.x -= this.vx;
//    if (x < min_x){
//      x = min_x;
//    }
  }
  
  public void move_right(){
    this.x += this.vx;
//    if (x > max_x){
//      x = max_x;
//    }
  }
  public void move_up(){
      this.y -= this.vy;
//      if(y<max_y){
//        y = max_y;
//    }
  }
  public boolean check() {
    if(this.y<0)return true;
    else return false;
  }
  public void draw() {
    StdDraw.filledCircle(x, y, radius);
  }
  
  // Test-Client
  public static void main(String[] args) {
    StdDraw.setXscale(0.0, 1.0);
    StdDraw.setYscale(0.0, 1.0);
    StdDraw.setPenColor();
    int temp = 0;   // temp indicates right(0) or left(1) 
    
    
    Balls ball = new Balls(0.1, 0.1, 0.05, 0.95, 0.04);  //Balls(double dx, double dy, double x, double y, double radi)
    //Simulation
    while(true) {
      StdDraw.clear();
      if(temp==0) {
        ball.move_right();
        if(ball.x>0.95) {
            ball.move_up();
            temp = 1;
          }else temp = 0;
      }
      StdOut.printf("%.3f ", ball.x);
      if(temp==1){
        ball.move_left();        
        if(ball.x<0.05) {
            ball.move_up();
            temp = 0;
          }else  temp = 1;
      }
      StdOut.printf("%.3f ", ball.x);
      if(ball.check()) break;
      ball.draw();
      StdDraw.show(250);
    }
//    int N = 5;
//    Balls[] ball = new Balls[N];
//    for(int i=0; i<N; i++) {
//      ball[i] = new Balls(0.1, 0.1, 0.05+(0.1*i), 0.95, 0.04);
//    }
//    boolean temp = true;
//    while(temp) {
//      StdDraw.clear();
//      for(int i=0; i<N; i++) {
//        ball[i].move();
//        if(ball[i].check()) {
//          temp = false;
//          break;
//        }
//        ball[i].draw();
//      }
//      StdDraw.show(150);
//    }
  }
  
}