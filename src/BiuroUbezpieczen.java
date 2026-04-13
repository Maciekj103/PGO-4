import java.util.ArrayList;

public class BiuroUbezpieczen{
    private String nazwa;
    private ArrayList<Polisa> polisy = new ArrayList<>();

    public BiuroUbezpieczen(String nazwa) {
        this.nazwa = nazwa;
    }
    public void dodajPolise(Polisa polisa){
        polisy.add(polisa);
    }

    public void wypiszRaport(){
        System.out.println("Raport biura: " + nazwa);

        for(Polisa polisa : polisy){
            System.out.println(polisa);
            System.out.println("Skladka: " + polisa.obliczSkladkeKoncowa());
            System.out.println("---------------------");
        }
    }

    public double policzLacznaSkladke(){
        double suma = 0.0;
        for (Polisa polisa : polisy){
            suma = suma + polisa.obliczSkladkeKoncowa();
        }
        return suma;
    }
    public double policzLacznaPrognozeOdnowien(){
        double suma = 0.0;
        for (Polisa polisa : polisy){
            suma = suma + polisa.obliczSkladkeOdnowieniowa();
        }
        return suma;
    }
    public int policzPolisyWysokiegoRyzyka(){
        int liczbaPolis = 0;
        for (Polisa polisa : polisy){
            if (polisa.getPoziomRyzyka() >= 4) liczbaPolis ++;
        }
        return liczbaPolis;
    }
    public Polisa znajdzPoNumerze(String numerPolisy){
        for (Polisa polisa : polisy) {
            if (polisa.getNumerPolisy().equals(numerPolisy)) return polisa;
        }
        return null;
    }
    public void wypiszTanszeNiz (double prog){
        ArrayList<Polisa> tanszePolisy = new ArrayList<>();
        for (Polisa polisa : polisy){
            if (polisa.obliczSkladkeKoncowa() < prog) tanszePolisy.add(polisa);
        }
        int i = 1;
        for (Polisa polisa : tanszePolisy){
            System.out.println(i + ")" + polisa.toString());
            i++;
        }
//        return tanszePolisy;
    }


}