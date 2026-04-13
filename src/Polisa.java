import java.util.Objects;

public class Polisa{
    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;
    private static int liczbaUtworzonychPolis;
    private static final double OPLATA_ADMINISTRACYJNA = 100.0;

    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka, double wartoscPojazdu, boolean czyMaAlarm, boolean czyBezszkodowyKlient) {
        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
        liczbaUtworzonychPolis ++;
    }

    @Override
    public String toString() {
        return "Polisa{" +
                "numerPolisy='" + numerPolisy + '\'' +
                ", klient='" + klient + '\'' +
                ", skladkaBazowa=" + skladkaBazowa +
                ", poziomRyzyka=" + poziomRyzyka +
                ", wartoscPojazdu=" + wartoscPojazdu +
                ", czyMaAlarm=" + czyMaAlarm +
                ", czyBezszkodowyKlient=" + czyBezszkodowyKlient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Polisa polisa = (Polisa) o;
        return Objects.equals(numerPolisy, polisa.numerPolisy);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numerPolisy);
    }


    public double obliczSkladkeKoncowa(){
        double skladka = skladkaBazowa + OPLATA_ADMINISTRACYJNA + poziomRyzyka * 120;

        if (wartoscPojazdu > 60000) skladka = skladka + 400;
        if (czyMaAlarm) skladka = skladka - 200;
        if (czyBezszkodowyKlient) skladka = skladka - 200;
        if (skladka < skladkaBazowa) skladka = skladkaBazowa;
        return skladka;
    }

    public double obliczSkladkeOdnowieniowa(){
        double wczesniejszaSkladka = obliczSkladkeKoncowa();
        double skladka = wczesniejszaSkladka;
        if (poziomRyzyka == 4) skladka = skladka * 1.1;         //wiecej o 10%
        else if (poziomRyzyka >= 5) skladka = skladka * 1.2;    //wiecej o 20%
        if (wartoscPojazdu > 60000) skladka = skladka + 150;
        if (czyBezszkodowyKlient) skladka = skladka * 0.92;     //obnizka o 8%
        if (czyMaAlarm) skladka = skladka * 0.95;               //obnizka o 5%
        if (skladka < 0.9 * wczesniejszaSkladka) skladka = 0.9 * wczesniejszaSkladka;
        else if (skladka > 1.25 * wczesniejszaSkladka) skladka = 1.25 * wczesniejszaSkladka;
        skladka = Math.round(skladka * 100) / 100.0;            //zaokrąglenie do dwoch miejsc po przecinku
        return skladka;
    }
    public String pobierzPodsumowanieRyzyka(){
        return "Poziom ryzyka wynosi: " + poziomRyzyka + "\nBo:\n"+ (czyMaAlarm? "Ma alarm" : "Nie ma alarmu") + "\n" +
                (czyBezszkodowyKlient ? "Klient jest bezszkodowy." : "Klient nie jest bezszkodowy");
    }
    public static int pobierzLiczbeUtworzonychPolis(){
        return getLiczbaUtworzonychPolis();
    }



    //gettery
    public static int getLiczbaUtworzonychPolis() {
        return liczbaUtworzonychPolis;
    }

    public boolean czyBezszkodowyKlient() {
        return czyBezszkodowyKlient;
    }

    public double getWartoscPojazdu() {
        return wartoscPojazdu;
    }

    public int getPoziomRyzyka() {
        return poziomRyzyka;
    }

    public double getSkladkaBazowa() {
        return skladkaBazowa;
    }

    public String getKlient() {
        return klient;
    }

    public String getNumerPolisy() {
        return numerPolisy;
    }






}