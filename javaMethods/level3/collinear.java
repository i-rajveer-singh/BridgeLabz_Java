
public class P10_Collinear {
    static boolean collinear(int x1,int y1,int x2,int y2,int x3,int y3){
        return (y2-y1)*(x3-x2)==(y3-y2)*(x2-x1);
    }
    public static void main(String[] args){
        System.out.println(collinear(2,4,4,6,6,8));
    }
}
