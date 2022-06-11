import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        NumToRoman converter = new NumToRoman();

        System.out.print("\nInteger to Roman Numeral Converter");

        while (true) {
            System.out.print("\nEnter a number: ");

            int num = sc.nextInt();

            if (num == 0)
                break;

            String roman = converter.toRoman(num);
            System.out.println(roman);

        }

        System.out.println("Goodbye!");
        sc.close();
    }
}

