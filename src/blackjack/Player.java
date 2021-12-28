/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;
import java.util.*;
/**
 *
 * @author minae
 */
public class Player {
    private String Name;
    private int Score;
    private boolean lost;
    private boolean blackjack;
    private int index ;
    Card []cards =new Card[11];

    
    public Player(String Name, int Score,Card []cards) {
        this.Name = Name;
        this.Score = Score;
        this.cards =cards;
    }

    public Player(Player p){
        this.Name = p.Name;
        this.Score = p.Score;
        this.cards = p.cards;
        this.index = p.index;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
