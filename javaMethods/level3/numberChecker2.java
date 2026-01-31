
public class P3_NumberChecker2 {
    static int[] digits(int n){
        String s=""+n; int[] d=new int[s.length()];
        for(int i=0;i<s.length();i++) d[i]=s.charAt(i)-'0';
        return d;
    }
    static int sum(int[] d){ int s=0; for(int x:d) s+=x; return s; }
    static int sumSquares(int[] d){ int s=0; for(int x:d) s+=x*x; return s; }
    static boolean isHarshad(int n,int[] d){ return n%sum(d)==0; }
    public static void main(String[] args){
        int n=21; int[] d=digits(n);
        System.out.println("Sum: "+sum(d));
        System.out.println("Sum Squares: "+sumSquares(d));
        System.out.println("Harshad: "+isHarshad(n,d));
    }
}
