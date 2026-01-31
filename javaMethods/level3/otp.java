
public class P7_OTP {
    static int generate(){
        return 100000+(int)(Math.random()*900000);
    }
    public static void main(String[] args){
        for(int i=0;i<10;i++) System.out.println(generate());
    }
}
