import java.lang.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;


/*
 * Dealing with updates 
 * */

public class InvaderGameState{
  public InvaderGameState(){
    boolean alive =true;
    Shooter player = new Shooter();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Missile> laser = new ArrayList<Missile>();


    //Go to game when Spacebar is pressed
    while(!StdDraw.isKeyPressed(32)){  
      MenuSetUp();
    } //Is there a better way to implement this?
    
    StdDraw.clear(StdDraw.BLACK);
  
    while(alive){ 
      //rotate left if S is pressed 
      if(StdDraw.isKeyPressed(70)){
        player.rotate_anti();
      }
      
      // move left if left arrow key is pressed
      if (StdDraw.isKeyPressed(37)){
        player.move_left();  
      }
      
      //rotate right if F is pressed 
      if(StdDraw.isKeyPressed(83)){
        player.rotate_clock(); 
      }
      
      // move right if right arrow key is pressed
      if (StdDraw.isKeyPressed(39)){
        player.move_right();
      } 
      
      //***NOT WORKING***
      //release missile if w is pressed 
      if (StdDraw.isKeyPressed(87)){
        Missile bullet = new Missile(player.get_x(), player.get_y()); //gives missile the same initial x and y value as shooter
        bullet.move_up();
       // bullet.draw_missile();    
      }
      
      
StdDraw.picture(player.get_x(), player.get_y(), "shooter.png", 0.1, 0.1, player.get_theta());
StdDraw.show(20);
StdDraw.clear(StdDraw.BLACK);

    //for (String s : nums){
    //System.out.println(s);
    //  }
    }
  }
  
  //Creates Start Up Menu
    public void MenuSetUp(){
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