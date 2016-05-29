package com.lambda;

/**
 * Created by igor on 23.05.16.
 */
public class Program {
    public static void fire() {
        System.out.println("");
    }
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        switcher.addElectricityListener(lamp);
        switcher.addElectricityListener(radio);

        switcher.addElectricityListener( () -> System.out.println("Fire!!!") );


        switcher.switchOn();
    }
}
