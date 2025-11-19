import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;

public class Signals {

    public static void main(String[] args) {

        try {
            File file = new File("input.txt");
            Scanner input = new Scanner(file);

            // Prepare to store all lines
            String[] lines = new String[1000]; // adjust size if needed
            int lineCount = 0;

            while (input.hasNextLine()) {
                lines[lineCount] = input.nextLine();
                lineCount++;
            }

            int messageLength = lines[0].length();
            int[][] frequencies = new int[messageLength][26]; // one frequency array per column

            // Count frequencies per column
            for (int i = 0; i < lineCount; i++) {
                String line = lines[i];
                for (int j = 0; j < messageLength; j++) {
                    char c = line.charAt(j);
                    frequencies[j][c - 'a']++;
                }
            }

            // Build final message
            StringBuilder message = new StringBuilder();
            for (int col = 0; col < messageLength; col++) {
                int maxCount = -1;
                int maxIndex = -1;
                for (int k = 0; k < 26; k++) {
                    if (frequencies[col][k] > maxCount) {
                        maxCount = frequencies[col][k];
                        maxIndex = k;
                    }
                }
                message.append((char) ('a' + maxIndex));
            }

            System.out.println("Decoded message: " + message.toString());

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return;
        }
    }
}
