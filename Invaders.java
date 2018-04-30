import java.awt.Font;


public class Invaders{
  public static void main(String[] args) {
    StdDraw.setCanvasSize(900, 900);
    boolean game = false;
    int selection = 0;
    int multiplayer = 0;
    StdDraw.enableDoubleBuffering();
    
    while(!game){
      MenuSetUp();
      
      if(StdDraw.isKeyPressed(67)){
        selection = 1;
        game = true;
      }
      if(StdDraw.isKeyPressed(77)){
        selection = 2;
        game = true;
      }
      if(StdDraw.isKeyPressed(32)){
        selection = 3;
        game = true;
      }
    }
    
    while(game){
      if(StdDraw.isKeyPressed(67)){
        selection = 1;
        game = true;
      }
      if(StdDraw.isKeyPressed(77)){
        selection = 2;
        game = true;
      }
      if(StdDraw.isKeyPressed(32)){
        selection = 3;
        game = true;
      }
      
      if (StdDraw.isKeyPressed(27) || StdDraw.isKeyPressed(81)){ //quit the game if escape of q are pressed
        System.exit(0); 
        game = false;
      }
      switch(selection){
        
        case 1:
          key_description();
          if(StdDraw.isKeyPressed(8)){
            selection = 4;
          }
          break;
          
        case 2:
          multiplayer = 1;
          InvaderGameState gameplay = new InvaderGameState(multiplayer);
          selection = 5;
          break;

        case 3:
          gameplay = new InvaderGameState(multiplayer);
          selection = 5;
          break;
          
        case 4:
          MenuSetUp();
          break;
          
        case 5:
          if(StdDraw.isKeyPressed(82)){ //Replay game if R is pressed
            selection = 3;
          }
          if(StdDraw.isKeyPressed(8)){ //Goes to menu if backspace is pressed
              selection = 4;
            }
      }
    }
  }
  
//Creates Start Up Menu
  public static void MenuSetUp(){  
    StdDraw.pause(2);
    StdDraw.picture(0.5, 0.5, "star.gif", 1, 1);
    StdDraw.picture(0.5, 0.5, "name.png", 1, 1);
    StdDraw.setPenRadius(0.16);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.point(0.5, 0.5);
    StdDraw.line(0.05, 0.21, 0.95, 0.21);
    Font font = new Font("Courier New", Font.BOLD, 40);
    StdDraw.setFont(font);
    StdDraw.setPenColor(StdDraw.WHITE);
    font = new Font("Courier New", Font.BOLD, 35);
    StdDraw.setFont(font);
    shadow_effect(0.5, 0.35, "For Multiplayer Press (M)");
    shadow_effect(0.5, 0.21, "Press Spacebar To Play");
    shadow_effect(0.5, 0.1, "Press (C) for controls");
    StdDraw.show();
    }
  
  public static void key_description(){ 
    StdDraw.pause(2);
    StdDraw.picture(0.5, 0.5, "star.gif", 1, 1);
    Font font = new Font("Courier New", Font.BOLD, 20);
    StdDraw.setFont(font);
    StdDraw.text(0.5, 0.2, "to return to menu press backspace");
    StdDraw.text(0.5, 0.63, "multiplayer keys:");
    StdDraw.text(0.28, 0.57, "player 1: ");
    StdDraw.text(0.25, 0.52, "move left(G)");
    StdDraw.text(0.25, 0.47, "move right(H)");
    StdDraw.text(0.25, 0.42, "rotate clockwise(F)");
    StdDraw.text(0.23, 0.37, "rotate anticlockwise(S)");
    StdDraw.text(0.25, 0.33, "shoot(W)");
    StdDraw.text(0.7, 0.57, "player 2:");
    StdDraw.text(0.7, 0.52, "move left(left arrow)");
    StdDraw.text(0.7, 0.47, "move right(right arrow)");
    StdDraw.text(0.7, 0.42, "rotate clockwise(numpad 6)");
    StdDraw.text(0.72, 0.37, "rotate anticlockwise(numpad 4)");
    StdDraw.text(0.7, 0.33, "shoot(ENTER)");
    StdDraw.text(0.5, 0.94, "singleplayer keys:");
    StdDraw.text(0.5, 0.9, "move left(left arrow)");
    StdDraw.text(0.5, 0.86, "move right(right arrow)");
    StdDraw.text(0.5, 0.82, "rotate clockwise(A)");
    StdDraw.text(0.5, 0.78, "rotate anticlockwise(D)");
    StdDraw.text(0.5, 0.74, "shoot(W)");
    StdDraw.show();
  }
  
  //creates a shadow effect on text
  public static void shadow_effect(double x, double y,String a){
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.text(x, y, a);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.text(x-0.003, y-0.003, a);
  }
}
  
