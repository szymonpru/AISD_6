/**
 * Created by Szymon - Laptop on 11.04.2017.
 */
public class Node {
    private int nrWiersza;
    private int nrKolumny;
    private Integer wartoscElementu;
    private Node nextKolumna;
    private Node nextWiersz;

    public Node(int row, int col, Integer value){
        this.nrWiersza = row;
        this.nrKolumny = col;
        this.wartoscElementu = value;
        nextWiersz=null;
        nextKolumna=null;
    }

    public int getNrWiersza(){
        return nrWiersza;
    }
    public int getNrKolumny(){
        return nrKolumny;
    }
    public int getWarElem(){
        return wartoscElementu;
    }

    public void setNrWiersza(int nrWiersza) {
        this.nrWiersza = nrWiersza;
    }

    public void setNrKolumny(int nrKolumny) {
        this.nrKolumny = nrKolumny;
    }

    public void setWartoscElementu(Integer wartoscElementu) {
        this.wartoscElementu = wartoscElementu;
    }

    public void setNextKolumna(Node nextKolumna) {
        this.nextKolumna = nextKolumna;
    }

    public void setNextWiersz(Node nextWiersz) {
        this.nextWiersz = nextWiersz;
    }

    public Integer getWartoscElementu() {
        return wartoscElementu;
    }

    public Node getNextKolumna() {
        return nextKolumna;
    }

    public Node getNextWiersz() {
        return nextWiersz;
    }

}
