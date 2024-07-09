import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                valid = true;
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!valid);
        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                valid = true;
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter a double.");
            }
        } while (!valid);
        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                if (retInt >= low && retInt <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!valid);
        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                if (retDouble >= low && retDouble <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter a double.");
            }
        } while (!valid);
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean valid = false;
        boolean retBool = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                retBool = true;
                valid = true;
            } else if (response.equalsIgnoreCase("N")) {
                retBool = false;
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);
        return retBool;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a string matching the pattern " + regEx + ".");
            }
        } while (!valid);
        return response;
    }

    public static void prettyHeader(String msg) {
        int width = 60;
        int msgLen = msg.length();
        int starsCount = (width - msgLen - 6) / 2; // 6 accounts for the three stars on either side

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < starsCount; i++) {
            System.out.print("*");
        }
        System.out.print(" *** " + msg + " *** ");
        for (int i = 0; i < starsCount; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}