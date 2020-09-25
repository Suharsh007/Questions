import java.util.HashMap;
import java.util.*;

public class  Prog1 
    public static void main(String args[])

{
    Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]= sc.nextInt();
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int j=0;j<n;j++)
        {
            map.put(a[0][j],1);
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(map.get(a[i][j])!=null && map.get(a[i][j])==i)
                {
                    map.put(a[i][j],i+1);
                    if(i==n-1)
                    System.out.print(a[i][j]+" ");
                }
            }

        }

}

}