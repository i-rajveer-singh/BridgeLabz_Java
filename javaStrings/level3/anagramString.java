import java.util.*;
public class Ques8{
static boolean ana(String a,String b){
if(a.length()!=b.length())return false;
int[] f=new int[256];
for(int i=0;i<a.length();i++){f[a.charAt(i)]++;f[b.charAt(i)]--;}
for(int i=0;i<256;i++)if(f[i]!=0)return false;
return true;
}
public static void main(String[]a){
Scanner s=new Scanner(System.in);
String x=s.nextLine();
String y=s.nextLine();
System.out.println(ana(x,y));
}
}