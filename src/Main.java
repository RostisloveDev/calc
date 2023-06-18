import java.util.Scanner;
public class Main {
    public static String calc(String input) throws Exception {
        CheckInput checkInput = new CheckInput(input);
        checkInput.checkMembers();
        checkInput.checkMembers2();
        return checkInput.checkTwoMetrics();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
}



