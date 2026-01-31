
public class P11_Bonus {
    public static void main(String[] args){
        for(int i=1;i<=10;i++){
            double salary=10000+Math.random()*90000;
            int years=(int)(Math.random()*10);
            double bonus= years>5 ? salary*0.05 : salary*0.02;
            System.out.println("Emp "+i+" Old:"+salary+" Bonus:"+bonus+" New:"+(salary+bonus));
        }
    }
}
