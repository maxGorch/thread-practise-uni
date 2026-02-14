package org.example;

public class TaskPrintPropertyAndJoinSecondThread extends Thread {
    @Override
    public void run() {
        System.out.println("start");

            System.out.println("Main Thread start!");

            String nameThread = Thread.currentThread().getName();
            int priorityThread = Thread.currentThread().getPriority();
            String stateThread = String.valueOf(Thread.currentThread().getState());
            long idThread = Thread.currentThread().getId();

            System.out.println(nameThread);
            System.out.println(priorityThread);
            System.out.println(stateThread);
            System.out.println(idThread);

        System.out.println("finish");
    }
}
