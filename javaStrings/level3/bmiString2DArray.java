import java.util.*;
public class Ques1{
static String status(double b){
if(b<18.5)return"Underweight";
if(b<25)return"Normal";
if(b<40)return"Overweight";
return"Obese";
}
public static void main(String[]a){
Scanner s=new Scanner(System.in);
double[][] arr=new double[10][2];
for(int i=0;i<10;i++){arr[i][0]=s.nextDouble();arr[i][1]=s.nextDouble();}
System.out.println("Height Weight BMI Status");
for(int i=0;i<10;i++){
double h=arr[i][1]/100;
double bmi=arr[i][0]/(h*h);
System.out.println(arr[i][1]+" "+arr[i][0]+" "+bmi+" "+status(bmi));
}
}
}