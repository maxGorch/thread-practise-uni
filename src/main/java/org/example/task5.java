package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task5 {
    private List<Integer> data = new ArrayList<Integer>();
    Random rand = new Random();

    public synchronized List<Integer> getData() {
        return this.data;
    }

    public synchronized int getDataSize() {
        return this.data.size();
    }

    public synchronized void add() {
        int randomInt = (int) (Math.random() * (75 - 10 + 1)) + 10;
        this.data.add(randomInt);
    }

    public synchronized void delete() {
        if (!data.isEmpty()) {
            int random = rand.nextInt(data.size());
            data.remove(random);
        }
    }
}
