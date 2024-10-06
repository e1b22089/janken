package oit.is.z2495.kaizi.janken.model;

public class Janken {
    public static String judge(String playerHand, String cpuHand) {
        if (playerHand.equals(cpuHand)) {
            return "引き分け";
        }

        switch (playerHand) {
            case "Gu":
                return (cpuHand.equals("Tyoki")) ? "勝ち" : "負け";
            case "Tyoki":
                return (cpuHand.equals("Pa")) ? "勝ち" : "負け";
            case "Pa":
                return (cpuHand.equals("Gu")) ? "勝ち" : "負け";
            default:
                return "不明";
        }
    }
}
