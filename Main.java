import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

        public class Main
        {

            public static void main(String[] args) throws Exception
            {

                int number = 0;
                int index = 0;
                System.out.println("Please enter the initial size of the Bitvector");
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextInt();
                BitVector bitvector = new BitVector(number);
                Scanner sc = new Scanner(System.in);
                int operation;
                do {
                    System.out.println("Please enter the index");
                    Scanner scanner1 = new Scanner(System.in);
                    index = scanner1.nextInt();
                    if(index > number)
                    {
                        bitvector = new BitVector(index + 1);

                    }
                    System.out.println("please enter the operation 1 - for set, 2 - for reset, 0 - for ending the program");
                    operation = sc.nextInt();
                    if(operation == 1)
                    {
                        bitvector.set(index);
                    }
                    else if(operation == 2)
                    {
                        bitvector.reset(index);
                    }
                } while(operation != 0);


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