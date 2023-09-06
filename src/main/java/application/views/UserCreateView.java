package application.views;

import java.util.Scanner;

public class UserCreateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter first name: ";
        System.out.print(title);
        String firstName = scanner.nextLine().trim();

        title = "Enter last name: ";
        System.out.print(title);
        String lastName = scanner.nextLine().trim();

        title = "Enter age: ";
        System.out.print(title);
        String age = scanner.nextLine().trim();

        title = "Enter profession: ";
        System.out.print(title);
        String profession = scanner.nextLine().trim();

        return new String[]{firstName, lastName, age, profession};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
