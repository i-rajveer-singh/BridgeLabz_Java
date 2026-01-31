
public class P4_PalindromeChecker {
    static boolean isPalindrome(int n){
        String s=""+n;
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static void main(String[] args){
        int n=121;
        System.out.println("Palindrome: "+isPalindrome(n));
    }
}
