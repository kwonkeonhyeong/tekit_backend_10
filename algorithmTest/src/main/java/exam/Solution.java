package exam;

public class Solution {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 ={"want", "to"};
        String[] goal ={"i", "want", "to", "water", "drink", "ff"};

        System.out.println(solution(cards1,cards2,goal));
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int[] cards1Index = new int[cards1.length];
        int[] cards2Index = new int[cards2.length];

        if(cards1.length + cards2.length < goal.length) {
            return "No";
        }


        for (int i = 0; i < cards1.length; i++) {
            boolean isContain = false;

            for (int j = 0; j < goal.length; j++) {
                if(cards1[i].equals(goal[j])){
                    cards1Index[i] = j;
                    isContain = true;
                }
            }

            if(!isContain) {
                return "No";
            }
        }

        for (int i = 0; i < cards2.length; i++) {
            boolean isContain = false;
            for (int j = 0; j < goal.length; j++) {
                if(cards2[i].equals(goal[j])){
                    cards2Index[i] = j;
                    isContain = true;
                }
            }
            if(!isContain) {
                return "No";
            }
        }

        for (int i = 0; i < cards1Index.length-1; i++) {
            if (cards1Index[i] > cards1Index[i + 1]) {
                return "No";
            }
        }

        for (int i = 0; i < cards2Index.length-1; i++) {
            if (cards2Index[i] > cards2Index[i + 1]) {
                return "No";
            }
        }
        return "Yes";
    }
}
