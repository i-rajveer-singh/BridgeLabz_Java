import java.util.Scanner;

public class p2 {

    static int maxHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = maxHandshakes(n);
        System.out.println(result);
        sc.close();
    }
}
