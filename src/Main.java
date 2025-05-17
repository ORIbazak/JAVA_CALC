import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner sc = new Scanner(System.in);
        System.out.println("equation:");
        String STR  = sc.nextLine();

        calculator calc = new calculator();
        double answer=calc.calc(STR);
        System.out.println(answer);



        }
    }
