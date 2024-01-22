package fantasy_football;
 
import java.util.Scanner;
 
public class FantasyFootball {
    private int numberOfTeams; // Same as teamAverage.length.
    private int numberOfWeeks; // Same as weekAverage.length.
    private int[][] scores; // numberOfTeams rows and numberOfWeeks columns.
    private double[] weekAverage; // contains an entry for each week
    private double[] teamAverage; // contains an entry for each team
    private String[] teamName; // contains an entry for each team
 
    public void enterInData() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter number of teams: ");
        numberOfTeams = keyboard.nextInt();
        System.out.print("Enter number of weeks: ");
        numberOfWeeks = keyboard.nextInt();
 
        teamName = new String[numberOfTeams];
        scores = new int[numberOfTeams][numberOfWeeks];
 
        for (int team = 0; team < numberOfTeams; team++) {
            System.out.println("");
            System.out.print("Enter team name: ");
            teamName[team] = keyboard.next();
 
            for (int week = 0; week < numberOfWeeks; week++) {
                System.out.print("Enter score for team " + teamName[team] + " on week number " + (week + 1) + ": ");
                scores[team][week] = keyboard.nextInt();
 
            }
        }
    }
 
    public void fillTeamAverage() {
        teamAverage = new double[numberOfTeams];
 
        // for each team
        for (int team = 0; team < numberOfTeams; team++) {
            double average = 0;
 
            // for each week
            for (int week = 0; week < numberOfWeeks; week++) {
                average = average + scores[team][week];
            }
 
            teamAverage[team] = average / numberOfWeeks;
        }
    }
 
    public void fillWeekAverage() {
        weekAverage = new double[numberOfWeeks];
 
        // for each week
        for (int week = 0; week < numberOfWeeks; week++) {
            double average = 0;
 
            // for each team
            for (int team = 0; team < numberOfWeeks; team++) {
                average = average + scores[team][week];
            }
 
            weekAverage[week] = average / numberOfTeams;
        }
    }
 
    public void display() {
        System.out.println("");
        System.out.print("Team Name            ");
 
        for (int i = 1; i < numberOfWeeks + 1; i++) {
            System.out.print("Week " + i + "     ");
        }
 
        for (int i = 0; i < numberOfTeams; i++) {
            System.out.println("");
            System.out.printf("%-16s", teamName[i]);
 
            for (int j = 0; j < numberOfWeeks; j++) {
                System.out.printf("%11d", scores[i][j]);
            }
 
            System.out.print("  Ave = " + teamAverage[i]);
        }
 
        System.out.println("");
        System.out.printf("%-16s", "Weekly Ave:");
 
        for (int i = 0; i < numberOfWeeks; i++) {
            System.out.printf("%11.1f", weekAverage[i]);
        }
    }
 
    public static void main(String[] args) {
        FantasyFootball f = new FantasyFootball();
        f.enterInData();
        f.fillTeamAverage();
        f.fillWeekAverage();
 
        f.display();
    }
}