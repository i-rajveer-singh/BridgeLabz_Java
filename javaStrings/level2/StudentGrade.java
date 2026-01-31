public class StudentGrade {
    static int[][] generateScores(int n) {
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = (int)(Math.random() * 90) + 10;
        return arr;
    }

    static double[][] calculate(int[][] pcm) {
        double[][] res = new double[pcm.length][4];
        for (int i = 0; i < pcm.length; i++) {
            double total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3;
            double per = (total / 300) * 100;

            res[i][0] = total;
            res[i][1] = Math.round(avg * 100.0) / 100.0;
            res[i][2] = Math.round(per * 100.0) / 100.0;
        }
        return res;
    }

    static String[] grade(double[][] data) {
        String[] g = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double p = data[i][2];
            if (p >= 90) g[i] = "A+";
            else if (p >= 80) g[i] = "A";
            else if (p >= 70) g[i] = "B";
            else if (p >= 60) g[i] = "C";
            else if (p >= 50) g[i] = "D";
            else g[i] = "Fail";
        }
        return g;
    }

    static void display(int[][] pcm, double[][] calc, String[] grade) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPer\tGrade");
        for (int i = 0; i < pcm.length; i++)
            System.out.println(pcm[i][0] + "\t" + pcm[i][1] + "\t" + pcm[i][2] + "\t" +
                               calc[i][0] + "\t" + calc[i][1] + "\t" + calc[i][2] + "\t" + grade[i]);
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] pcm = generateScores(n);
        double[][] calc = calculate(pcm);
        String[] grade = grade(calc);
        display(pcm, calc, grade);
    }
}
