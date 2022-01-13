package AirNemi;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Meni {
    ArrayList<Let> letovi = new ArrayList<>();
    Map<String, Putnik> putnici = new HashMap<>();

    public void napraviLetove() {
        Let malmoNis = new Let("AirNemi10", "Malmö - Nis");
        Let nisMalmo = new Let("AirNemi13", "Nis - Malmö");
        Let malmoBeg = new Let("AirNemi11", "Malmö - Beograd");
        Let begMalmo = new Let("AirNemi12", "Beograd - Malmö");

        letovi.add(malmoNis);
        letovi.add(nisMalmo);
        letovi.add(malmoBeg);
        letovi.add(begMalmo);

    }

    public void pokaziMeni(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Dobro dosli u kompaniju AirNemi");
            System.out.println("\n 1. Prikazi letove \n 2. Napravi nalog \n 3. Bukiraj let \n 4. Izaberi mesto \n 5. Ugasi program");
            int izbor = sc.nextInt();
            sc.nextLine();

            switch (izbor) {
                case 1: {
                    prikaziLetove();
                    break;
                }
                case 2: {
                    napraviNalog();
                    break;
                }
                case 3: {
                    bukirajLet();
                }
                case 4: {

                }
                case 5: {
                    System.exit(0);
                    break;

                }
                default: {
                    System.out.println("Unet je nevazeci izbor. Pokusaj ponovo!");
                    break;
                }
            }
        }
    }

    private void bukirajLet() {
        System.out.println("Da bi ste bukirali let morate prvo da se logujete na svoj nalog!");
        logovanje();
    }

    private void logovanje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Upisi svoje koriscko ime");
        String korisnickoIme = sc.nextLine();
        System.out.println("Upisi svoje prezime");
        String prezime = sc.nextLine();
        System.out.println("Upisi svoje ime");
        String ime = sc.nextLine();


        if(putnici.containsKey(korisnickoIme)){
            String im = putnici.get(korisnickoIme).getIme();
            String pr = putnici.get(korisnickoIme).getPrezime();
            //if(putnici.get(korisnickoIme).getPrezime().equals(prezime) && putnici.get(korisnickoIme).getIme().equals(ime)){
            if(prezime.equals(pr) && ime.equals(im)){
                izaberiLet(korisnickoIme, prezime, ime);
            } else{
                System.out.println("Uneli ste pogresno prezime ili ime");
                System.out.println("Zelite da pokusate ponovo (upisite 'da') ili da idete na pocetnu (upisite 'ne')");
                String izbor = sc.nextLine();
                if(izbor.equals("da")){
                    logovanje();
                }
                if(izbor.equals("ne")){
                    pokaziMeni();
                } else {
                    System.out.println("Uneli ste nevazeci izbor");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e){
                    }
                    pokaziMeni();
                }
            }

        } else {
            System.out.println("To korisnicko ime ne postoji!");
            System.out.println("Zelite da pokusate ponovo (upisite 'da') ili da idete na pocetnu (upisite 'ne')");
            String izbor = sc.nextLine();
            if(izbor.equals("da")){
                logovanje();
            }
            if(izbor.equals("ne")){
                pokaziMeni();
            } else {
                System.out.println("Uneli ste nevazeci izbor");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e){
                }
                pokaziMeni();
            }
        }
    }

    private void izaberiLet(String korisnickoIme, String prezime, String ime) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ove letove nudi nasa aviokompanija");
        prikaziLetove();
        System.out.println("\n Upisi 1 za let na relaciji Malmö - Nis" +
                "\n Upisi 2 za let na relaciji Nis - Malmö" +
                "\n Upisi 3 za let na relaciji Malmö - Beograd" +
                "\n Upisi 4 za let na relaciji Beograd - Malmö");
        boolean ispravan = false;
        while(ispravan) {
            int izbor = sc.nextInt();
            sc.nextLine();
            if(izbor == 1 | izbor == 2 | izbor == 3 | izbor == 4){
                for(Let let : letovi){
                    Putnik putnik = new Putnik(prezime, ime);
                    let = letovi.get(izbor);
                    let.dodajPutnika(putnik);
                }

                ispravan = true;
            } else {
                System.out.println("Uneli ste nevazeci izbor! Izaberite izmedju 1-4!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e){
                }
            }
        }
    }

    public void napraviNalog() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Upisi svoje prezime");
        String prezime = sc.nextLine();
        System.out.println("Upisi svoje ime");
        String ime = sc.nextLine();
        System.out.println("Upisi svoje korisnicko ime");
        String korisnickoIme = sc.nextLine();

        if(putnici.containsKey(korisnickoIme)){
            System.out.println("To korisnicko ime vec postoji");
            System.out.println("Proveri da mozda vec nemas nalog ili izaberi drugo korisnicko ime");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){

            }
        } else {
            Putnik putnik = new Putnik(prezime, ime);
            putnici.putIfAbsent(korisnickoIme, putnik);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){

            }
        }
    }

    private void prikaziLetove() {
        for(Let let : letovi){
            String brojLeta = let.getBrojLeta();
            String destinacija = let.getDestinacija();
            System.out.println("Broj leta je: " +brojLeta + " i leti na relaciji " + destinacija);
        }
    }
}