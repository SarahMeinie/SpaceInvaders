public class Balls {
  private double rx, ry;
  private double vx, vy;
  private double radius;
  
  //Initial values
//    rx = 0.05;
//    ry = 0.95;
//    vx = 0.1;
//    vy = 0.1;
//    radius = 0.04;
  public Balls(double x, double y, double dx, double dy, double rad) {
    rx = x;
    ry = y;
    vx = dx;
    vy = dy;
    radius = rad;
  }
  
  public void move() {
    if ((rx + vx > 1.0) || (rx + vx < 0.0)) {
      vx = -vx;
      ry = ry - vy;
      
    }else{
    //if ((ry + vy > 1.0) || (ry + vy < 0.0)) vy = -vy;
    rx = rx + vx;
    }
  }
  public boolean check() {
    if(ry<0)return true;
    else return false;
  }
  public void draw() {
    StdDraw.filledCircle(rx, ry, radius);
  }
  
  // Test-Client
  public static void main(String[] args) {
    StdDraw.setXscale(0.0, 1.0);
    StdDraw.setYscale(0.0, 1.0);
    StdDraw.setPenColor();
    
//    Balls ball = new Balls(0.05, 0.95, 0.1, 0.1, 0.04);
//    while(true) {
//      StdDraw.clear();
//      ball.move();
//      if(ball.check()) break;
//      ball.draw();
//      StdDraw.show(150);
//    }
    int N = 5;
    Balls[] ball = new Balls[N];
    for(int i=0; i<N; i++) {
      ball[i] = new Balls(0.05+(0.1*i), 0.95, 0.1, 0.1, 0.04);
    }
    boolean temp = true;
    while(temp) {
      StdDraw.clear();
      for(int i=0; i<N; i++) {
        ball[i].move();
        if(ball[i].check()) {
          temp = false;
          break;
        }
        ball[i].draw();
      }
      StdDraw.show(150);
    }
  }
  
}