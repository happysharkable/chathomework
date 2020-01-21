package ru.gb.jtwo.ltwo.online;

public class Minotaur implements Bull, Human {
    @Override
    public void voice() {
        System.out.println("Moooo");
    }

    @Override
    public void talk() {
        System.out.println("Get out of my labyrinth");
    }

    @Override
    public void walk() {
        Bull.super.walk();
    }

    @Override
    public void breathe() {

    }

    @Override
    public void look() {

    }
}
