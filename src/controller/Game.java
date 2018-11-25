package controller;

import logic.combater.*;
import logic.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {
    private boolean hasWinner;
    private Combater player;
    private Combater currentEnemy;
    private List<Combater> monsterList;


    public Game(){
        hasWinner = false;
        currentEnemy = new InvalidMonster();
    }

    public Game(List<Combater> aMonsterList) {
        this();
        monsterList = aMonsterList;
        goNextMonster();
    }

    public Game(int numOfMon){
        this();
        monsterList = createMonsterList(numOfMon);
        goNextMonster();
    }

    @Override
    public void update(Observable o, Object arg) {
        ((Event) arg).visitGame(this);
    }

    public List<Combater> createMonsterList(int numberOfMon){
        List<Combater> newList = new ArrayList<>();

        for (int i = 0; i < numberOfMon; i++) {
            Combater monster = newMonster();
            newList.add(monster);
        }

        return newList;
    }

    public Combater getCurrentMonster(){
        return currentEnemy;
    }

    public Combater getPlayer(){
        return player;
    }

    public void goNextMonster(){
        if (monsterList.size() > 0){
            Combater next = monsterList.get(0);
            monsterList.remove(0);
            currentEnemy = next;
            next.subscribe(this);
        }
        else{
            hasWinner = true;
            currentEnemy = new InvalidMonster();
        }
    }

    public void setPlayer(Combater player){
        this.player = player;
        player.subscribe(this);
    }

    private Combater newMonster(){
        int dice1 = (int)(Math.random()*6) + 1;
        int dice2 = (int)(Math.random()*6) + 1;

        Combater monster;

        if (dice1 + dice2 <= 5)
        {
            monster = new Dragon();
        }
        else {
            monster = new Goblin();
        }

        return monster;
    }

    public void increasePlayerExp() {
        player.increaseExp(currentEnemy.getExp());
    }

    public void finish() {

    }
}
