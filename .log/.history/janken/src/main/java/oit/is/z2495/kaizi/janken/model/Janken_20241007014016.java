package oit.is.z2495.kaizi.janken.model;

public class Janken {
    public static String judge(String playerHand, String cpuHand) {
        if (playerHand.equals(cpuHand)) {
            return "引き分け";
        }

        switch (playerHand) {
            case "ぐー":
                return (cpuHand.equals("チョキ")) ? "勝ち" : "負け";
            case "ちょき":
                return (cpuHand.equals("パー")) ? "勝ち" : "負け";
            case "ぱー":
                return (cpuHand.equals("グー")) ? "勝ち" : "負け";
            default:
                return "不明";
        }
    }
}
