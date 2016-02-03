/**
 * Created by Александр on 10.08.2015.
 */
public class Mind {
    private Double claim;
    private MemoryClass memory;

    public Mind(){
        memory = new MemoryClass();
    }

    public MemoryClass getMemoryClass() {
        return memory;
    }

    public Double getClaim() {
        return claim;
    }

    public void setClaim(String str) {
        this.claim = new Double(str);
    }

    public void clearClaim(){
        claim = null;
    }

    public Double log(String nextClaim){
        return Math.log10(new Double(nextClaim));
    }

    public Double ln(String nextClaim){
        return Math.log(new Double(nextClaim));
    }

    public Double reciproc(String nextClaim){
        return 1/new Double(nextClaim);
    }


    public void action(String nextClaim, char act) {
        switch (act){
            case '-':
                claim -= new Double(nextClaim);
                break;
            case '+':
                claim += new Double(nextClaim);
                break;
            case '*':
                claim *= new Double(nextClaim);
                break;
            case '/':
                claim /= new Double(nextClaim);
                break;
            case '^':
                claim = Math.pow(claim, new Double(nextClaim));
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
}
