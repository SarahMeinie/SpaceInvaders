public class Balls {
  private double rx, ry;
  private double vx, vy;
  private double radius;
  public Balls() {
    rx = 0.05;
    ry = 0.95;
    vx = 0.1;
    vy = 0.1;
    //vy = 0.015 - Math.random() * 0.03;
    radius = 0.04;
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
  public static void main(String[] args) {
    StdDraw.setXscale(0.0, 1.0);
    StdDraw.setYscale(0.0, 1.0);
    StdDraw.setPenColor();
    Balls ball = new Balls();
    while(true) {
      StdDraw.clear();
      ball.move();
      if(ball.check()) break;
      ball.draw();
      StdDraw.show(150);
    }
}
  
}