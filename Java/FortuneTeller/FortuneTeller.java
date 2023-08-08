import java.util.Scanner;

public class FortuneTeller {
    public void truthTeller() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Question:");
        String truth = sc.nextLine();
        System.out.println();
        System.out.println();

        if (truth.equals("will shaochi be the prime minister of singapore?")) {
            System.out.println("Answer: yeah");
        }
        else {
            System.out.println("Answer: yeah");
        }
        System.out.println();
        System.out.println();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Question:");
        String truth1 = sc.nextLine();
        System.out.println();
        System.out.println();
        if (truth1.equals("will shaochi be the prime minister of singapore?")) {
            System.out.println("Answer: yeah");
        }
        else {
            System.out.println("Answer: yeah");
        }


        
    }
    
    
    public static void main(String[] args) {
        FortuneTeller t = new FortuneTeller();
        HappyBirthday h = new HappyBirthday();
        t.truthTeller();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        h.printer();
    }
}


