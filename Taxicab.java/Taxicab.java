import java.util.ArrayList;

public class TaxicabPart2 {
    public static void main(String[] args) {
        String input = "R4, R3, R5, L3, L5, R2, L2, R5, L2, R5, R5, R5, R1, R3, L2, L2, L1, R5, L3, R1, L2, R1, L3, L5, L1, R3, L4, R2, R4, L3, L1, R4, L4, R3, L5, L3, R188, R4, L1, R48, L5, R4, R71, R3, L2, R188, L3, R2, L3, R3, L5, L1, R1, L2, L4, L2, R5, L3, R3, R3, R4, L3, L4, R5, L4, L4, R3, R4, L4, R1, L3, L1, L1, R4, R1, L4, R1, L1, L3, R2, L2, R2, L1, R5, R3, R4, L5, R2, R5, L5, R1, R2, L1, L3, R3, R1, R3, L4, R4, L4, L1, R1, L2, L2, L4, R1, L3, R4, L2, R3, L1, L5, R4, R5, R2, R5, R1, R5, R1, R3, L3, L2, L2, L5, R2, L2, R5, R5, L2, R3, L5, R5, L2, R4, R2, L1, R3, L5, R3, R2, R5, L1, R3, L2, R2, R1"; // Replace with your full input
        String[] instructions = input.split(",\\s*");

        int x = 0, y = 0;
        int angle = 0;
        ArrayList<String> visited = new ArrayList<>();

        for (String instr : instructions) {
            char turn = instr.charAt(0);
            int steps = Integer.parseInt(instr.substring(1));

            angle += (turn == 'R') ? 90 : -90;
            angle = (angle + 360) % 360;

            for (int i = 0; i < steps; i++) {
                switch (angle) {
                    case 0: y++; break;
                    case 90: x++; break;
                    case 180: y--; break;
                    case 270: x--; break;
                }

                String coord = x + "," + y;
                if (visited.contains(coord)) {
                    System.out.println("First revisited location: " + coord);
                    System.out.println("Manhattan distance: " + (Math.abs(x) + Math.abs(y)));
                    return;
                }
                visited.add(coord);
            }
        }

        System.out.println("No location visited twice.");
    }
}
