package com.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 23.05.16.
 */
public class Switcher {

    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Switcher is turned on");
//        if (null != listeners) {
//            listeners.electricityOn();
        for (ElectricityConsumer c : listeners) {
            c.electricityOn();
        }
    }
}

