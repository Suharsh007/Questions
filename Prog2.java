import java.util.*;
public class Prog2 {
     static Stack<Character> stck = new Stack<>();
    static void insertBottom( char x)
    {
     if(stck.isEmpty())
     {
         stck.push(x);
     }

     else{
         char a = stck.peek();
         stck.pop();
         insertBottom(x);
         stck.push(a);
     }
    }
    static void reverse()
    {
        if(stck.size()>0)
        {
            char x = stck.peek();
            stck.pop();
            reverse();
            insertBottom(x);
        }
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        for(int i=0;i<s.length();i++)
        {
            stck.push(s.charAt(i));

        }
        System.out.println("Original Stack");
        System.out.println(stck);
        reverse();
        System.out.println("Reverse Stack");
        System.out.println(stck);
        sc.close();
    }
}