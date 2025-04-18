package Countries;

import java.util.ArrayList;

public class Union extends State implements InternationalRelations{
    private ArrayList<State> memberCountries;
    private String economicPolicy;

    Union(ArrayList <State> memberCountries, String economicPolicy, String name, String capital, int population ) {
        super(name, capital, population);
        setMemberCountries(memberCountries);
        setEconomicPolicy(economicPolicy);
    }

    public String getMemberCountries() {
        String a = "";
        for (int i = 0; i < memberCountries.size(); i++) {
            if(i + 1 != memberCountries.size()) {
                a = a + memberCountries.get(i).getName() + ", ";
                continue;
            }
            else
            {
                a = a + memberCountries.get(i).getName();
            }
        }
        return a;
    }

    public void setMemberCountries(ArrayList<State> memberCountries) {
        ArrayList<State> validMemberCountries = new ArrayList<>();
        for (int i = 0; i < memberCountries.size(); i++) {
            if (memberCountries.get(i) != null && !memberCountries.get(i).toString().trim().isEmpty()) {
                validMemberCountries.add(memberCountries.get(i));
            } else {
                throw new IllegalArgumentException("Invalid state at index " + i);
            }
        }
        this.memberCountries = validMemberCountries;
    }

    public String getEconomicPolicy() {
        return economicPolicy;
    }

    public void setEconomicPolicy(String economicPolicy) {
        if (economicPolicy == null && economicPolicy.trim().isEmpty()) {
            throw new IllegalArgumentException("There cannot be null or empty economic policy");
        }
        this.economicPolicy = economicPolicy;
    }

    void promoteUnity() throws Exception{
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                   Unity Promotion                                       ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                Be Good to Each Other!                                   ");
        System.out.println("-----------------------------------------------------------------------------------------");
    };

    @Override
    public void goveremnt() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                Union ruling principles                                  ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("1. Everything is decided based on majority vote");
        System.out.println("2. The countries inside are under protection   ");
        System.out.println("3. No Visas needed when travelling in the Union");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void collectTaxes() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                    Tax Collection                                       ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("          Tax collected: " + (1000000 + (Math.random() * Integer.MAX_VALUE)));
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
        System.out.println("Economic Policy: " + getEconomicPolicy()             );
        System.out.println("Member countries: " + getMemberCountries().toString());
        System.out.println("-----------------------------------------------------------------------------------------");
        collectTaxes();
        goveremnt();
    }

    @Override
    public void establishDiplomacy(State state) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                 Establishing diplomacy                                  ");
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
}
