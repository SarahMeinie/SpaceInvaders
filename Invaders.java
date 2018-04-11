/*
 * MAIN CLASS
 * 
 */

public class Invaders{
   public static void main(String[] args) {
      Shooter player = new Shooter();
     
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
     
   }
}

  
}