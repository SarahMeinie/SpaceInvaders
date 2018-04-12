import java.lang.*;
import java.awt.Font;
import java.awt.Color;

public class Invaders{
  public static void main(String[] args) {
    Shooter player = new Shooter();
    
    Menu StartUp = new Menu();
    
    //Creates Start Up Menu
    StartUp.MenuSetUp();
    //Go to game when Spacebar is pressed
    while(!StdDraw.isKeyPressed(32)){ 
    } //Is there a better way to implement this?
    
    StdDraw.clear(StdDraw.BLACK);
    StdDraw.picture(player.get_x(), player.get_y(), "shooter.png", 0.1, 0.1, player.get_theta()); 
    
    while(true){
      
      //rotate left if S is pressed 
      if(StdDraw.isKeyPressed(70)){
        player.rotate_anti();
        player.draw_shooter(); 
      }
      
      // move left if left arrow key is pressed
      if (StdDraw.isKeyPressed(37)){
        player.move_left();
        player.draw_shooter();      
      }
      
      //rotate right if F is pressed 
      if(StdDraw.isKeyPressed(83)){
        player.rotate_clock(); 
        player.draw_shooter();
      }
      
      // move right if right arrow key is pressed
      if (StdDraw.isKeyPressed(39)){
        player.move_right();
        player.draw_shooter();
      } 
      
      //***NOT WORKING***
      //release missile if w is pressed 
      if (StdDraw.isKeyPressed(87)){
        Missile bullet = new Missile(player.get_x(), player.get_y()); //gives missile the same initial x and y value as shooter
        bullet.move_up();
        bullet.draw_missile();    
      }
      
    }
  }
  
  
}
