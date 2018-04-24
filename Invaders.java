import java.awt.Font;
public class Invaders{
  public static void main(String[] args) {
    StdDraw.setCanvasSize(700, 700);
    boolean game = false;
    int selection = 0;
    int multiplayer = 0;
    StdDraw.enableDoubleBuffering();
    
    //CREATE MENU
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
      switch(selection){
        //if c was pressed
        
        case 1:
          key_description();
          if(StdDraw.isKeyPressed(8)){
            selection = 4;
          }
          break;
          //if m was pressed
        case 2:
          multiplayer = 1;
          InvaderGameState gameplay = new InvaderGameState(multiplayer);
          break;
          //if spacebar was pressed
        case 3:
          gameplay = new InvaderGameState(multiplayer);
          if(StdDraw.isKeyPressed(32)){
            selection = 3;
          } 
          break;
        case 4:
          MenuSetUp();
          break;
      }
    }
  }
  
  
  
  public static void MenuSetUp(){  //Creates Start Up Menu
    StdDraw.pause(2);
    StdDraw.picture(0.5, 0.5, "galaxy.gif", 1, 1);
    StdDraw.setPenRadius(0.16);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.point(0.5, 0.5);
    StdDraw.line(0.05, 0.21, 0.95, 0.21);
    Font font = new Font("Gill Sans Ultra Bold", Font.BOLD, 40);
    StdDraw.setFont(font);
    StdDraw.setPenColor(StdDraw.WHITE);
    shadow_effect(0.3, 0.9, "{Game Name}");
    font = new Font("Gill Sans Ultra Bold", Font.BOLD, 35);
    StdDraw.setFont(font);
    shadow_effect(0.1, 0.75, "For Multiplayer Press (M)");
    shadow_effect(0.08, 0.21, "Press Spacebar To Play");
    shadow_effect(0.1, 0.1, "Hold (C) for controls");
    StdDraw.show();
    
  }
  public static void key_description(){ //page for key codes
    StdDraw.pause(2);
    StdDraw.picture(0.5, 0.5, "galaxy.gif", 1, 1);
    Font font = new Font("Gill Sans", Font.BOLD, 20);
    StdDraw.setFont(font);
    StdDraw.text(0.4, 0.2, "to return to menu press backspace");
    StdDraw.text(0.2, 0.6, "multiplayer keys:");
    StdDraw.text(0.2, 0.56, "player 1: move left(G)");
    StdDraw.text(0.3, 0.52, "move right(H)");
    StdDraw.text(0.3, 0.47, "rotate clockwise(F)");
    StdDraw.text(0.3, 0.42, "rotate anticlockwise(S)");
    StdDraw.text(0.3, 0.37, "shoot(W)");
    StdDraw.text(0.7, 0.56, "player 2: move left(left arrow)");
    StdDraw.text(0.7, 0.52, "move right(right arrow)");
    StdDraw.text(0.7, 0.47, "rotate clockwise(numpad 6)");
    StdDraw.text(0.7, 0.42, "rotate anticlockwise(numpad 4)");
    StdDraw.text(0.7, 0.37, "shoot(ENTER)");
    StdDraw.show();
  }
  
  public static void shadow_effect(double x, double y,String a){
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.textLeft(x, y, a);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.textLeft(x-0.005, y-0.005, a);
  }
}
