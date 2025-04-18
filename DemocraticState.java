package Countries;

public class DemocraticState extends State implements InternationalRelations{
    private int electionCicle;
    private float freedomIndex;

    DemocraticState(int electionCicle, float freedomIndex, String name, String capital, int population){
        super(name, capital, population);
        setElectionCicle(electionCicle);
        setFreedomIndex(freedomIndex);
    }

    public int getElectionCicle() {
        return electionCicle;
    }

    public void setElectionCicle(int electionCicle) {
        if(electionCicle < 0 || electionCicle > 100) {
            throw new IllegalArgumentException("Election cicle must be between 0 and 100!");
        }
        else {
            this.electionCicle = electionCicle;
        }
    }

    public float getFreedomIndex() {
        return freedomIndex;
    }

    public void setFreedomIndex(float freedomIndex) {
        if(freedomIndex < 0 || freedomIndex > 100) {
            throw new IllegalArgumentException("Freedom index must be between 0 and 100!");
        }
        else {
            this.freedomIndex = freedomIndex;
        }
    }

    void holdElections() throws Exception{
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                    Election results                    ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("      The winner is Bay Ganio with 54,56% of votes!     ");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void establishDiplomacy(State state) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                Establishing diplomacy                                   ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(getName() + " establishing diplomacy with " + state.getName());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void negotiateTreaty(State state) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                   Negotiating treaty                                    ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(getName() + " is negotiating a traety with " + state.getName());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void goveremnt() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                Democracy ruling principles                              ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("1. Everything is decided based on who gets 51% of votes");
        System.out.println("2. Freedom of speech                                   ");
        System.out.println("3. Equality in the eyes of the government              ");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void collectTaxes() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                     Tax Collection                                      ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Tax collected: " + (100000 + (Math.random() * Integer.MAX_VALUE))                         );
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void getDetails() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                      Information                                        ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Name: " + getName()                             );
        System.out.println("Capital: " + getCapital()                       );
        System.out.println("Population: " + getPopulation()                 );
        System.out.println("Election Cicle: " + electionCicle               );
        System.out.println("Freedom Index: " + freedomIndex                 );
        System.out.println("-----------------------------------------------------------------------------------------");
        collectTaxes();
        goveremnt();
    }
}
