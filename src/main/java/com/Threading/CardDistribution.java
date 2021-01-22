package com.Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDistribution {
}

class Player implements Runnable{

    private List<Card> cardList;
    private List<Card> allCard;
    private int seq;
    private int playerID;
    Random random;

    public Player(final List<Card> cardList, final List<Card> allCard, int playerID) {
        this.cardList = new ArrayList<>();
        this.allCard= allCard;
        this.playerID = playerID;
        this.random = new Random();

    }

    @Override
    public void run() {
        synchronized (this.allCard) {
            while (seq != playerID) {
                try {
                    allCard.wait();
                }
                catch (InterruptedException e) {
// TODO
                }

            }
            int cardId = random.nextInt();
            //if(cardList.get(cardId)==0);
        }
    }
}

class Card{
    int cradNo;
    int cardName;
}