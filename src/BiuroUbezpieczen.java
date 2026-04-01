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
        System.out.println("Raport");
    }

//    public double policzLacznaSkladke(){
//
//    }
//    public double policzLacznaPrognozeOdnowien(){
//
//    }
//    public double policzPolisyWysokiegoRyzyka(){
//
//    }
//    public Polisa znajdzPoNumerze(String numerPolisy){
//
//    }
//    public ArrayList<Polisa> wypiszTanszeNiz (double prog){
//
//    }


}