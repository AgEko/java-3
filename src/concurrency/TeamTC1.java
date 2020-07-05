package concurrency;

import java.util.ArrayList;
import java.util.List;

class TeamTC1 implements Runnable {

    List<String> team = new ArrayList<>();


    public void run(){
        team.add("TA Dylan");
        team.add("George");
        team.add("Jessica");
        team.add("John");
        team.add("Katherine");
        team.add("Kevin");
        team.add("Matthew");
        team.add("Nancy");
        team.add("Norita");
        team.add("Sabitha");
        team.add("Vani");
        team.add("Victor");
        team.add("Vimala");

        for (String item : team){
            try{
                System.out.println(item);
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }



    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.  In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).  There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List  After all the names have been pushed to this List, print out the entire list of all the students in your TA group. Don't forget your TA as well!  All of these steps should be done whenever the thread is started.  (i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package.  
}