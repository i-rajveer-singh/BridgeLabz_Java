import java.util.Scanner;

class TrimString {
    static int[] trimPoints(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end && s.charAt(start) == ' ') start++;
        while (end >= start && s.charAt(end) == ' ') end--;

        return new int[]{start, end};
    }

    static String subString(String s, int start, int end) {
        String r = "";
        for (int i = start; i <= end; i++)
            r += s.charAt(i);
        return r;
    }

    static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] p = trimPoints(s);
        String custom = subString(s, p[0], p[1]);
        String built = s.trim();

        System.out.println(custom);
        System.out.println(built);
        System.out.println(compare(custom, built));
    }
}
