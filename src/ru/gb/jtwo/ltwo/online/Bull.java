package ru.gb.jtwo.ltwo.online;

public interface Bull extends Animal {
    void voice();
    default void walk() {
        System.out.println("walks on four hooves");
    }
}
