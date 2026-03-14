package org.example.task7;

import org.example.task7.MonitorCapt;

class GameStatus
{
        public Object syncObject = new Object();
        public boolean isPingTurn = true;
        public Object GetSyncObject()
        {
            return this.syncObject;
        }
         public boolean GetIsPingTurn()
        {
            return this.isPingTurn;
        }
}
public class MonitorCapt implements Runnable
{   
    GameStatus gs = new GameStatus();
        @Override
        public void run()
        {
            printPing objPrintPing = new printPing(gs);
            Thread threadPrintPing = new Thread(objPrintPing);

            printPong objPrintPong = new printPong(gs);
            Thread threadPrintPong = new Thread(objPrintPong);

            
                 threadPrintPing.start();
                    synchronized(gs.GetSyncObject()){
                    try {
                        gs.GetSyncObject().notifyAll();
                        threadPrintPong.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }    
            
            
        }
}
class printPing implements Runnable
    {
        GameStatus gs;
        printPing(GameStatus GameStatus)
        {
            this.gs = GameStatus;
        }
        @Override
        public void run()
        {
            while (true) {
                synchronized(gs.GetSyncObject()){
                    try {
                        if(gs.isPingTurn == true){
                            System.out.println("ping");  
                            gs.isPingTurn = false;
                            gs.GetSyncObject().notifyAll();
                        }
                        else gs.GetSyncObject().wait();  
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }    
            }
        }
    }
 class printPong implements Runnable
    {
        GameStatus gs;
        printPong(GameStatus GameStatus)
        {
            this.gs = GameStatus;
        }
        @Override
        public void run()
        {
            while (true) {
                synchronized(gs.GetSyncObject())
                {
                    try {
                        if(gs.isPingTurn == false){
                            System.out.println("pong");
                            gs.isPingTurn = true;
                            gs.GetSyncObject().notifyAll();
                        }
                        else gs.GetSyncObject().wait();   
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                }    
            }
        }
    }