package Countries;

public class AuthoritarianState extends State {
    private int censorshipLevel;
    private boolean secretPolicePresence;

    AuthoritarianState(int censorshipLevel, boolean secretPolicePresence, String name, String Capital, int population) {
        super(name, Capital, population);
        setCensorshipLevel(censorshipLevel);
        setSecretPolicePresence(secretPolicePresence);
    }

    public int getCensorshipLevel() {
        return censorshipLevel;
    }

    public void setCensorshipLevel(int censorshipLevel) {
        if (censorshipLevel < 1 || censorshipLevel > 100){
            throw new IllegalArgumentException("Censorship level must be between 1 and 100");
        }
        else {
            this.censorshipLevel = censorshipLevel;
        }
    }

    public boolean isSecretPolicePresence() {
        return secretPolicePresence;
    }

    public void setSecretPolicePresence(boolean secretPolicePresence) {
        this.secretPolicePresence = secretPolicePresence;
    }

    void imposeCensorship() throws Exception{
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                      Censorship                                         ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                 You are now censored!                                   ");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void goveremnt() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                             Authoritarian ruling principles                             ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("1. Everything is decided based on the ruler                                              ");
        System.out.println("2. No free speech                                                                        ");
        System.out.println("3. No elections, the leader is chosen by the ruling party                                ");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void collectTaxes() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                     Tax Collection                                      ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Tax collected: " + (5000000 + (Math.random() * Integer.MAX_VALUE))                        );
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void getDetails() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                      Information                                        ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Name: " + getName()                                  );
        System.out.println("Capital: " + getCapital()                            );
        System.out.println("Population: " + getPopulation()                      );
        System.out.println("Censoreship level: " + getCensorshipLevel()          );
        System.out.println("Secret police presence: " + isSecretPolicePresence() );
        System.out.println("-----------------------------------------------------------------------------------------");
        collectTaxes();
        goveremnt();
    }
}
