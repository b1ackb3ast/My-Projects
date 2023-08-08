import java.util.*;
public class arrayProject {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("How many days' temperatures? ");
        int numDays = console.nextInt();
        int[] temps = new int[numDays];
        // record temperature and find average
        int sum = 0;
        for ( int i=0; i<numDays; i++) {
            System.out.println("Day " + (i+1) + "'s high temperature: ");
            temps[i] = console.nextInt();
            sum += temps[i];
        }
    double average = sum / numDays;
    // count days above average
    int above = 0;
    for (int i = 0; i<temps.length; i++) {
        if (temps[i] > average) {
            above++;
        }
    }
    System.out.println();
    System.out.println("Average Temp = " + average);
    System.out.println("Number of days that are more than average: " + above);
    
    
    
    
    }
}
