import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sylvia on 25.10.2016.
 */
public class Sequence {
    private String name;
    private ArrayList <Nucleotide> seq;
    // for output of lenght without gaps
    private int lenghtWithoutGaps = 0;

    public Sequence (){
        // todo set name
        seq = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addNucleotide (Nucleotide nuc){
        // adds each letter of the sequence as nucleotide object to the seq list
        seq.add(nuc);
    }

    public void setName (String name){
        this.name = name;
    }

    public int getLenght (){
        return this.seq.size();
    }

    public String printPartOfSeq (int start, int end){
        if (start > seq.size()){
            return "";
        }
        if (start + (end-start)>= seq.size()){
            end = seq.size()-1;
        }
        List<Nucleotide> partOfSeq = seq.subList(start, end);
        String result = "";
        for (int i = 0; i < partOfSeq.size(); i++){
            result += partOfSeq.get(i).getNuc();
        }
        return result;
    }
}
