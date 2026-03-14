package org.example.task9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class GameStatus {
    public boolean isPingTurn = true;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition ver = lock.newCondition();

    public boolean GetIsPingTurn() {
        return this.isPingTurn;
    }

    public ReentrantLock GetReentrantLock() {
        return this.lock;
    }

    public Condition GetCondition() {
        return this.ver;
    }
}

public class task9 implements Runnable {
    GameStatus gs = new GameStatus();

    @Override
    public void run() {
        printPing objPrintPing = new printPing(gs);
        Thread threadPrintPing = new Thread(objPrintPing);

        printPong objPrintPong = new printPong(gs);
        Thread threadPrintPong = new Thread(objPrintPong);

        {
            try {
                threadPrintPing.start();
                threadPrintPong.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class printPing implements Runnable {
    GameStatus gs;

    printPing(GameStatus GameStatus) {
        this.gs = GameStatus;
    }

    @Override
    public void run() {
        while (true) {
            gs.GetReentrantLock().lock();
            try {
                while (!gs.isPingTurn) {
                    gs.GetCondition().await();
                }
                System.out.println("ping");
                gs.isPingTurn = false;
                gs.GetCondition().signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                gs.GetReentrantLock().unlock();
            }
        }
    }
}

class printPong implements Runnable {

    GameStatus gs;

    printPong(GameStatus GameStatus) {
        this.gs = GameStatus;
    }

    @Override
    public void run() {
        while (true) {
            gs.GetReentrantLock().lock();
            try {
                while (gs.isPingTurn) {
                    gs.GetCondition().await();
                }
                System.out.println("pong");
                Thread.sleep(300);
                gs.isPingTurn = true;
                gs.GetCondition().signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                gs.GetReentrantLock().unlock();
            }
        }
    }
}