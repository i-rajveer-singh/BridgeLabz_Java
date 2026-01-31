
public class P6_Factors {
    static int[] factors(int n){
        int c=0;
        for(int i=1;i<=n;i++) if(n%i==0) c++;
        int[] f=new int[c]; int j=0;
        for(int i=1;i<=n;i++) if(n%i==0) f[j++]=i;
        return f;
    }
    public static void main(String[] args){
        int n=6;
        int[] f=factors(n);
        System.out.print("Factors: ");
        for(int x:f) System.out.print(x+" ");
    }
}
