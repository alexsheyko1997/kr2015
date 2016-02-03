/**
 * Created by Александр on 16.08.2015.
 */
public class MemoryClass{
    private Double memory;

    public MemoryClass(){
        memory = new Double("0");
    }

    public Double getMemory() {
        return memory;
    }

    public void setMemory(String str) {
        memory = new Double(str);
    }

    public void clearMemory(){
        memory = new Double("0");
    }

    public void addToMemory(String str){
        memory += new Double(str);
    }

    public void takeAwayFromMemory(String str){
        memory -= new Double(str);
    }
}
