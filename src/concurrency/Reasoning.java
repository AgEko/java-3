package concurrency;

class Reasoning extends  Thread{
    //set up this class so it can become a valid thread.

    public void run(){
        distinguish();
    }

    void distinguish() {

        //print to the console the difference between a thread and a process.

        System.out.println("A thread is a segment of a process.");
        System.out.println("A process is any program currently in execution.");

        //https://www.geeksforgeeks.org/difference-between-process-and-thread/

        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.

    }

}

