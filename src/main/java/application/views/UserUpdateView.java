package application.views;

import java.util.Scanner;

public class UserUpdateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user's ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "Enter new profession: ";
        System.out.print(title);
        String profession = scanner.nextLine().trim();

        return new String[]{id, profession};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
