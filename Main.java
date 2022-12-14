import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import java.text.NumberFormat;

public class Main {
    public static void main(String args[]) {
        // primitive data types
        byte age = 127;
        short num1 = 222;
        int num2 = 156_234; // we can use _ to make big numbers readable, like we use commas on paper
        // long num3 = 23_123_456_789; // error assumes that number is int only, use L
        long num3 = 23_123_456_789L;
        double price1 = 10.99;
        float price2 = 10.99F;
        char a = 'A';
        boolean b = true;

        System.out.println("\nPrimitive data types -");
        System.out.println(age);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(price1);
        System.out.println(price2);
        System.out.println(a);
        System.out.println(b);

        // reference data types
        // Date class is imported, 'now' is an object which is instance of class Date
        Date now = new Date();
        System.out.println("\nReference data types -");
        System.out.println(now);
        String msg1 = new String("Hello world!"); // java.lang package is by default imported
        System.out.println(msg1);
        String msg2 = "  Bye world!  "; // short hand for String, looks like primitive type but is reference type only
        System.out.println(msg2);
        System.out.println(msg1.length());
        System.out.println(msg1.startsWith("Hel"));
        System.out.println(msg1.indexOf("o"));
        System.out.println(msg1.replace("world", "java")); // returns new string obj, doesn't mutate original
        System.out.println(msg1.toLowerCase());
        System.out.println(msg2.trim());

        // difference between primitive and reference types
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        System.out.println("Point 1 before : " + point1);
        System.out.println("Point 2 before : " + point2);
        point1.x = 5;
        System.out.println("Point 1 after change : " + point1);
        System.out.println("Point 2 also changes as reference is same : " + point2);

        // escape sequences
        System.out.println("\nEscape sequences -");
        System.out.println("\"Quotes inside quotes\"");
        System.out.println("Path: C:\\Windows\\...");
        System.out.println("Used \t tab \nand newline");

        // Array - reference type
        System.out.println("\nArray: reference type -");
        // older syntax
        int[] numbers1 = new int[5];
        numbers1[0] = 1;
        numbers1[1] = 2;
        // numbers1[20] = 3; // java throws exception, no further lines run
        System.out.println(numbers1); // this prints the address not array
        // import class java.util.Arrays
        // Arrays.toString(numbers1); // this returns string representation of array
        System.out.println(Arrays.toString(numbers1));
        // new syntax
        int[] numbers2 = { 3, 2, 1 };
        System.out.println(Arrays.toString(numbers2));
        System.out.println(numbers2.length);
        // in java we can't modify array length once initialized,
        // for that we use collection classes
        Arrays.sort(numbers2); // sorting array
        System.out.println(Arrays.toString(numbers2));
        // string array
        // String[] fruits = { "Apple", "Mango" };

        // Multi-dimensional arrays
        System.out.println("\nMulti dimensional arrays -");
        // older syntax
        int[][] numbers3 = new int[2][3];
        numbers3[0][0] = 1;
        System.out.println(Arrays.toString(numbers3)); // doesn't work for multi dimensional arrays
        System.out.println(Arrays.deepToString(numbers3)); // use this
        // new syntax
        int[][] numbers4 = { { 3, 2, 1 }, { 4, 5, 6 } };
        System.out.println(Arrays.deepToString(numbers4));

        // Constants
        System.out.println("\nConstants -");
        final float PI = 3.14F; // naming convention is all letters capital
        // PI = 2; // not allowed
        System.out.println(PI);

        // Arithmetic expressions
        System.out.println("\nArithmetic expressions -");
        // pending ...

        // Operators precedence
        // () >>> * / >>> + -

        // Type casting
        System.out.println("\nType casting -");
        // implicit (happens automatically when lower data type is used with higher)
        // lower to higher data type order -
        // byte > short > int > long > float > double
        byte x1 = 2;
        int y1 = x1 + 1; // x1 is implicitly casted to int as '1' is int and y is int
        // byte z1 = x1 + 1; // error, z1 is byte, '1' int higher data type
        // for this we use explicit casting (forcing higher data type to lower)
        // this can lead to data loss
        byte z1 = (byte) (x1 + 1);

        double x2 = 1.1;
        double y2 = x2 + 2; // implicit casting '2' -> '2.0'
        // int z2 = x2 + 2; // error, 'x2' is double so explicit casting
        int z2 = (int) x2 + 2;

        System.out.println("\nParsing strings to numeric values -");
        // we can do casting only for compatible types
        // for String to int or float etc, we use wrapper classes
        // wrapper class Integer for int, Short for short, has methods parseInt etc
        String s = "1";
        // int s1 = s + 1; // error can't put string into int
        // String S = s + "1"; // this is valid
        int s1 = Integer.parseInt(s) + 1; // 2
        int s2 = Short.parseShort(s) + 1; // 2 - implicit casting
        float s3 = Float.parseFloat(s) + 1; // 2.0

        // this is important as mostly we get user input as string, even numeric values
        // so we need to convert it before operations

        // Math class - defined in java.lang package hence imported by default
        System.out.println("\nMath Class -");
        // we have round method overloaded (implemented twice)
        // in one it can take float as argument and returns int
        Math.round(1.1F); // int, answer = 1
        // in other it can take double as argument and returns long
        Math.round(1.1); // long, answer = 1

        Math.round(1.49); // long, answer = 1
        Math.round(1.5); // long, answer = 2
        Math.ceil(1.1F); // double, answer = 2
        Math.floor(1.1F); // double, answer = 1
        Math.max(1, 2); // int, answer = 2
        Math.min(1, 2); // int, answer = 1
        Math.random(); // double, returns random value 0 to 1
        int result = (int) (Math.random() * 100); // returns random int from 1 to 99

        // Formatting numbers class - NumberFormat
        System.out.println("\nNumberFormat Class -");
        // it is an abstract class so we can't create an instance of it
        // NumberFormat currency = new NumberFormat(); // error
        // instead we use factory methods -
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println(currency.format(123456.789)); // $123,456.79
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println(percent.format(0.1)); // 10%
        // instead of creating variables as we only use it once, we can chain methods
        System.out.println(NumberFormat.getPercentInstance().format(0.1)); // 10%

        // reading input from user
        System.out.println("\nReading input -");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        byte age1 = sc.nextByte(); // for byte input, input 2.5 will give error
        System.out.println("Your age is: " + age1);
        // for input 2.5 use
        // float fakeAge = sc.nextFloat();

        // for strings we don't have nextString()
        // we have next() and nextLine()
        System.out.print("Enter your name: ");
        // String name1 = sc.next(); // takes only 1 word from input
        // if we put virat kohli, it will store virat
        sc.nextLine(); // we need to use this line as - It consumes the \n character
        // read more here -
        // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        // we can avoid this line if we use nextLine everywhere with wrapper classes
        // like Integer.parseInt(sc.nextLine()) for input

        // to solve the 1 word problem use -
        String name1 = sc.nextLine().trim(); // takes whole line
        // as sc.nextLine() returns a string we can chain method .trim()
        System.out.println("Your name is: " + name1);

        // CONTROL FLOW

        // comparison operators
        System.out.println("\nComparison operators -");
        System.out.println(1 == 1); // true
        System.out.println(1 != 1); // false
        // more operators: >, <, >=, <=

        // logical operators
        System.out.println("\nLogical operators -");
        // AND: &&
        // OR: ||
        // NOT: !

        // if statements
        System.out.println("\nIf statements -");
        // if () {

        // } else if () {

        // } else {

        // }

        // we can improve code avoiding unnecessary if like
        // instead of this -
        boolean isAdult1 = false;
        if (age > 18) {
            isAdult1 = true;
        }
        // simply do this -
        boolean isAdult2 = age > 18;

        // ternary operator
        System.out.println("\nTernary operator -");
        String userCategory = age > 18 ? "Adult" : "Not an adult";

        // switch statements
        System.out.println("\nSwitch statements -");
        // switch (key) {
        // case value:
        // break;

        // default:
        // break;
        // }

        // here, data type of key and value have to be same

        // for loop
        System.out.println("\nFor loop -");
        for (int i = 0; i < 5; i++) {
            int j = i + 1;
            System.out.println("For loop line " + j);
        }

        // while loop - useful when we don't know the number of times loop should be
        // executed unlike in for where we know the number, hence we use counter
        System.out.println("\nWhile loop -");
        String input = "Quit";
        // we can't use != operator for reference types, this compares the address
        // while (input != "Quit") // incorrect
        while (!input.equals("Quit")) { // we need to use this method
            // code
        }

        // do while loop
        System.out.println("\nDo while loop -");
        // do {

        // } while (condition); // semicolon at the end

        // break and continue
        System.out.println("\nBreak and Continue -");
        while (true) { // need no condition as we use break with same condition
            // code
            if (input.equals("Skip this input")) {
                continue;
            } else if (input.equals("Quit")) {
                break;
            }

            System.out.println(input);
        }

        // for each loop
        System.out.println("\nFor each loop -");
        String[] fruits = { "Apple", "Mango", "Orange" };
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
