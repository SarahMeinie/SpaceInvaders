import java.lang.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

/*
 * Dealing with updates 
 * */

public class InvaderGameState{
  double InitialX = 0.5;
  double InitialY = 0.1;
  double InitialTheta = 0;
  public InvaderGameState(){
    boolean alive =true;
    Shooter player = new Shooter(0.01, 0, InitialX, InitialY, InitialTheta);
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Missile> laser = new ArrayList<Missile>();
    
    
    MenuSetUp();
    
    while(!StdDraw.isKeyPressed(32)){      //Go to game when Spacebar is pressed
    } 
    
    while(alive){ 
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.enableDoubleBuffering();
      if(StdDraw.isKeyPressed(70)){      //rotate left if S is pressed 
        player.rotate_anti();
      }
      
      
      if (StdDraw.isKeyPressed(37)){      // move left if left arrow key is pressed
        player.move_left();  
      }
      
      
      if(StdDraw.isKeyPressed(83)){       //rotate right if F is pressed 
        player.rotate_clock(); 
      }
      
      
      if (StdDraw.isKeyPressed(39)){       // move right if right arrow key is pressed
        player.move_right();
      } 
      
      //***NOT WORKING***
      if (StdDraw.isKeyPressed(87)){      //release missile if w is pressed 
        Missile bullet = new Missile(player);  //gives missile the same initial x and y value as shooter
        laser.add(bullet);
        bullet.move();    
      }
      
      
      player.draw_shooter();
      StdDraw.show(20);
      //bullet.draw();
      
      //for (String s : nums){
      //System.out.println(s);
      //  }
      
      
    }
  }
  
  
  public void MenuSetUp(){  //Creates Start Up Menu
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