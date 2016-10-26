
import java.util.ArrayList;

/**
 * Created by Sylvia on 25.10.2016.
 */
public class FastaTool {

    ArrayList<Sequence> sequences = new ArrayList<>();
    int maxSeqLenght = 0;
    int minSeqLenght = 1000000;
    ArrayList<Nucleotide> nucleotides = new ArrayList<>();

    public FastaTool (){
        nucleotides.add(new Nucleotide('U'));
        nucleotides.add(new Nucleotide('C'));
        nucleotides.add(new Nucleotide('G'));
        nucleotides.add(new Nucleotide('A'));
        nucleotides.add(new Nucleotide('-'));
    }

    public void addSequence(String seqName, String seq){
        Sequence s = new Sequence();
        s.setName(seqName);

        char[] seqChar = seq.toCharArray();
        for (int i = 0; i< seqChar.length;  i++){
            for (int n = 0; n<nucleotides.size(); n++){
                if (seqChar[i] == nucleotides.get(n).getNuc()){
                    s.addNucleotide(nucleotides.get(n));
                    break;
                }
            }
        }

        sequences.add(s);
        if (s.getLenght()>maxSeqLenght){
            maxSeqLenght = s.getLenght();
        }
        if (s.getLenght()< minSeqLenght){
            minSeqLenght = s.getLenght();
        }
    }

    private int calcAverageLength (){
        int sum = 0;
        for (int i = 0; i<sequences.size(); i++){
            sum  += sequences.get(i).getLenght();
        }
        return sum/sequences.size();
    }

    public void printAllSequences (){

        int rows = maxSeqLenght / 60 +1;
        System.out.println("rows: " +rows);
        for (int r = 0; r < rows; r++){
            System.out.println("\t \t \t \t \t " + (r*60+1) + " \t \t \t \t \t \t \t \t \t \t \t \t " + ((r+1)*60) +"" );
            for (int i = 0; i<sequences.size(); i++){
                System.out.println(sequences.get(i).getName() + "\t \t" + sequences.get(i).printPartOfSeq(r*60, ((r+1)*60)-1));
            }
            System.out.println();
        }
        System.out.println("Number of sequences: " +sequences.size());
        System.out.println("Shortest length: " + minSeqLenght + " (excluding \'-\'s: ?)");
        System.out.println("Average length: " + calcAverageLength() + " (excluding \'-\'s: ?)");
        System.out.println("Longest length: " + maxSeqLenght + " (excluding \'-\'s: ?)");
        System.out.println("Counts: A:? C:? G:? U:? ");
    }

}
