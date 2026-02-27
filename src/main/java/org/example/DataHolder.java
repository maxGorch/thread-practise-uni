package org.example;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataHolder {
    private List<Integer> data = new ArrayList<Integer>();
    Random rand = new Random();

    public synchronized int getDataElement(int i)
    {
        return this.data.get(i);
    }
    public synchronized int getDataSize()
    {
        return this.data.size();
    }

    public void add()
    {
        int randomInt =(int) (Math.random() * (75-10+1))+10;
        synchronized (this)
        {
            this.data.add(randomInt);
        }
    }
    public void delete()
    {

       int index = rand.nextInt(data.size());
        synchronized(this)
        {
            data.remove(index);
        }
    }
}
