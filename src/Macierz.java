/**
 * Created by Szymon - Laptop on 17/04/2017.
 */
public class Macierz {
    private Node first;
    private int matrix;
    public Macierz(int size){
        this.matrix=size;
        first=new Node(0,0,null);

        Node current=first;
        for (int k = 1; k <= matrix; k++){
            current.setNextKolumna(new Node(0, k, null));
            current = current.getNextKolumna();
        }
        current=first;

        for (int w = 1; w <= matrix; w++){
            current.setNextWiersz(new Node(w, 0, null));
            current = current.getNextWiersz();
        }
    }

    public void setValues(int[][] valuesTable) {
        for (int r = 1; r <= matrix; r++) {
            for (int c = 1; c <= matrix; c++) {
                int value = valuesTable[r-1][c-1];
                Node newNode = new Node(r, c, value);
                Node current=first;

                //Szukam odpowiedniej kolumny
                while (current.getNrKolumny() != c)
                    current = current.getNextKolumna();

                //W znalezionej kolumnie szukam odpowiedniego wiersza
                while (current.getNextWiersz() != null && current.getNextWiersz().getNrWiersza() <= r) {
                    if (value == 0 && current.getNextWiersz().getNrWiersza() == r)
                        break;
                    current = current.getNextWiersz();
                }

                //przeskakuje komorke gdzie ma byc zero i wskazuje na nastepna
                if(value == 0){
                    if (current.getNextWiersz() != null && current.getNextWiersz().getNrWiersza() == r){
                        current.setNextWiersz(current.getNextWiersz().getNextWiersz());
                    }}
                else if (current.getNrWiersza() < r){
                    newNode.setNextWiersz(current.getNextWiersz());
                    current.setNextWiersz(newNode);
                }
                else if (current.getNrWiersza() == r) {
                    current.setWartoscElementu(value);
                }

                //Ustawianie wartosci w odpowiedniej kolumnie
                current =first;
                // idę do odpowiedniego rzedu w kolumnie 0
                while (current.getNrWiersza() != r)
                    current = current.getNextWiersz();

                //idę do odpowiedniej kolumny w znalezionym rzędzie
                while (current.getNextKolumna() != null && current.getNextKolumna().getNrKolumny() <= c) {
                    if (value == 0 && current.getNextKolumna().getNrKolumny() == c)
                        break;
                    current = current.getNextKolumna();
                }

                if (value == 0)
                    if (current.getNextKolumna() != null && current.getNextKolumna().getNrKolumny() == c)
                        current.setNextKolumna(current.getNextKolumna().getNextKolumna());
                    else if (current.getNrKolumny() < c) {
                        newNode.setNextKolumna(current.getNextKolumna());
                        current.setNextKolumna(newNode);
                    }
            }
        }
    }

    public void showMacierz(){
        for (int row = 1; row<= matrix; row++){
            String line = "";
            for (int column = 1; column <= matrix; column++) {
                int k=getNumber(row, column);
                System.out.printf("%2s %2d","|", k);
            }
            System.out.print("  |");
            System.out.println(line);
        }
    }

    public int getNumber(int row, int column) {
        int number = 0;

        Node current = first;
        while (current.getNrKolumny() != column)
            current = current.getNextKolumna();

        while (current.getNextWiersz() != null && current.getNextWiersz().getNrWiersza() <= row)
            current = current.getNextWiersz();

        if (current.getNrKolumny() == column && current.getNrWiersza() == row)
            number = current.getWartoscElementu();
        return number;
    }

    public Macierz addMacierz(Macierz m){
        int[][] table=new int[matrix][matrix];
        for(int i=0;i<matrix;i++){
            for(int j=0;j<matrix;j++){
                table[i][j]=getNumber(i+1,j+1)+m.getNumber(i+1,j+1);
            }
        }
        Macierz newMacierz=new Macierz(matrix);
        newMacierz.setValues(table);
        return newMacierz;
    }

}
