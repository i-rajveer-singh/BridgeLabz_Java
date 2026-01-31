import java.util.Scanner;

class RockPaperScissors {
    static String computerChoice() {
        int r = (int)(Math.random() * 3);
        if (r == 0) return "rock";
        if (r == 1) return "paper";
        return "scissors";
    }

    static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors")) return "User";
        if (user.equals("scissors") && comp.equals("paper")) return "User";
        if (user.equals("paper") && comp.equals("rock")) return "User";
        return "Computer";
    }

    static String[][] stats(int userWin, int compWin, int games) {
        String[][] res = new String[2][3];
        res[0][0] = "User";
        res[0][1] = String.valueOf(userWin);
        res[0][2] = String.valueOf((userWin * 100.0) / games);

        res[1][0] = "Computer";
        res[1][1] = String.valueOf(compWin);
        res[1][2] = String.valueOf((compWin * 100.0) / games);

        return res;
    }

    static void display(String[][] games, String[][] stats) {
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < games.length; i++)
            System.out.println((i+1) + "\t" + games[i][0] + "\t" + games[i][1] + "\t" + games[i][2]);

        System.out.println("\nPlayer\tWins\tPercentage");
        for (int i = 0; i < stats.length; i++)
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] games = new String[n][3];
        int userWin = 0, compWin = 0;

        for (int i = 0; i < n; i++) {
            String user = sc.next();
            String comp = computerChoice();
            String win = winner(user, comp);

            if (win.equals("User")) userWin++;
            if (win.equals("Computer")) compWin++;

            games[i][0] = user;
            games[i][1] = comp;
            games[i][2] = win;
        }

        String[][] stat = stats(userWin, compWin, n);
        display(games, stat);
    }
}
