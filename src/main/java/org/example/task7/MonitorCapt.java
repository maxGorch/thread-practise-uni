package org.example.task7;

import org.example.task7.MonitorCapt;

class GameStatus {
    private final Object syncObject = new Object();
    public boolean isPingTurn = true;

    public Object GetSyncObject() {
        return this.syncObject;
    }

    public boolean GetIsPingTurn() {
        return this.isPingTurn;
    }
}

public class MonitorCapt implements Runnable {
    GameStatus gs = new GameStatus();

    @Override
    public void run() {
        PrintPing objPrintPing = new PrintPing(gs);
        Thread threadPrintPing = new Thread(objPrintPing);

        PrintPong objPrintPong = new PrintPong(gs);
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

class PrintPing implements Runnable {
    GameStatus gs;

    PrintPing(GameStatus GameStatus) {
        this.gs = GameStatus;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (gs.GetSyncObject()) {
                try {
                    while (!gs.isPingTurn) {
                        gs.GetSyncObject().wait();
                    }
                    System.out.println("ping");
                    gs.isPingTurn = false;
                    gs.GetSyncObject().notifyAll();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class PrintPong implements Runnable {
    GameStatus gs;

    PrintPong(GameStatus GameStatus) {
        this.gs = GameStatus;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (gs.GetSyncObject()) {
                try {
                    while (gs.isPingTurn) {
                        gs.GetSyncObject().wait();
                    }
                    Thread.sleep(100);
                    System.out.println("pong");
                    gs.isPingTurn = true;
                    gs.GetSyncObject().notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}