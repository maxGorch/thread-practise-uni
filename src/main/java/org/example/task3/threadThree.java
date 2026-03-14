package org.example.task3;

public class threadThree implements Runnable {
    @Override
    public void run()
    {
        try {
            System.out.println("SubThread start!" + Thread.currentThread().getName());
            Thread.sleep(300);
            System.out.println("SubThread finish!"+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("interrupted sbuThread" );
        }
    }
}
