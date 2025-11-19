import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Security{

  public static void main(String[] args)
  {

    try
    {
      File file = new File("input.txt");
      Scanner input = new Scanner(file);
      int sum = 0;
      while(input.hasNextLine())
      {
        String line = input.nextLine();
        int valueOfRoom = Integer.parseInt(line);
        int[] numberOfLetters = new int[26];
        String numberPart = line.substring(0, line.length() - 9);
        for(int i = 0; i < numberPart.length(); i++)
        {
          char c = line.charAt(i);
          numberOfLetters[c - 'a']++;
          }

        }

          System.out.println(sum);
      }



    } catch (FileNotFoundException ex) {
      System.out.println("File Not Found");
      return;
    }

  }

}
