import java.util.*;
public class Ques4{
public static void main(String[]a){
Scanner s=new Scanner(System.in);
String t=s.nextLine();
int[] f=new int[256];
for(int i=0;i<t.length();i++)f[t.charAt(i)]++;
for(int i=0;i<256;i++)if(f[i]>0)System.out.println((char)i+" "+f[i]);
}
}