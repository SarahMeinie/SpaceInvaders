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
  int health = 5;
  int lives =3;
  int cntstrongenemies = 0;
  
  
  public InvaderGameState(int multiplayer){
    double current_time;
    double previous_time=0;
    boolean alive =true;
    
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Missile> enemies_laser = new ArrayList<Missile>();
    ArrayList<Missile> laser = new ArrayList<Missile>();
    ArrayList<Missile> laser1 = new ArrayList<Missile>();
    ArrayList<Missile> laser2 = new ArrayList<Missile>();
    
    ArrayList<Lives> lives_list = new ArrayList<Lives>();
    ArrayList<health> health_list = new ArrayList<health>();
    StdDraw.enableDoubleBuffering();
    
    
    while (!StdDraw.isKeyPressed(27)){ //run the entire game loop only when escape or q arent pressed
      
      
      Shooter player = new Shooter(0.01, 0, 0.5, 0.1, 0); //initial values for the shooter
      Shooter player1 = new Shooter(0.01, 0, 0.1, 0.1, 0); //initial values for shooter1
      Shooter player2 = new Shooter(0.01, 0, 0.8, 0.1, 0); //initial values for shooter2 
      
      
      double enemy_XVelocity = 0.03;
      double enemy_YVelocity = 0.05;
      boolean strong = true;

      
      if(strong) { 
        // Stronger enemies
        int sizeenemies = enemies.size();
        int strength = 3;
        
        for(int i=0; i<sizeenemies/3; i++) {
          enemies.remove(i);
        }
        for(int i=0; i<strength; i++) {
          for (double j = 0; j < 0.2; j += 0.07) {
            //0.02 is the initial x value and 0.98 is the initial y value
            Enemy enemy = new Enemy(enemy_XVelocity, enemy_YVelocity, 0.1 + j, 0.98); 
            enemies.add(enemy);
            cntstrongenemies ++;
          }
        }
      }
      //creates grid of normal enemies
      for (double i = 0; i < 0.15; i += 0.12) {
        for (double j = 0; j < 0.2; j += 0.07) {
          //0.1 is the initial x value and 0.88 is the initial y value
          Enemy enemy = new Enemy(enemy_XVelocity, enemy_YVelocity, 0.1 + j, 0.88 - i); 
          enemies.add(enemy);
        }
      }
      
      //creates lives at the corner of the screen
      for(double a = 0.15; a>0; a-=0.05){
        Lives life = new Lives(0.15+a);
        lives_list.add(life);
      }
      
      //creates health at the corner of the screen
      for(double a = 0.15; a>0; a-=0.05){
        health health = new health(0.01+a);
        health_list.add(health);
      }
      
      
      while(alive){ 
        
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.pause(10);
        current_time = System.currentTimeMillis();
        
        
        if(StdDraw.isKeyPressed(100)){      //rotate left if NUMPAD4 is pressed 
          if (multiplayer == 1){           
            player2.rotate_anti();
          }                          //controls for player 1
        }
        
        
        if(StdDraw.isKeyPressed(65)){      //rotate left if A is pressed 
          if (multiplayer == 0){           
            player.rotate_anti();
          }else{                          //controls for player 2
            player1.rotate_anti();
          }
        }
        
        if (StdDraw.isKeyPressed(37)){      // move left if left arrow key is pressed
          if(multiplayer==0){
            player.move_left();              //also controls for player 2
          }else{
            player2.move_left();
          }
        }
        if (StdDraw.isKeyPressed(71)){      // move left if left arrow key is pressed
          if(multiplayer==1){
            player1.move_left();              //also controls for player 1
          }
        }
        
        if(StdDraw.isKeyPressed(68)){       //rotate right if D is pressed 
          if(multiplayer==0){
            player.rotate_clock();               //also controls for player 1
          }else{
            player1.rotate_clock(); 
          }
        }
        if(StdDraw.isKeyPressed(102)){       //rotate right if numpad 6 is pressed 
          if(multiplayer==1){
            player2.rotate_clock();               //also controls for player 2
          }
        }
        
        if (StdDraw.isKeyPressed(39)){       // move right if right arrow key is pressed
          if(multiplayer==0){
            player.move_right();              //also controls for player 2
          }else{
            player2.move_right();
          }
        } 
        
        if (StdDraw.isKeyPressed(72)){       // move right if right H key is pressed
          if(multiplayer==1){
            player1.move_right();              //also controls for player 1
          }
        } 
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_W) && current_time-previous_time>=350){      //release missile if w is pressed  ALSO FOR PLAYER 1
          previous_time = System.currentTimeMillis(); //this ensures that a missile can only be released every 0.35 seconds
          if (multiplayer==0){
            Missile bullet = new Missile(0.01*Math.cos(Math.toRadians(player.theta+90)), 0.01*Math.sin(Math.toRadians(player.theta+90)), player.x, 0.1,player.theta);  //gives missile the same initial x and y value as shooter
            laser.add(bullet); 
            StdAudio.play("laser.wav");
          }
          else{
            Missile bullet1 = new Missile(0.01*Math.cos(Math.toRadians(player1.theta+90)), 0.01*Math.sin(Math.toRadians(player1.theta+90)), player1.x, 0.1,player1.theta);  //gives missile the same initial x and y value as shooter
            laser1.add(bullet1); 
            StdAudio.play("laser.wav");
          }
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && current_time-previous_time>=350){      //release missile if w is pressed  ALSO FOR PLAYER 2
          previous_time = System.currentTimeMillis(); //this ensures that a missile can only be released every 0.35 seconds
          if (multiplayer==1){
            Missile bullet2 = new Missile(0.01*Math.cos(Math.toRadians(player2.theta+90)), 0.01*Math.sin(Math.toRadians(player2.theta+90)), player2.x, 0.1,player2.theta);  //gives missile the same initial x and y value as shooter
            laser2.add(bullet2); 
            StdAudio.play("laser.wav");
          }
        }
        
        if (StdDraw.isKeyPressed(27)){      // close window if escape is pressed
          System.exit(0); 
        }
        
        StdOut.printf("enemies %d %n",enemies.size());
        StdOut.printf("cntstrongenemies %d %n",cntstrongenemies);
        
        //constantly update movement of enemies
       move_enemies(enemies); 
        
        // do collision checking
        for (int i = 0; i < enemies.size(); i++) {       
          
          boolean collision = false;
          Enemy enemy1 = enemies.get(i);
          
          if(i>=cntstrongenemies) {
            enemy1.draw();   //update enemy position and draw
          }else {
            enemy1.draw(1);
          }
          
          
          if(enemy1.y <= 0.15){ //if the enemy touches the shooter, the player loses
            StdDraw.pause(500); 
            //play a sad sound
            
            
            if(lives_list.size()>0){ 
              //remove all missiles
              laser.clear();
              
              //redraw the missiles and enemies
              if( multiplayer==0){
                player = new Shooter(0.01, 0, 0.5, 0.1, 0);
              }
              else{
                player1 = new Shooter(0.01, 0, 0.1, 0.1, 0); //initial values for shooter1
                player2 = new Shooter(0.01, 0, 0.8, 0.1, 0); //initial values for shooter2
              }
              
              for (int m = 0; m < enemies.size(); m ++) {//creates 7x3 grid of enemies
                Enemy current_enemy = enemies.get(m);
                current_enemy.y = current_enemy.y + 0.9;
              }
              lives_list.remove(0); //the player loses a life
              
            }else{
              StdAudio.play("gameoversound.wav");
              win = false;   //if an enemy gets to the end of the screen the game is over and the player has lost
              alive = false; 
            }
          }
          
          
          if(multiplayer==0){
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
          }
          else{
            //check player 1 collision
            for (int k = 0; k < laser1.size(); k++) { //check  the position of the missiles and compare it to the position of enemies to see if any have collided
              Missile missile1 = laser1.get(k);
              if(collision(missile1, enemy1)) { 
                score += 1;
                enemies.remove(i);
                laser1.remove(k);
                StdAudio.play("explosion.wav");
                System.out.println(score);
                break;
              }
            }
            //check player 2 collision
            for (int k = 0; k < laser2.size(); k++) { //check  the position of the missiles and compare it to the position of enemies to see if any have collided
              Missile missile1 = laser2.get(k);
              if(collision(missile1, enemy1)) { 
                score += 1;
                enemies.remove(i);
                laser2.remove(k);
                StdAudio.play("explosion.wav");
                System.out.println(score);
                break;
              }
            }
          }
          if(enemies.size() == 0){
            StdDraw.pause(500); 
            //play a happy sound
            StdAudio.play("leveluptone.wav");
            win = true;
            alive = false; //if all of the enemies have been defeated the game ends and the player wins
          }
        }
        
        //lose a life if health is depleted
        if(lives_list.size()>0){
          if(health_list.size()==0){
            lives_list.remove(0);
          }
        }
        //letting random missiles be shot from enemies
        int x = (int) (Math.random() *100);
        if(x>=99 && current_time-previous_time>=100){
          int r = (int) (Math.random() *enemies.size());
          Enemy enemy_shooting = enemies.get(r);
          Missile enemy_missile = new Missile(0, -0.01, enemy_shooting.x, enemy_shooting.y,0);
          enemies_laser.add(enemy_missile); 
          
        }
        for(int a =0; a<enemies_laser.size();a++){
          Missile enemy_missile = enemies_laser.get(a);
          enemy_missile.move_enemy_missile();
          //COLIISION TESTING FOR ENEMY MISSILE AND SHOOTER
          if(collision_enemy(enemy_missile, player)){
            enemies_laser.remove(a);
            health_list.remove(0);
          }
        }
        
        
        if(multiplayer==0){ 
          for(int i = 0; i<laser.size(); i++){ //constantly update movement of missiles
            Missile missile1 = laser.get(i);
            if (missile1.y>=1 || missile1.y<=0){ //check if missile has gone to the top of the screen, remove from array if it is
              laser.remove(i);
            }
            missile1.move();
          }
        }
        else{//implement two array lists of missiles if multplayer mode is enabled
          //player1
          for(int i = 0; i<laser1.size(); i++){ //constantly update movement of missiles
            Missile missile1 = laser1.get(i);
            if (missile1.y>=1 || missile1.y<=0){ //check if missile has gone to the top of the screen, remove from array if it is
              laser1.remove(i);
            }
            missile1.move1();
          }
          //player2
          
          for(int i = 0; i<laser2.size(); i++){ //constantly update movement of missiles
            Missile missile2 = laser2.get(i);
            if (missile2.y>=1 || missile2.y<=0){ //check if missile has gone to the top of the screen, remove from array if it is
              laser2.remove(i);
            }
            missile2.move2();
          }
          
        }
        
//draw player
        if(multiplayer==0){
          player.draw_shooter();
        }
        else{
          player1.draw_shooter1();
          player2.draw_shooter2();
        }
        Font font = new Font("Gill Sans Ultra Bold", Font.BOLD, 25);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0.85, 0.95, "Score: "+score);
        
        
        //display lives
        StdDraw.text(0.1, 0.95, "Lives: ");
        for(int b = 0; b < lives_list.size(); b++){
          lives_list.get(b).draw();
        }
        
        //display health
        //StdDraw.text(0.1, 0.85, "Health: ");
        for(int b = 0; b < health_list.size(); b++){
          health_list.get(b).draw();
        }
        StdDraw.show(35);
      }
      endgame(); //draws endgame screen
    }
    
  }
  
  
  
  
  
  public boolean collision(Missile missile, Enemy en){
    //calculates the distance between the center of the enemy and the center of the missile using pyth
    double dist = Math.hypot(missile.x-en.x, missile.y-en.y); 
    if(dist<= 0.034)return true;
    else return false;
  }
  
  //enemy missile collision testing
  public boolean collision_enemy(Missile missile, Shooter shoot){
    //calculates the distance between the center of the enemy and the center of the missile using pyth
    double dist = Math.hypot(missile.x-shoot.x, missile.y-shoot.y); 
    if(dist<= 0.15)return true;
    else return false;
  }
  
  public void endgame(){
    
    
    if(!win){
      
      StdDraw.setPenColor(new Color(0,0,0, 2));
      StdDraw.filledSquare(0.5, 0.5, 0.5);
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.text(0.2, 0.2, "oh, you lost");
      HighScore(score);
      
      //display score
      HighScore(score);
      if(StdDraw.isKeyPressed(89)){
        boolean alive = true;
      }
      
    }
    else{
      //StdDraw.picture(0.5, 0.5, "over.png", 1, 1);
      StdDraw.setPenColor(new Color(0,0,0, 2));
      StdDraw.filledSquare(0.5, 0.5, 0.5);
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.text(0.2, 0.2, "wow, you won");
      HighScore(score);
      HighScore(score);
      //display score
    }
    StdDraw.show();
  }
  int temp =0;
  public void move_enemies(ArrayList<Enemy> enemies){
    for(int a = 0; a<enemies.size(); a++){
      Enemy enemy = enemies.get(a);
      if(temp==0) {
        enemy.x += enemy.vx;
        if(enemy.x>0.9) {
          for(int b = 0; b < enemies.size(); b++){
            Enemy enemy2 = enemies.get(b);
            enemy2.y -= enemy.vy;
          }
          temp = 1;
        }
        else temp = 0;
      }
      if(temp==1){
        enemy.x -= enemy.vx;        
        if(enemy.x<0.05) {
          for(int b = 0; b < enemies.size(); b++){
            Enemy enemy2 = enemies.get(b);
            enemy2.y -= enemy.vy;
          }
          temp = 0;
        }else  temp = 1;
      }
    }

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
      StdDraw.text(0.4, 0.6, "your score is "+score);
      StdDraw.text(0.4, 0.5, "the highscore is "+highscore);
    }
  }
}


