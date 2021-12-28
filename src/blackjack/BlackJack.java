/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;
import java.util.*;
/**
 *
 * @author minae
 */
public class BlackJack {

    Scanner in = new Scanner(System.in);
    Game game =new Game();
    GUI gui = new GUI();
    public static void main(String[] args) {
        BlackJack b =new BlackJack();
        b.StartGame();
    }
    public  void StartGame(){
        game.generate_card_deck();
        game.setPlayerinfo();
        gui.runGUI(game.deck,game.players[0].cards,game.players[1].cards,game.players[2].cards,game.players[3].cards);
        Hit_Stand();
        WinnerPush();
    }
    public void Hit_Stand(){
        for(int i=0;i<4;i++){
            if(i==3){
                    while(game.players[3].getScore()<game.getValid_highscore()){
                        int index2 =2;
                        Card card = new Card(game.draw_card());
                        game.players[i].cards[index2]=card;
                        game.players[i].setScore((game.players[i].getScore()+card.getValue()));
                        gui.updateDealerHand(card, game.deck);
                         
                    }
                    if(game.players[i].getScore()>21){
                        System.out.println("Player "+(i+1)+" Score is "+game.players[i].getScore());
                        System.out.println("Player " +(i+1)+ " BUSTED");
                        game.players[i].setLost(true);
                            }
                
            }else{
                System.out.println("Player "+(i+1)+" turn");
                for(int index=2;index<11;index++){
                    System.out.println("Player "+(i+1)+" Score is "+game.players[i].getScore());
                    System.out.println("1 - Hit");
                    System.out.println("2 - Stand");
                    int choice = in.nextInt();
                    if (choice == 1){
                        Card card = new Card(game.draw_card());
                        game.players[i].cards[index]=card;
                        game.players[i].setScore((game.players[i].getScore()+card.getValue()));
                        gui.updatePlayerHand(card, i);
                        if(game.players[i].getScore()==21){
                             System.out.println("Player "+(i+1)+" Score is "+game.players[i].getScore());
                             System.out.println("Player got a BlackJack");
                             game.players[i].setBlackjack(true);
                             break;
                        }
                        if(game.players[i].getScore()>21){
                             System.out.println("Player "+(i+1)+" Score is "+game.players[i].getScore());
                             System.out.println("Player " +(i+1)+ " BUSTED");
                             game.players[i].setLost(true);
                             break;
                        }
                    }else if (choice == 2){
                        break;
                        }
                    }
                game.UpdateMaxScore();
                }
        }
    }
    public void WinnerPush (){
        int num_of_Win =0;
        int j = 0;
        Player []Winners = new Player[4];
        for(int i=0;i<4;i++){
              if(!game.players[i].isLost()){
                  Winners[j]=new Player(game.players[i]);
                  num_of_Win++;
                  j++;
            }
        }
        
        if(num_of_Win == 1){
              System.out.println("Player "+ (Winners[0].getIndex()+1)+" Wins " );
        }
        else if(num_of_Win == 2){
            if(Winners[0].getScore()>Winners[1].getScore()){
               System.out.println("Player "+ (Winners[0].getIndex()+1)+" Wins " );  
            }else if (Winners[0].getScore()<Winners[1].getScore()){
               System.out.println("Player "+ (Winners[1].getIndex()+1)+" Wins " );  
            }else if(Winners[0].getScore()==Winners[1].getScore()){
               System.out.println("It is a PUSH ");
        }
        }
        else if(num_of_Win == 3){
            if(Winners[0].getScore()>Winners[1].getScore() && Winners[0].getScore()>Winners[2].getScore()){
                 System.out.println("Player "+ (Winners[0].getIndex()+1)+" Wins " );
            }else if(Winners[1].getScore()>Winners[0].getScore() && Winners[1].getScore()>Winners[2].getScore()){
                 System.out.println("Player "+ (Winners[1].getIndex()+1)+" Wins " );
            }else if(Winners[2].getScore()>Winners[0].getScore() && Winners[2].getScore()>Winners[1].getScore()){
                 System.out.println("Player "+ (Winners[2].getIndex()+1)+" Wins " );
            }else{
                 System.out.println("It is a PUSH ");
            }
        }
        else if(num_of_Win == 4){
            if(Winners[0].getScore()>Winners[1].getScore() && Winners[0].getScore()>Winners[2].getScore() && Winners[0].getScore()>Winners[3].getScore()){
                 System.out.println("Player "+ (Winners[0].getIndex()+1)+" Wins " );
            }else if(Winners[1].getScore()>Winners[0].getScore() && Winners[1].getScore()>Winners[2].getScore() && Winners[1].getScore()>Winners[3].getScore()){
                 System.out.println("Player "+ (Winners[1].getIndex()+1)+" Wins " );
            }else if(Winners[2].getScore()>Winners[0].getScore() && Winners[2].getScore()>Winners[1].getScore() && Winners[2].getScore()>Winners[3].getScore()){
                 System.out.println("Player "+ (Winners[2].getIndex()+1)+" Wins " );
            }else if(Winners[3].getScore()>Winners[0].getScore() && Winners[3].getScore()>Winners[1].getScore() && Winners[3].getScore()>Winners[2].getScore()){
                 System.out.println("Player "+ (Winners[3].getIndex()+1)+" Wins " );
            }else{
                System.out.println("It is a PUSH ");
            }
        }
    }
}    
