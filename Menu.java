import java.lang.*;
import java.awt.Font;
import java.awt.Color;
//basic menu
public class Menu{

  public void MenuSetUp(){
    StdDraw.pause(30);
    StdDraw.picture(0.5, 0.5, "stars.jpg", 1, 1);
    StdDraw.setPenRadius(0.095);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.point(0.5, 0.5);
    StdDraw.line(0.05, 0.21, 0.95, 0.21);
    Font font = new Font("Arial", Font.BOLD, 40);
    StdDraw.setFont(font);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.textLeft(0.25, 0.8, "{Game Name}");
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.textLeft(0.05, 0.2, "Press Spacebar To Play");
    StdDraw.show();
  }
  
    
}