import java.lang.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

/*
 * Dealing with updates 
 * */

public class InvaderGameState{
  
  
  public InvaderGameState(){
    StdDraw.enableDoubleBuffering();
    double InitialX = 0.5;
    double InitialY = 0.5;
    double InitialTheta = 0;
    boolean alive =true;
    boolean playing = false;
    
    while(!StdDraw.isKeyPressed(27)){      //exit game when escape is pressed
      if(!playing){
        StdDraw.pause(2);
        MenuSetUp();
        StdDraw.show();
        if(StdDraw.isKeyPressed(32)){
          playing = true;
        }
      } 
      if (playing){
        Shooter player = new Shooter(0.01, 0, InitialX, InitialY, InitialTheta);
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        ArrayList<Missile> laser = new ArrayList<Missile>();
        
        
        while(alive){ 
          StdDraw.pause(2);
          StdDraw.clear(StdDraw.BLACK);
          if(StdDraw.isKeyPressed(70)){      //rotate left if S is pressed 
            player.rotate_anti();}
          
          if (StdDraw.isKeyPressed(37)){      // move left if left arrow key is pressed
            player.move_left();}
          
          if(StdDraw.isKeyPressed(83)){       //rotate right if F is pressed 
            player.rotate_clock();}
          
          if (StdDraw.isKeyPressed(39)){       // move right if right arrow key is pressed
            player.move_right();} 
          
          if (StdDraw.isKeyPressed(87)){      //release missile if w is pressed 
            Missile bullet = new Missile(player);  //gives missile the same initial x and y value as shooter
            laser.add(bullet);}
          
          player.move_shooter();
          
          //loop through all elements in laser list and draw all of the missiles in the list
          for(int i = 0; i<laser.size(); i++){
            Missile missile1 = laser.get(i);
            missile1.move();
            
            //check if missile has bounced off the side of the screen
            if (missile1.get_x() >= 0.95  || missile1.get_x()<=0.05){
              missile1.touching_wall();
            }
            
            //check if missile has touched an enemy
            
            //check if missile has gone to the top of the screen, remove from array if it is
            if (missile1.get_y()>=0.95 || missile1.get_y()<=0.05){
              laser.remove(i);
            }
            
            //draw the missile1
            missile1.draw();
          }
          
          
          StdDraw.show();
          
          //for (String s : nums){
          //System.out.println(s);
          //  }
        }
      }
      
    }
    System.exit(0);
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