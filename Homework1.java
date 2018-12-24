/**
 * Java. Level 2* Lesson 1. Homework 1.
 *
 * @author Petrov Nikolay
 * @version dated Dec 24, 2018
 */
import java.util.Arrays;
import java.lang.Integer;

public class Homework1 {
    public static void main(String[] args) {
        Team team = new Team("Spartak",
                new Player[]{
                        new Player("player1", 200),
                        new Player("player2", 300),
                        new Player("player3", 150),
                        new Player("player4", 250)
                });

        System.out.println(team);
        Course course = new Course(
                new int[]{
                        20,
                        100,
                        150
                });

        System.out.println(course);
        course.doIt(team);
        team.showResults();
    }
}

    /*Класс команд*/
    class Team{
        private String name;
        private Player [] players;
        private String result ="";

        Team(String name, Player[]players){
            this.name = name;
            this.players = players;
            result =" ";
        }
        public void doIt(Obstacle Obstacle) {
            result += Obstacle.toString() + "\n";
            for (Player player : players) {
                result += "> " + player + " " + Obstacle.doIt(player) + "\n";
            }
        }
        public void showResults() {
            System.out.println(result);
        }
        @Override
        public String toString() {
            return "Team: " + name+
                    " " + Arrays.toString(players);
        }
    }

    /*Класс игроков*/
    class Player{
        private String name;
        private int run_limit;

        Player(String name, int run_limit){
            this.name = name;
            this.run_limit = run_limit;
        }

        public boolean run(int length){
            return run_limit>=length;
        }

        @Override
        public String toString() {
            return this.getClass().getName() + " " + name;
        }
    }

    /*Класс полосы препятствий*/
    class Course{
        private int [] obstacles;

        Course(int[]obstacles){
            this.obstacles = obstacles;
        }
        public void doIt(Team team){
            for(Integer obstacle: obstacles){
               /* team.doIt();*/
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(obstacles);
        }
    }
    /*Класс препятствие*/
    class Obstacle{
        private  int length;
        Obstacle(int length){
            this.length =length;
        }
        public boolean doIt(Player player) {
            return player.run(length);
        }
        @Override
        public String toString() {
            return this.getClass().getName() + " " + length + "m";
        }
    }
