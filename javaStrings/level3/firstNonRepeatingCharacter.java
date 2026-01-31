import java.util.*;
public class Ques3{
static char firstUnique(String s){
int[] f=new int[256];
for(int i=0;i<s.length();i++)f[s.charAt(i)]++;
for(int i=0;i<s.length();i++)if(f[s.charAt(i)]==1)return s.charAt(i);
return 0;
}
public static void main(String[]a){
Scanner s=new Scanner(System.in);
String t=s.nextLine();
System.out.println(firstUnique(t));
}
}