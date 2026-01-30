
import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > 0){
            int fact = 1;
            int i = 1;
            while(i<= n){
                fact = fact*i;
                i++;
            }
            System.out.println(fact);
        }
        sc.close();
    }
}
