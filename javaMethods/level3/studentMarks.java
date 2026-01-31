
public class P12_StudentMarks {
    public static void main(String[] args){
        int students=5;
        for(int i=1;i<=students;i++){
            int p=(int)(Math.random()*100);
            int c=(int)(Math.random()*100);
            int m=(int)(Math.random()*100);
            int total=p+c+m;
            double avg=total/3.0;
            double per=(total/300.0)*100;
            System.out.println(i+"\t"+p+"\t"+c+"\t"+m+"\t"+total+"\t"+avg+"\t"+per);
        }
    }
}
