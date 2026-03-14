package org.example.practiseSelf;

import java.util.concurrent.Semaphore;

public class SemaphorRes implements Runnable {
   private Semaphore first;
   private Semaphore second;
 
   public SemaphorRes(Semaphore s1, Semaphore s2) {
       first = s1;
       second = s2;
   }
 
   public void run() {
       try {
           
       } catch (Exception exception) {
          
       }
   }
}
