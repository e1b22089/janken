package oit.is.z2495.kaizi.janken.model;

public class Janken {
    public static String judge(String playerHand, String cpuHand) {
        if (playerHand.equals(cpuHand)) {
            return "draw";
        }

        switch (playerHand) {
            case "Gu":
                return (cpuHand.equals("Tyoki")) ? "You Win!" : "You Lose";
            case "Tyoki":
                return (cpuHand.equals("Pa")) ? "You Win!" : "You Lose";
            case "Pa":
                return (cpuHand.equals("Gu")) ? "You Win!" : "You Lose";
            default:
                return "不明";
        }
    }
}
