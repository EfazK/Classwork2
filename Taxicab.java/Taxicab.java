import java.util.Scanner;

public class Taxicab {
    public static void main(String[] args) {
        int angle = 0;
        int xDistance = 0;
        int yDistance = 0;

        String myInput = "R44, R3";
        System.out.println(myInput);
        Scanner input = new Scanner(myInput);

        while (input.hasNext()) {
            String currentWord = input.next().replace(",", ""); // Clean comma
            char turn = currentWord.charAt(0);
            int numberOfCurrentWord = Integer.parseInt(currentWord.substring(1));

            if (turn == 'L') {
                angle -= 90;
            } else if (turn == 'R') {
                angle += 90;
            }

            angle = (angle + 360) % 360; // Normalize

            if (angle == 0) {
                yDistance += numberOfCurrentWord;
            } else if (angle == 90) {
                xDistance += numberOfCurrentWord;
            } else if (angle == 180) {
                yDistance -= numberOfCurrentWord;
            } else if (angle == 270) {
                xDistance -= numberOfCurrentWord;
            }
        }

        System.out.println("Manhattan distance: " + (Math.abs(xDistance) + Math.abs(yDistance)));
    }
}
