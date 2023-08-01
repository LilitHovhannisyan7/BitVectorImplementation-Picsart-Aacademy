import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main 
{

    public static void main(String[] args) throws Exception 
    {
       
        // bitvector.reset(0);
        // bitvector.set(0);
        // bitvector.set(57);
        // bitvector.reset(57);
        // bitvector.set(57);
        // bitvector.reset(60);
        // System.out.println(bitvector.toString());

        System.out.println("Input please the initialSize: ");
        Scanner scanner1 = new Scanner(System.in);
        int number = scanner1.nextInt();
        BitVector bitvector = new BitVector(number);
         int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (count < number) 
        {
            System.out.println(count + " index:  Choose Set or Reset: ");
            String temp = scanner.nextLine();
            if (temp.equals("Set")) 
            {
                bitvector.set(count);
            } 
            else if (temp.equals("Reset")) 
            {
                bitvector.reset(count);
            } 
            else 
            {
                System.out.println("Not valid");
                scanner.close();
                scanner1.close();
                return;
            }
            ++count;

        }

        scanner.close();
        scanner1.close();
        try 
        {
        
            File file = new File("result.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(bitvector.toString());
            fileWriter.close();

            System.out.println("Result successfully saved to result.txt.");
        } 
        catch (IOException e) 
        {
            System.err.println("Error occurred while saving the result: " + e.getMessage());
        }
    }
}







        

