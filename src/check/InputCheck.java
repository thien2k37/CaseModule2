package check;

import java.util.Scanner;

public class InputCheck {
    Scanner sc = new Scanner(System.in);
    public int checkInteger() {
        int out = 0;
        boolean check = false;
        do {
            try {
                String input = sc.nextLine();
                out = Integer.parseInt(input);
                check = true;
            }catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ. Nhập lại");
                System.out.println("--------------------");
            }
        }while (!check);
        return out;
    }

}
