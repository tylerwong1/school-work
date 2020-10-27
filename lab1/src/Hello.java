import java.util.*;
public class Hello {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String name, city, age;

        System.out.print("Hello. What is your name? ");
        name = scn.next();
        System.out.print("It's nice to meet you, " + name + ". " + "How old are you? ");
        age = scn.next();
        System.out.println("I see that you are still quite young at only " + age + ".");
        System.out.print("Where do you live? ");
        city = scn.next();
        System.out.println("Wow! I've always wanted to go to " + city + ". " + "Thanks for chatting with me. Bye!");
        
        // testing - lab 6


    }
}
