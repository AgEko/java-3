package concurrency;

public class Main {

    public static void main(String[] args) {
         //run all of your threads from this main class.

//        Reasoning task1 = new Reasoning();
//        task1.start();

        TeamTC1 task2 = new TeamTC1();
        Thread teamSemicolon = new Thread(task2);
        teamSemicolon.setName("Team;");
        teamSemicolon.start();



    }
}

