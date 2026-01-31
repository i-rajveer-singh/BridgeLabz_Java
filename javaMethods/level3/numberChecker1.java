
public class P2_NumberChecker1 {
    static int countDigits(int n){ return String.valueOf(n).length(); }
    static int[] digits(int n){
        String s=""+n; int[] d=new int[s.length()];
        for(int i=0;i<s.length();i++) d[i]=s.charAt(i)-'0';
        return d;
    }
    static boolean isDuck(int[] d){
        for(int x:d) if(x!=0) return true; return false;
    }
    static boolean isArmstrong(int n,int[] d){
        int p=d.length, s=0;
        for(int x:d) s+=Math.pow(x,p);
        return s==n;
    }
    public static void main(String[] args){
        int n=153;
        int[] d=digits(n);
        System.out.println("Digits: "+countDigits(n));
        System.out.println("Duck: "+isDuck(d));
        System.out.println("Armstrong: "+isArmstrong(n,d));
    }
}
