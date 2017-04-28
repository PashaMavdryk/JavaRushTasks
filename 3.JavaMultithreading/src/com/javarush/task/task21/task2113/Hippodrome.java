package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome{
    public static Hippodrome game;
    private  static List<Horse> horses = new ArrayList<>();

    public Hippodrome() {

    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();


        game.horses.add(new Horse("HourseStar", 3, 0));
        game.horses.add(new Horse("HourseCzar", 3, 0));
        game.horses.add(new Horse("HourseNoob", 3, 0));

        game.run();
        game.printWinner();

    }



    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }


    public void move(){
        horses.get(0).move();
        horses.get(1).move();
        horses.get(2).move();
    }
    public void print(){

        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).print();
        }
        for (int i = 0; i <1 ; i++) {
            System.out.println();
        }
    }
    public void run() throws InterruptedException {
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            Thread.sleep(10);

        }
    }
    public Horse getWinner(){
       Horse horseWinner = new Horse("winner", 0 , 0);
       for(Horse horse : getHorses()){
           if(horse.distance>horseWinner.getDistance()) horseWinner = horse;
       }
       return horseWinner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+ "!");
    }
}
