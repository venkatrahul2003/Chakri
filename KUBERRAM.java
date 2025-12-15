import java.util.Scanner;

public class KUBERRAM{
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);

        System.out.println("enter ur one");
        int one= scanner.nextInt();
        System.out.println("enter ur two");
        int two=scanner.nextInt();
        System.out.println("enter ur three");
        int three=scanner.nextInt();
        int x=Math.max(one,two);
        System.out.println(Math.max(x,three));



    }
}






