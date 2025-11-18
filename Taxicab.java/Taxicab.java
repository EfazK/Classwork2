import java.util.Scanner;
import java.util.ArrayList;

public class Taxicab{
    public static void main(String[] args) {
        int angle = 0;
        int xDistance = 0;
        int yDistance = 0;

        String myInput = "R4, R3, R5, L3, L5, R2, L2, R5, L2, R5, R5, R5, R1, R3, L2, L2, L1, R5, L3, R1, L2, R1, L3, L5, L1, R3, L4, R2, R4, L3, L1, R4, L4, R3, L5, L3, R188, R4, L1, R48, L5, R4, R71, R3, L2, R188, L3, R2, L3, R3, L5, L1, R1, L2, L4, L2, R5, L3, R3, R3, R4, L3, L4, R5, L4, L4, R3, R4, L4, R1, L3, L1, L1, R4, R1, L4, R1, L1, L3, R2, L2, R2, L1, R5, R3, R4, L5, R2, R5, L5, R1, R2, L1, L3, R3, R1, R3, L4, R4, L4, L1, R1, L2, L2, L4, R1, L3, R4, L2, R3, L1, L5, R4, R5, R2, R5, R1, R5, R1, R3, L3, L2, L2, L5, R2, L2, R5, R5, L2, R3, L5, R5, L2, R4, R2, L1, R3, L5, R3, R2, R5, L1, R3, L2, R2, R1"; // Replace with full input
        System.out.println(myInput);
        Scanner input = new Scanner(myInput);
        ArrayList<String> coords = new ArrayList<>();
        boolean found = false;

        while (input.hasNext() && !found) {
            String currentWord = input.next().replace(",", ""); // Clean comma
            char turn = currentWord.charAt(0);
            int numberOfCurrentWord = Integer.parseInt(currentWord.substring(1));

            if (turn == 'L') {
                angle -= 90;
            } else if (turn == 'R') {
                angle += 90;
            }

            angle = (angle + 360) % 360; // Normalize

            for (int i = 0; i < numberOfCurrentWord; i++) {
                if (angle == 0) {
                    yDistance++;
                } else if (angle == 90) {
                    xDistance++;
                } else if (angle == 180) {
                    yDistance--;
                } else if (angle == 270) {
                    xDistance--;
                }

                String coord = xDistance + "," + yDistance;
                if (coords.contains(coord)) {
                    System.out.println("First revisited location: " + coord);
                    System.out.println("Manhattan distance: " + (Math.abs(xDistance) + Math.abs(yDistance)));
                    found = true;
                    break;
                }
                coords.add(coord);
            }
        }

        if (!found) {
            System.out.println("No location visited twice.");
            System.out.println("Final Manhattan distance: " + (Math.abs(xDistance) + Math.abs(yDistance)));
        }
    }
}
