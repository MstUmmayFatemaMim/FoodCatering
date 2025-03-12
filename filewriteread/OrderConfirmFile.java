package filewriteread;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class OrderConfirmFile {

     File createFileObject;

    public void createAFile() {
        try {
            createFileObject = new File("order_confirm.txt");

            if (createFileObject.createNewFile()) {
                System.out.println("\n'order_confirm.txt' is created.\n");
            } else {
                System.out.println("\n'order_confirm.txt' file already exists.\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeIntoFile(String str) {

        try {
            FileWriter writeIntoFileObject = new FileWriter("order_confirm.txt", true);
            writeIntoFileObject.write(str);

            writeIntoFileObject.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFromFile() {

        try {
            Scanner readFromFileObject = new Scanner(createFileObject);

            while (readFromFileObject.hasNextLine()) {
                String orderData = readFromFileObject.nextLine();
                System.out.println(orderData);
            }
            readFromFileObject.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        //createFileObject.delete();
    }
}
