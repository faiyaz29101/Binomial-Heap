import java.io.*;

public class Main {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        Binomial_heap bh = new Binomial_heap();
        String line = br.readLine();
        while(true) {
            String[] commands = line.split(" ");
            if(commands[0].equals("I")){
                bh.Insert(Integer.parseInt(commands[1]));
            }
            else if(commands[0].equals("U")){
                Binomial_heap temp = new Binomial_heap();
                for(String s : commands){
                    if(!s.equals("U")){
                        temp.Insert(Integer.parseInt(s));
                    }
                }
                bh.Union_Heap(temp);
            }
            else if(commands[0].equals("F")){
                int x = bh.FindMin();
                if(x!=-1) {
                    bw.write("Find-Min returned " + x + "\n");
                    System.out.print("Find-Min returned " + x + "\n");
                }
                else{
                    bw.write("Empty Heap\n");
                    System.out.print("Empty Heap\n");
                }
            }
            else if(commands[0].equals("E")){
                int x  = bh.ExtractMin();
                if(x!=-1) {
                    bw.write("Extract-Min returned " + x + "\n");
                    System.out.print("Extract-Min returned " + x + "\n");
                }
                else{
                    bw.write("Empty Heap\n");
                    System.out.print("Empty Heap\n");
                }
            }
            else if(commands[0].equals("P")){
                bw.write(bh.Print());
                System.out.print(bh.Print());
            }
            line = br.readLine();
            if(line == null){
                break;
            }
        }
        bw.close();
    }
}