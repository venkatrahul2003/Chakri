// ⚠️ IMPORTANT: Class name must match the file name!
// Save this file as chakradhar
import java.util.Scanner; // Import Scanner for user input

public class chakradhar {

    // main() is the entry point — program starts execution here
    public static void main(String[] args) {

        // ---------------------------------------
        // 1️⃣ PRINTING OUTPUT
        // ---------------------------------------
        System.out.println("Hello, World!"); // println prints with new line
        System.out.print("This is on the same line ");
        System.out.println("and continues here.");

        // ---------------------------------------
        // 2️⃣ VARIABLES & DATA TYPES
        // ---------------------------------------
        int age = 25;           // Integer
        double price = 19.99;   // Decimal number
        char grade = 'A';       // Single character
        boolean isJavaFun = true; // True/False
        String name = "Rahul";  // Text

        System.out.println("\n--- VARIABLES ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Grade: " + grade);
        System.out.println("Is Java Fun? " + isJavaFun);

        // Constants
        final double PI = 3.14159; // Value cannot change
        System.out.println("Constant PI = " + PI);

        // ---------------------------------------
        // 3️⃣ OPERATORS
        // ---------------------------------------
        int a = 10, b = 3;
        System.out.println("\n--- OPERATORS ---");

        // Arithmetic
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b)); // integer division
        System.out.println("a % b = " + (a % b)); // remainder

        // Relational
        System.out.println("a > b : " + (a > b));
        System.out.println("a < b : " + (a < b));
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));

        // Logical
        boolean x = true, y = false;
        System.out.println("x && y : " + (x && y)); // AND
        System.out.println("x || y : " + (x || y)); // OR
        System.out.println("!x : " + (!x));         // NOT

        // ---------------------------------------
        // 4️⃣ CONDITIONAL STATEMENTS
        // ---------------------------------------
        int marks = 82;
        System.out.println("\n--- IF-ELSE Example ---");

        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 50) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }

        // Nested if example
        int num = -5;
        if (num >= 0) {
            if (num == 0) {
                System.out.println("Number is zero");
            } else {
                System.out.println("Number is positive");
            }
        } else {
            System.out.println("Number is negative");
        }

        // Switch example
        int day = 2;
        System.out.println("\n--- SWITCH Example ---");
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Another day");
        }

        // ---------------------------------------
        // 5️⃣ LOOPS
        // ---------------------------------------
        System.out.println("\n--- FOR LOOP ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        System.out.println("\n--- WHILE LOOP ---");
        int count = 1;
        while (count <= 3) {
            System.out.println("Count is: " + count);
            count++;
        }

        System.out.println("\n--- DO-WHILE LOOP ---");
        int k = 3;
        do {
            System.out.println("Value of k = " + k);
            k--;
        } while (k > 0);

        // Break & Continue example
        System.out.println("\n--- BREAK & CONTINUE ---");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue; // skip 3
            if (i == 5) break;    // stop loop at 5
            System.out.println("i = " + i);
        }

        // ---------------------------------------
        // 6️⃣ ARRAYS
        // ---------------------------------------
        System.out.println("\n--- ARRAYS ---");
        int[] numbers = {10, 20, 30, 40, 50}; // array of integers
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // Print array using regular for-loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // Print array using enhanced for-loop
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // Sum of array
        int total = 0;
        for (int n : numbers) total += n;
        System.out.println("Sum of numbers = " + total);

        // ---------------------------------------
        // 7️⃣ METHODS (FUNCTIONS)
        // ---------------------------------------
        System.out.println("\n--- METHODS ---");
        sayHello();                 // no parameters, no return
        greetPerson("Rahul");       // parameter
        int sumResult = addNumbers(5, 10); // method with return
        System.out.println("Sum = " + sumResult);

        // ---------------------------------------
        // 8️⃣ USER INPUT
        // ---------------------------------------
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- USER INPUT ---");
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();

        System.out.print("Enter your age: ");
        int userAge = sc.nextInt();

        System.out.println("Hello " + userName + ", you are " + userAge + " years old.");

        // Example: 3 numbers average
        System.out.print("Enter three numbers separated by space: ");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();
        double avg = (n1 + n2 + n3) / 3;
        System.out.println("Average = " + avg);

        sc.close(); // always close Scanner

        // ---------------------------------------
        // END
        // ---------------------------------------
        System.out.println("\n--- END OF JAVA MASTER PROGRAM ---");
    }

    // -------------------------------
    // METHOD DEFINITIONS
    // -------------------------------

    public static void sayHello() {
        System.out.println("Hello from sayHello() method!");
    }

    public static void greetPerson(String name) {
        System.out.println("Hi " + name + ", welcome to Java!");
    }

    public static int addNumbers(int x, int y) {
        return x + y;
    }
}



















