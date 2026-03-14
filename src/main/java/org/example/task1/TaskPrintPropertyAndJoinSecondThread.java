package org.example.task1;

public class TaskPrintPropertyAndJoinSecondThread implements Runnable {
    @Override
    public void run() {
        System.out.println("start");

        String nameThread = Thread.currentThread().getName();
        int priorityThread = Thread.currentThread().getPriority();
        String stateThread = String.valueOf(Thread.currentThread().getState());
        long idThread = Thread.currentThread().threadId();

        System.out.println(nameThread);
        System.out.println(priorityThread);
        System.out.println(stateThread);
        System.out.println(idThread);

        System.out.println("finish");
    }
}
