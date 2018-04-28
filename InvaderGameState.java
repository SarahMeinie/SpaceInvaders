
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.io.*;


public class InvaderGameState{
  boolean win =true;
  public InvaderGameState(int multiplayer){
    
    double current_time;
    double previous_time=0;
    int cntstrongenemies = 0;
    int score =0;
    
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Missile> enemies_laser = new ArrayList<Missile>();
    ArrayList<Missile> laser = new ArrayList<Missile>();
    ArrayList<Missile> laser1 = new ArrayList<Missile>();
    ArrayList<Missile> laser2 = new ArrayList<Missile>();
    
    ArrayList<Lives> lives_list = new ArrayList<Lives>();
    ArrayList<health> health_list = new ArrayList<health>();
    StdDraw.enableDoubleBuffering();
    
    Shooter player = new Shooter(0.01, 0, 0.5, 0.05, 0,0); //initial values for the shooter
    Shooter player1 = new Shooter(0.01, 0, 0.1, 0.05, 0,0); //initial values for shooter1
    Shooter player2 = new Shooter(0.01, 0, 0.8, 0.05, 0,0); //initial values for shooter2 
    
    
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
        for (double j = 0; j < 0.3; j += 0.06) {
          //0.02 is the initial x value and 0.98 is the initial y value
          Enemy enemy = new Enemy(enemy_XVelocity, enemy_YVelocity, 0.1 + j, 0.98); 
          enemies.add(i, enemy);
          cntstrongenemies ++;
        }
      }
    }
    //creates grid of normal enemies
    for (double i = 0; i < 0.15; i += 0.06) {
      for (double j = 0; j < 0.3; j += 0.06) {
        //0.1 is the initial x value and 0.88 is the initial y value
        Enemy enemy = new Enemy(enemy_XVelocity, enemy_YVelocity, 0.1 + j, 0.92 - i); 
        enemies.add(enemy);
      }
    }
    
    //creates lives at the corner of the screen
    for(double a = 0.15; a>0; a-=0.05){
      Lives life = new Lives(0.15+a);
      lives_list.add(life);
    }
    
    //creates health at the corner of the screen
    for(double a = 0.09; a>0; a-=0.03){
      health health = new health(0.14+a);
      health_list.add(health);
    }
     
     
    boolean alive=true;
    while(alive){ 
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.picture(0.5, 0.1, "background.png", 10, 0.5);
      
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
      
      if (StdDraw.isKeyPressed(27)|| StdDraw.isKeyPressed(81)){      // close window if escape is pressed
        System.exit(0); 
      }
      
      // do collision checking
      for (int i = 0; i < enemies.size(); i++) {       
        
        Enemy enemy1 = enemies.get(i);
        
        if(i>=cntstrongenemies) {
          //update enemy position and draw
          enemy1.move(0);
        }else {
          enemy1.move(1);
        }
        
        
        
        if(enemy1.y <= 0.15){ //if the enemy touches the shooter, the player loses
          
          if(lives_list.size()>0){ 
            //remove all missiles
            laser.clear();
            
            //redraw the missiles and enemies
            if( multiplayer==0){
              player = new Shooter(0.01, 0, 0.5, 0.1, 0,0);
            }
            else{
              player1 = new Shooter(0.01, 0, 0.1, 0.1, 0,0); //initial values for shooter1
              player2 = new Shooter(0.01, 0, 0.8, 0.1, 0,0); //initial values for shooter2
            }
            
            for (int m = 0; m < enemies.size(); m ++) {//creates 7x3 grid of enemies
              Enemy current_enemy = enemies.get(m);
              current_enemy.y = current_enemy.y + 0.9;
            }
            lives_list.remove(0); //the player loses a life
            
          }else{
            StdDraw.pause(500);
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
              break;
            }
          }
        }
        if(enemies.size() == 0){
          StdAudio.play("leveluptone.wav");
          win = true;
          alive = false; //if all of the enemies have been defeated the game ends and the player wins
        }
      }
      
      
      //lose a life if health is depleted
      if(lives_list.size() ==0){
        alive = false;
      }
      else{
        if(health_list.size()==0){
          lives_list.remove(0);
          for(double a = 0.15; a>0; a-=0.05){
            health health = new health(0.4+a);
            health_list.add(health);
          }
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
      
      StdDraw.setPenColor(new Color(255, 255, 255, 60));
      StdDraw.filledRectangle(0.5, 0.96, 0.5,0.04);
      Font font = new Font("Courier New", Font.PLAIN, 18);
      StdDraw.setFont(font);
      
      //StdDraw.picture(0, 0.12, "setup.png", 0.5, 0.5);
      
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.text(0.9, 0.98, "SCORE <"+score+">");
      
      //display lives
      StdDraw.text(0.1, 0.98, "LIVES: ");
      for(int b = 0; b < lives_list.size(); b++){
        lives_list.get(b).draw();
      }
      
      //display health
      StdDraw.text(0.1, 0.94, "HEALTH: ");
      for(int b = 0; b < health_list.size(); b++){
        health_list.get(b).draw();
      }
      StdDraw.show(35);
      
    }
    HighScore(score);
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
  
  
  int temp =0;
  
  
  public void move_enemies(ArrayList<Enemy> enemies){
    
    for(int a =0; a<enemies.size(); a++){
      
      Enemy enemy1 = enemies.get(a);
      if(temp==0) {
        enemy1.x += enemy1.vx;
        if(enemy1.x>0.9) {
          for(int b =0; b<enemies.size(); b++){
            Enemy enemy2 = enemies.get(b);
            enemy2.y-=enemy2.vy;
          }
          temp = 1;
        }else temp = 0;
      }
      if(temp==1){
        enemy1.x -= enemy1.vx;       
        if(enemy1.x<0.05) {
          for(int b =0; b<enemies.size(); b++){
            Enemy enemy2 = enemies.get(b);
            enemy2.y-=enemy2.vy;
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
    if(points>highscore){
      StdDraw.pause(2);
      StdDraw.setPenColor(new Color(255, 255, 255, 20));
      StdDraw.filledSquare(0.5, 0.5, 0.5);
      StdDraw.setPenColor(StdDraw.WHITE);
      if(!win){
        StdDraw.text(0.4, 0.65, "oh, you lost");
      }
      else{
        StdDraw.text(0.4, 0.65, "shucks, looks like you won");
      }
      StdDraw.text(0.4, 0.55, "the new highscore is: "+points);
      StdDraw.text(0.4, 0.25, "to replay press R");
      StdDraw.text(0.4, 0.2, "to go back to menu press backspace");
      StdDraw.show();

      
      // append the highscore to the txt file
      try {
        BufferedWriter output = new BufferedWriter(new FileWriter("High Scores.txt", true));
        output.newLine();
        output.append("" + highscore);
        output.close();
        
      } catch (IOException ex1) {
        System.out.printf("ERROR writing score to file: %s\n", ex1);
      }
    }
    else{
      StdDraw.pause(2);
      StdDraw.setPenColor(new Color(255, 255, 255, 20));
      StdDraw.filledSquare(0.5, 0.5, 0.5);
      StdDraw.setPenColor(StdDraw.WHITE);
      if(!win){
        StdDraw.text(0.4, 0.65, "oh, you lost");
      }
      else{
        StdDraw.text(0.4, 0.65, "shucks, looks like you won");
      }
      StdDraw.text(0.4, 0.55, "your score is:"+points);
      StdDraw.text(0.4, 0.5, "the highscore is:"+highscore);
      StdDraw.text(0.4, 0.25, "to replay press R");
      StdDraw.text(0.4, 0.2, "to go back to menu press spacebar");
      StdDraw.show();
    }
    
    
    
    
  }
  public static void endgame(){
    StdDraw.pause(2);
    StdDraw.clear();
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.text(0.4, 0.25, "to replay press R");
    StdDraw.text(0.4, 0.15, "to go back to menu press spacebar");
    StdDraw.show();
  }
}



