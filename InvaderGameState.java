import java.lang.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class InvaderGameState{
  boolean win =true;
  boolean a = false;
  int score;
  public InvaderGameState(){
    
    double current_time;
    double previous_time=0;
    boolean alive =true;
    boolean playing = false;
    Shooter player = new Shooter(0.01, 0, 0.5, 0.1, 0,0); //initial values for the shooter
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Missile> laser = new ArrayList<Missile>();
    StdDraw.enableDoubleBuffering();
    
    
    while (!StdDraw.isKeyPressed(27)){ //run the entire game loop only when escape or q arent pressed
      if(!playing){
        StdDraw.pause(2);
        MenuSetUp();
        StdDraw.show();
        if(StdDraw.isKeyPressed(32)){      //Go to game when Spacebar is pressed
          playing =true;
        } 
      }
      
      if(playing){ 
        
        double enemy_XVelocity = 0.1;
        double enemy_YVelocity = 0.03;
        
        for (double i = 0; i < 0.17; i += 0.06) {//creates 7x3 grid of enemies
          for (double j = 0; j < 0.4; j += 0.06) {
            //0.02 is the initial x value and 0.98 is the initial y value
            Enemy enemy = new Enemy(enemy_XVelocity, enemy_YVelocity, 0.02 + j, 0.98 - i); 
            enemies.add(enemy);
          }
        }
        
        //for some reason the enemies get closer to each other as they go down the screen
        
        while(alive){ 
          
          StdDraw.clear(StdDraw.BLACK);
          StdDraw.pause(10);
          current_time = System.currentTimeMillis();
          
          
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
          
          if (StdDraw.isKeyPressed(KeyEvent.VK_W) && current_time-previous_time>=350){      //release missile if w is pressed 
            previous_time = System.currentTimeMillis(); //this ensures that a missile can only be released every 0.35 seconds
            Missile bullet = new Missile(0.008*Math.cos(Math.toRadians(player.theta+90)), 0.008*Math.sin(Math.toRadians(player.theta+90)), player.x, 0.1,player.theta);  //gives missile the same initial x and y value as shooter
            laser.add(bullet); 
            StdAudio.play("laser.wav");
          }
          
          
          if (StdDraw.isKeyPressed(27)){      // close window if escape is pressed
            System.exit(0); 
          }
          
          for (int i = 0; i < enemies.size(); i++) {//constantly update movement of enemies and do collision checking
            //for (Enemy enemies : enemies) {         
            
            boolean collision = false;
            Enemy enemy1 = enemies.get(i);
            enemy1.move();//update enemy position and draw
            if(enemy1.y <= 0.02){
              StdDraw.pause(500); 
              //play a happy sound
              win = false;   //if an enemy gets to the end of the screen the game is over and the player has lost
              alive = false; 
              
            }
            
            
            for (int k = 0; k < laser.size(); k++) { //check  the position of the missiles and compare it to the position of enemies to see if any have collided
              Missile missile1 = laser.get(k);
              if(collision(missile1, enemy1)) { 
                score += 1;
                enemies.remove(i);
                laser.remove(k);
                StdAudio.play("explosion.wav");
                System.out.println(score);
                break;
                
              }
              
            }
            if(enemies.size() == 0){
              StdDraw.pause(500); 
              //play a sad sound
              win = true;
              alive = false; //if all of the enemies have been defeated the game ends and the player wins
            }
          }
          
          
          for(int i = 0; i<laser.size(); i++){ //constantly update movement of missiles
            Missile missile1 = laser.get(i);
            if (missile1.y>=1 || missile1.y<=0){ //check if missile has gone to the top of the screen, remove from array if it is
              laser.remove(i);
            }
            missile1.move();
          }
          
          //add something to display score at the corner of the screen
          player.draw_shooter();
          Font font = new Font("Gill Sans Ultra Bold", Font.BOLD, 25);
          StdDraw.setFont(font);
          StdDraw.setPenColor(StdDraw.WHITE);
          StdDraw.text(0.85, 0.95, "Score: "+score);
          StdDraw.show(35);
          
        }
        //draw end game screen
        endgame();
      }

    }
    System.exit(0); 
  }
  
  public void MenuSetUp(){  //Creates Start Up Menu
    StdDraw.clear(StdDraw.BLACK);
    StdDraw.setPenRadius(0.095);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.point(0.5, 0.5);
    StdDraw.line(0.05, 0.21, 0.95, 0.21);
    Font font = new Font("Gill Sans Ultra Bold", Font.BOLD, 40);
    StdDraw.setFont(font);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.textLeft(0.3, 0.8, "{Game Name}");
    shadow_effect(0.08, 0.2, "Press Spacebar To Play");
    StdDraw.show();
  }
  
  public boolean collision(Missile missile, Enemy en){
    //calculates the distance between the center of the enemy and the center of the missile using pyth
    double dist = Math.hypot(missile.x-en.x, missile.y-en.y); 
    if(dist<= 0.034)return true;
    else return false;
  }
  
  
  public void endgame(){
    StdDraw.clear();
    StdDraw.setPenColor(StdDraw.RED);
    if(!win){
      StdDraw.text(0.2, 0.2, "shame");

      //display score
      HighScore(score);
      if(StdDraw.isKeyPressed(89)){
        boolean alive = true;
      }
      
    }
    else{
      StdDraw.text(0.2, 0.2, "wow");
      //StdDraw.text(0.2, 0.5, "your score was "+score);
      HighScore(score);
      //display score
    }
    StdDraw.show();
  }
  
  public void shadow_effect(double x, double y,String a){
    StdDraw.setPenColor(StdDraw.YELLOW);
    StdDraw.textLeft(x, y, a);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.textLeft(x-0.005, y-0.005, a);
  }
  
  public void HighScore(int points){
    int highscore = 0; //before reading the txt file, the highscore is 0
    
    //check the highest score
    try {
      BufferedReader reader = new BufferedReader(new FileReader("High Scores.txt"));
      String line = reader.readLine();
      while (line != null)                 //read the txt file one line at a time
      {
        try {
          int score = Integer.parseInt(line.trim());   // convert the input string to an integer
          if (score > highscore)                       // compare the current 'score' to the highscore
          { 
            highscore = score; 
          }
        } catch (NumberFormatException e1) {}
        line = reader.readLine();
      }
      reader.close(); //close the txt file
      
    } catch (IOException ex) {
      System.err.println("ERROR reading scores from file");
    }
    
    // append the score to the txt file
    try {
      BufferedWriter output = new BufferedWriter(new FileWriter("High Scores.txt", true));
      output.newLine();
      output.append("" + points);
      output.close();
      
    } catch (IOException ex1) {
      System.out.printf("ERROR writing score to file: %s\n", ex1);
    }
    if (points > highscore)
    {  
      StdDraw.text(0.5, 0.6, "You made a New High Score! "+score);
    }else{
      StdDraw.text(0.5, 0.6, "Your Score was: "+score);
      StdDraw.text(0.5, 0.5, "The high score is "+highscore);
    }
  }
}


