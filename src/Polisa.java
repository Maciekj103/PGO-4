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
    private static final double OPLATA_ADMINISTRACYJNA;

    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka, double wartoscPojazdu, boolean czyMaAlarm, boolean czyBezszkodowyKlient) {
        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
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


//    public double obliczSkladkeKoncowa(){
//
//    }
//    public double obliczSkladkeOdnowieniowa(){
//
//    }
//    public String pobierzPodsumowanieRyzyka(){
//
//    }
//    public static int pobierzLiczbeUtworzonychPolis(){
//
//    }


    public void dodajPolise(){
    }


    //gettery
    public static int getLiczbaUtworzonychPolis() {
        return liczbaUtworzonychPolis;
    }

    public boolean isCzyBezszkodowyKlient() {
        return czyBezszkodowyKlient;
    }

    public boolean isCzyMaAlarm() {
        return czyMaAlarm;
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