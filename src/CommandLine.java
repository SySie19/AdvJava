import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Sylvia on 25.10.2016.
 */
public class CommandLine {

    public static void main(String[] args) {
        File input;
        String inputPath = args[0];
        System.out.println("Input location: " + inputPath);
        input = new File(inputPath);
        FastaTool f = new FastaTool();

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath))){
           String currentLine =  reader.readLine();
            while (currentLine != null){
                String seq =  "";
                if (currentLine.startsWith(">")){
                    //cut the initial >
                    currentLine = currentLine.substring(1);
                    seq = reader.readLine();
                    String seqComplete = "";
                    while (seq!=null && !seq.startsWith(">") ){
                        seqComplete = seqComplete.concat(seq);
                        seq = reader.readLine();
                    }
                    f.addSequence(currentLine, seqComplete);
                }
                currentLine = seq;
            }
        }
        catch (Exception e){
            System.out.println("File could not be red. Try again");
            e.printStackTrace();
        }
        f.printAllSequences();

        System.out.println("End of main");


    }
}
