package AirNemi;

import java.util.ArrayList;
import java.util.List;

public class Let {
    //Putnik[] putnici = new Putnik[40];
    List<Putnik> putnici = new ArrayList<>();
    String[][] mesta = {{" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "},
            {" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}};
    String brojLeta;
    String destinacija;
    public Let(){

    }

    public Let(String brojleta, String destinacija) {
        this.brojLeta = brojleta;
        this.destinacija = destinacija;
    }

    public String getBrojLeta() {
        return brojLeta;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public boolean bukirajMesto(int prviIndex, int drugiIndex){
        if(kontrolaMesta(prviIndex, drugiIndex)){
            mesta[prviIndex][drugiIndex] = "X";
            return true;
        } else {
            System.out.println("To mesto je zauzeto. Izaberi neko drugo!");
            return false;
        }
    }
    public void dodajPutnika(Putnik putnik){
        if(putnici.size() < 40){
            putnici.add(putnik);
        } else {
            System.out.println("Nema slobodnih mesta na tom letu");
        }
    }

    private boolean kontrolaMesta(int prviIndex, int drugiIndex) {
        if(mesta[prviIndex][drugiIndex].equals(" ")){
            return true;
        } else{
            return false;
        }
    }

    public void pokaziMesta() {
        char[] rednaSlova = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int n = 7;
        for(int i = 0; i < 7; i++){
            for(int j = 14 - i * 2 ; j >= 1; j--){
                System.out.print(" ");
            }
            for(int q = 0; q <= i; q++){
                System.out.print("*   ");
            }
            System.out.println();
        }

        System.out.print("  | 1 |  | 2 |  | 3 |  | 4 |");
        System.out.println();
        for(int i = 0; i < mesta.length; i++){
            System.out.print(rednaSlova[i]);
            for(int j = 0; j < mesta[i].length; j++){
                System.out.print(" | " + mesta[i][j] + " | ");
            }
            System.out.println();
            System.out.print("-------------------------------");
            System.out.println();
        }
        for(int i = 0; i < 7; i++){
            for(int q = 0; q <= i; q++){
                System.out.print("  ");
            }
            for(int j = 7; j > i; j--){
                System.out.print("*   ");
            }
            System.out.println();

        }
    }
}
