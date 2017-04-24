/**
 * Created by Szymon - Laptop on 11.04.2017.
 */
public class Main {
    public static void main(String args[]){
        int[][] tablica = new int[4][4];
        tablica[0][0]=3;
        tablica[0][1]=2;
        tablica[0][2]=0;
        tablica[0][3]=0;
        tablica[1][0]=0;
        tablica[1][1]=-2;
        tablica[1][2]=1;
        tablica[1][3]=0;
        tablica[2][0]=2;
        tablica[2][1]=0;
        tablica[2][2]=0;
        tablica[2][3]=6;
        tablica[3][0]=7;
        tablica[3][1]=0;
        tablica[3][2]=0;
        tablica[3][3]=5;
        System.out.println("Macierz A:");
        Macierz macierz=new Macierz(4);
        macierz.setValues(tablica);
        macierz.showMacierz();
        System.out.println("+");
        int[][] tablica2 = new int[4][4];
        tablica2[0][0]=0;
        tablica2[0][1]=0;
        tablica2[0][2]=2;
        tablica2[0][3]=5;
        tablica2[1][0]=0;
        tablica2[1][1]=0;
        tablica2[1][2]=1;
        tablica2[1][3]=0;
        tablica2[2][0]=1;
        tablica2[2][1]=0;
        tablica2[2][2]=4;
        tablica2[2][3]=0;
        tablica2[3][0]=0;
        tablica2[3][1]=0;
        tablica2[3][2]=0;
        tablica2[3][3]=0;
        System.out.println("Macierz B:");
        Macierz macierz2=new Macierz(4);
        macierz2.setValues(tablica2);
        macierz2.showMacierz();
        System.out.println("=");
        macierz.addMacierz(macierz2).showMacierz();

    }
}
