
import java.util.*;
public class P7 {
    boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P7 s = new P7();
        for (int i = 0; i < 10; i++) {
            int age = sc.nextInt();
            System.out.println(s.canStudentVote(age));
        }
    }
}
