package app;

import java.util.Scanner;

import static app.validator.IsValid;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String STR;
        Scanner sc = new Scanner(System.in);
        System.out.println("equation:");
         STR  = sc.nextLine();
        calculator calc = new calculator();
        while (!IsValid(STR)) {
            System.out.println("equation:");
            STR  = sc.nextLine();


        }double answer=calc.calc(STR);
        System.out.println(answer);



        }
    }
