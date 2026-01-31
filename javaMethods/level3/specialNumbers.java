
public class P5_SpecialNumbers {
    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++) if(n%i==0) return false;
        return true;
    }
    static boolean isBuzz(int n){ return n%7==0 || n%10==7; }
    public static void main(String[] args){
        int n=7;
        System.out.println("Prime: "+isPrime(n));
        System.out.println("Buzz: "+isBuzz(n));
    }
}
