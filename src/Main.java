import java.util.Scanner;

/**
 * test driver
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static NumToRoman converter = new NumToRoman();

    public static void main(String[] args) throws Exception {
        // app banner
        System.out.print("\nInteger to Roman Numeral Converter");


        // user input loop
        boolean keepGoing = true;
        do {
            System.out.print("\ninteger to convert, or 0 to quit: ");
            // filter out all but integer input
            while (sc.hasNext() && !sc.hasNextInt()) {
                System.out.println("integers only please!");
                System.out.print("\ninteger to convert, or 0 to quit: ");
                sc.next();
            }
            keepGoing = convert(sc.nextInt());
        } while (keepGoing);

        System.out.println("Goodbye!");
        sc.close();
    }

    private static boolean convert(int num) {
        // check for quit command
        if (num == 0)
            return false;

        System.out.println(converter.toRoman(num));
        return true;
    }
}

