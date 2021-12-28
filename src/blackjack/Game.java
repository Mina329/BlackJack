/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
/**
 *
 * 
 * @author minae
 */
public class Game {
    private int valid_highscore=-1;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    Card []deck = new Card[52];
    Player []players = new Player[4];

    public int getValid_highscore() {
        return valid_highscore;
    }

    public void setValid_highscore(int valid_highscore) {
        this.valid_highscore = valid_highscore;
    }

    
    public void generate_card_deck(){
      // A function that generates the card deck array (52 cards with different suits, ranks and values
      // as explained previously)
      int index=0;
      for(int i=0;i<4;i++){
          for(int j=0;j<13;j++){
              int value;
              if(j>9)
                  value=10;
              else
                  value=j+1;
              deck[index]=new Card(i,j,value);
              index++;
          }
      }
    }
    public Card draw_card(){
      // A function to draw a card randomly , store it in a new card object and make th drawn card equals null
      // in the deck arraylist
      Card drawn_card ;
      int randomChoice;
      while(true){
         randomChoice= rand.nextInt(52);
         if(deck[randomChoice]==null){
             continue;
         }else{
             drawn_card = deck[randomChoice];
             break;
         }
      }
      deck[randomChoice]=null;
      return drawn_card;
      
    }
    public void setPlayerinfo(){
      // A function that sets the information of the players (take names from the user and draw 2 
      // random cards for each player) at the beginning of the game.
      Player player;
      for (int i=0;i<4;i++){
          String Name;
          System.out.println("Enter Player "+(i+1)+" name :");
          Name = in.next();
          Card []cards = new Card[11];
          cards[0]= draw_card();
          cards[1]= draw_card();
          int Scoure =cards[0].getValue()+cards[1].getValue();
          players[i] = new Player(Name,Scoure,cards);
          players[i].setIndex(i);
          players[i].setBlackjack(false);
          
      }
    }
    public void UpdateMaxScore(){
      // A function to update the game maximum score of all players after any player draw a card to his hand.
      for(int i=0;i<3;i++){
          if(valid_highscore<players[i].getScore() && players[i].getScore()<=21){
              valid_highscore=players[i].getScore();
          }
      }
    }
    
}
