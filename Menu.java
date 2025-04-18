package Countries;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Menu {

    static void displayMenu(ArrayList <State> a) throws Exception {
        LoadInfo(a);
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("                                         Menu                                            ");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1. Add                                              ");
            System.out.println("2. Search                                           ");
            System.out.println("3. Display                                          ");
            System.out.println("4. Remove                                           ");
            System.out.println("5. Exit                                             ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e){

            }
            System.out.println("-----------------------------------------------------------------------------------------");
            switch (choice){
                case 1:
                    createCountriesUnions(a);
                    break;
                case 2:
                    searchCountry(a);
                    break;
                case 3:
                    displayAllCountries(a);
                    break;
                case 4:
                    removeCountries(a);
                    break;
                case 5:
                    SaveInfo(a);
                    break;
                default:
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("The choice must be between 1 and 5!");
                    System.out.println("-----------------------------------------------------------------------------------------");
            }
        }while(choice != 5);
    }

    static void createCountriesUnions(ArrayList <State> a) throws Exception{
        Scanner sc = new Scanner(System.in);
        String b = "";
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Will you be creating a Country or an Union: ");
        b = sc.nextLine();
        if(b.equalsIgnoreCase("Country"))
        {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Enter the count of the countries you will be entering: ");
            int n = 0;
            try {
                do {
                    n = Integer.parseInt(sc.nextLine());
                }while(n <= 0);
            }
            catch (Exception e){
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("The entry must be a number!");
                System.out.println("-----------------------------------------------------------------------------------------");
            }
            System.out.println("-----------------------------------------------------------------------------------------");
            for (int i = 0; i < n; i++){
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("                 Creating a new Country                ");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the name of the country: ");
                String name = sc.nextLine();
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the capital of the country: ");
                String capital = sc.nextLine();
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the population of the country: ");
                int population = 0;
                try {
                    do {
                        population = Integer.parseInt(sc.nextLine());
                    }while(population <= 0);
                }
                catch (Exception e){
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("The entry must be a number!");
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the type of the country (Democratic / Authoritarian): ");
                String type = "";
                do {
                    type = sc.nextLine().trim();
                }while(!type.equalsIgnoreCase("Democratic") && !type.equalsIgnoreCase("Authoritarian"));
                System.out.println("-----------------------------------------------------------------------------------------");
                if(type.equalsIgnoreCase("Democratic")){
                    System.out.println("Enter the election cycle period: ");
                    int cyclePeriod = Integer.parseInt(sc.nextLine());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("What is the freedom index: ");
                    float freedomIndex = Float.parseFloat(sc.nextLine());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    a.add(new DemocraticState(cyclePeriod, freedomIndex, name, capital, population));
                }
                else if(type.equalsIgnoreCase("Authoritarian")){
                    System.out.println("Enter the censorship level: ");
                    int censorshipLevel = Integer.parseInt(sc.nextLine());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Is there secret police presence: ");
                    boolean secretPresence = Boolean.parseBoolean(sc.nextLine());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    a.add(new AuthoritarianState(censorshipLevel, secretPresence, name, capital, population));
                }
            }
        }
        else if(b.equalsIgnoreCase("Union")){
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Enter the count of the Unions you will be entering: ");
            int n = 0;
            try {
                do {
                    n = Integer.parseInt(sc.nextLine());
                }while(n <= 0);
            }
            catch (Exception e){
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("The entry must be a number!");
                System.out.println("-----------------------------------------------------------------------------------------");
            }
            System.out.println("-----------------------------------------------------------------------------------------");
            String name = "";
            String nameUn = "";
            String capital = "";
            int population = 0;
            int countryCount = 0;
            String ecoPol = "";
            ArrayList<State> c = new ArrayList<State>();
            for (int i = 0; i < n; i++) {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("                 Creating a new Union                                                    ");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the name of the Union: ");
                nameUn = sc.nextLine();
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the capital of the representative of the Union: ");
                capital = sc.nextLine();
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the total population in the Union: ");
                population = 0;
                try {
                    do {
                        population = Integer.parseInt(sc.nextLine());
                    } while (population <= 0);
                } catch (Exception e) {
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("The entry must be a number!");
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Enter the count of the Countries you will be entering in this Union: ");
                countryCount = Integer.parseInt(sc.nextLine());
                for(int j = 0; j < countryCount; j++){
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Enter the name of the Country: ");
                    do {
                        name = sc.nextLine();
                        if (name == null || name.trim().isEmpty()){
                            System.out.println("Cannot be empty!");
                        }
                    } while(name == null && name.trim().isEmpty());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    for (int z = 0; z < a.size(); z++){
                        if (a.get(z).getName().equalsIgnoreCase(name)){
                            c.add(a.get(z));
                        }
                    }
                }
            }
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Enter the economic policy of the Union: ");
            ecoPol = sc.nextLine();
            System.out.println("-----------------------------------------------------------------------------------------");
            Union newUnion = new Union(c, ecoPol, nameUn, capital, population);
            a.add(newUnion);
        }
    }

    static void searchCountry(ArrayList <State> a) throws Exception {
        Scanner sc = new Scanner(System.in);
        if(!a.isEmpty()){
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("                Searching for a Country or an Union             ");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Enter the name of the country/union: ");
            String name = sc.nextLine();
            System.out.println("-----------------------------------------------------------------------------------------");
            boolean z = false;
            for (State state : a) {
                if (state.getName().equals(name)) {
                    state.getDetails();
                    z = true;
                    break;
                }
            }
            if (!z) {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("No such country/union found!");
                System.out.println("-----------------------------------------------------------------------------------------");

            }
        }
        else {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("There is no countries or unions in the database!");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    static void displayAllCountries(ArrayList <State> a) throws Exception{
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                                        Displaying                                       ");
        System.out.println("-----------------------------------------------------------------------------------------");
        Union b = new Union(new ArrayList<>(), "a", "a", "a", 1);
        Class <?> targetClass = b.getClass();
        if (a.size() > 0) {
            for (State state : a) {
                if (targetClass.isInstance(state)) {
                    System.out.println(state.getName() + " Union");
                    continue;
                }
                System.out.println(state.getName());
            }
            System.out.println("-----------------------------------------------------------------------------------------");
        }
        else {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("There is countries or Unions in the database!");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    static void removeCountries(ArrayList <State> a) throws Exception{
        Scanner sc = new Scanner(System.in);
        if (a.size() > 0){
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Enter the count of the countries and/or unions you will be deleting: ");
            int n = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------------------------------------------------------------");
            for (int i = 0; i < n; i++){
                System.out.println("Enter the name of the country or union: ");
                String name = sc.nextLine();
                for (int j = 0; j < a.size(); j++){
                    if (a.get(j).getName().equalsIgnoreCase(name)){
                        a.remove(j);
                    }
                }
            }
        }
        else {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("There is no countries in the database!");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    static void SaveInfo(ArrayList <State> a) throws Exception{
        try (FileOutputStream fileOut = new FileOutputStream("object.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(a);
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("The info has been saved!");
            System.out.println("-----------------------------------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Error occurred while saving info!");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    public static void LoadInfo(ArrayList<State> a) throws Exception {
        try (FileInputStream fileIn = new FileInputStream("object.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            a.clear();
            a.addAll((ArrayList<State>) in.readObject());
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("The info has been loaded!");
            System.out.println("-----------------------------------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Error occurred while loading info!");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }
}