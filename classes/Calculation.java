package classes;

import filewriteread.OrderConfirmFile;
import interfaces.CalculationActions;
import java.util.Scanner;

public class Calculation implements CalculationActions {

    Scanner input = new Scanner(System.in);

    OrderConfirmFile file = new OrderConfirmFile();

    public static int quantity = 1;
    public static double total = 0.0, pay;

    @Override
    public void order(int choose) {
        switch (choose) {
            case 1: {
                try {
                    System.out.println("You Choose Rice.");
                    System.out.print("How many dishes of rice do you want to buy?: ");
                    quantity = input.nextInt();
                    total = total + (quantity * 45);
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
            }

            case 2: {
                try {
                    System.out.println("You Choose Fish Curry");
                    System.out.print("How many fish do you want to buy?: ");
                    quantity = input.nextInt();
                    total = total + (quantity * 25);
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
            }

            case 3: {
                try {
                    System.out.println("You Choose Vegetable");
                    System.out.print("How many plates of vegetables would you like to buy?: ");
                    quantity = input.nextInt();
                    total = total + (quantity * 15);
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
            }

            case 4: {
                try {
                    System.out.println("You Choose Mutton");
                    System.out.print("How many plates of mutton do you want to buy?: ");
                    quantity = input.nextInt();
                    total = total + (quantity * 50);

                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
            }
        }
    }

    @Override
    public void payment() {

        System.out.println("\nYour Total Persable Amount is: " + total);
        System.out.print("Enter a payment: ");
        pay = input.nextDouble();

        if (pay < total) {
            total = total - pay;
            file.writeIntoFile("\nNot enough payment amount.");
            file.writeIntoFile("\nYou Due Amount:" + total);
        } else if (pay == total) {
            file.writeIntoFile("\nYour Payment Amount: " + pay);
            file.writeIntoFile("\nYour Due Amount: 0 Tk");
        } else {
            total = pay - total;
            file.writeIntoFile("\nYour Payment Amount: " + pay);
            file.writeIntoFile("\nGet back: " + total);
        }
    }
}
