package MAS;

import MAS.classes.*;
import MAS.restrictions.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    /** MiniProjekt 1       MAIN
     * Skladowe:            Linki:                                          Opis:
     * Ekstensja,           {@link Client#getExtent()}                      -> Interfejs Serializable dla danych klas (oczywiscie najlepszym rozwiazaniem bylaby baza danych)
     * Ekstensja - trwałość,{@link #createTemplateData()}                   -> Interfejs Serializable
     * Atrybut złożony,     {@link Address}                                 -> Implementacja atrybutu zlozonego (w tym przypadku atrybut adres)
     *                      {@link Client#residanceAddress}                 -> Atrybut zlozony adresZamieszkania dla klasy Klient (Address)
     *                      {@link Order#deliveryAddress}                   -> Atrybut zlozony adresDostawy dla klasy Zamowienie (Address)
     * Atrybut opcjonalny,  {@link Client#email}                            -> Atrybut opcjonalny email dla klasy Klient (String)
     *                      {@link Courier#email}                           -> Atrybut opcjonalny email dla klasy Kurier (String)
     *                      {@link ServiceTechnician#email}                 -> Atrybut opcjonalny email dla klasy Serwisant  (String)
     * Atrybut powtarzalny, {@link Client#firstName}                        -> Atrybut powtarzalny imie dla klasy Klient  (List String)
     *                      {@link Courier#firstName}                       -> Atrybut powtarzalny imie dla klasy Kurier  (List String)
     *                      {@link ServiceTechnician#firstName}             -> Atrybut powtarzalny imie dla klasy Serwisant  (List String)
     *                      {@link Client#phoneNumber}                      -> Atrybut powtarzalny numerTelefonu dla klasy Klient  (List String)
     *                      {@link Courier#phoneNumber}                     -> Atrybut powtarzalny numerTelefonu dla klasy Kurier  (List String)
     *                      {@link ServiceTechnician#phoneNumber}           -> Atrybut powtarzalny numerTelefonu dla klasy Serwisant  (List String)
     * Atrybut pochodny,    {@link Courier#salaryBrutto}                    -> Atrybut pochodny wynagordzenieBrutto dla klasy Kurier    (float)
     *                      {@link Courier#getGrossSalary()}                -> Metoda obiektu, ktora automatycznie wylicza wynagrodzenie objektowi Kurier (@return float)
     *                      {@link ServiceTechnician#salaryBrutto}          -> Atrybut pochodny wynagordzenieBrutto dla klasy Serwisant (float)
     *                      {@link ServiceTechnician#getGrossSalary()}      -> Metoda obiektu, ktora automatycznie wylicza wynagrodzenie objektowi Kurier (@return float)
     * Metoda klasowa,      {@link Order#numberOfOrders()}                  -> Metoda klasowa obliczIloscZamowien(), ktora wylicza dla calej danej klasy ilosc zamowien
     *                      {@link Order#numberOfOrders(State)}             -> Metoda klasowa obliczIloscZamowien(stan), ktora wylicza dla calej danej klasy ilosc zamowien dla danego stanu
     * Przesłoniecie,       {@link Order#writeExtent(ObjectOutputStream)}   -> Metoda writeExtent(ObjectOutputStream) z interfejsu Serializable jest przeslonieta przez ta sama metode w klasie Zamowienie
     *                      {@link Order#readExtent(ObjectInputStream)}     -> Metoda readExtent(ObjectInputStream) z interfejsu Serializable jest przeslonieta przez ta sama metode w klasie Zamowienie
     *                      {@link Order#toString()}                        -> Metoda toString() z klasy String jest przeslonieta przez ta sama metode w klasie Zamowienie
     * Przeciazenie,        {@link Order#numberOfOrders()}                  -> Metoda klasowa obliczIloscZamowien() z Zamowienie jest przeciazona przez metode obliczIloscZamowien(stan) w klasie Zamowienie
     *                      {@link Order#numberOfOrders(State)}             -> Metoda klasowa obliczIloscZamowien(stan) z Zamowienie jest przeciazona przez metode obliczIloscZamowien() w klasie Zamowienie
     */
    private static final String FILE_PATH = "C:\\Users\\Mati\\Desktop\\MAS\\MAS_ext.ser";

    public static void main(String[] args) {
        boolean choice = true;
        while(choice){  // dopoki uzytkownik nie poda poprawnej liczby w konsoli
            try{
                String line = showConsoleInterface();   // pokaze banalny konsolowy "interfejs" (zrobione glownie, zeby pokazac, ze klasy sa zapisywane)
                if(line.equals("1")){
                    createTemplateData();   // pare przykladowych stworzonych klas dla demonstracji dzialania programu
                    saveSerialization();    // zapisywanie wszystkich klas do jednego pliku za pomoca Serializacji
                    choice = false;
                }
                else if(line.equals("2")) choice = false;
                else System.err.println("Nie ma takiego numeru w liscie.\n");
            }
            catch (IOException e){ e.printStackTrace(); }
        }

        try{ loadSerialization(); } // zaladowanie wszystkich klas z pliku MAS_ext.ser
        catch(IOException | ClassNotFoundException e){ e.printStackTrace(); }

        showSerialization();    // zczytanie danych klas do konsoli

        System.out.println("Metody: \n" +   // przykladowe uzycie metody klasy, aby upewnic sie dzialanie programu
                "-> Metoda do obliczania ilosci zamowien: "+Order.numberOfOrders()+"\n"+
                "-> Metoda do obliczania ilosci zamowien z danym statusem: "+State.zlozona+" -> "+Order.numberOfOrders(State.zlozona)+"\n");

    }

    public static String showConsoleInterface() throws IOException {
        System.out.println("Witaj w systemie wypozyczania RTV:\n" +
                "1. Wprowadz do systemu przygotowany szablon i zczytaj je\n" +
                "2. Zczytaj juz zapisane klasy z pliku MAS_ext.ser\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void saveSerialization() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        Order.writeExtent(out);
        Client.writeExtent(out);
        Courier.writeExtent(out);
        ServiceTechnician.writeExtent(out);
        out.close();
    }

    public static void showSerialization() {
        Order.showExtent();
        Client.showExtent();
        Courier.showExtent();
        ServiceTechnician.showExtent();
    }

    public static void loadSerialization() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Order.readExtent(in);
        Client.readExtent(in);
        Courier.readExtent(in);
        ServiceTechnician.readExtent(in);
        in.close();
    }

    public static void createTemplateData(){
        Order orderOne = new Order(LocalDate.of(2021, 03,11), LocalDate.of(2021, 03,11), TypeofPayment.kartaplatnicza, new Address("Józkowa",15,28, "Kraków","06-334"), State.zlozona);
        Order orderTwo = new Order(LocalDate.of(2020,04,21), LocalDate.of(2019,03,21), TypeofPayment.PayPal, new Address("Niczyja", 57,15, "Łódź","02-567"), State.wykonana);

        Client clientOne = new Client(Arrays.asList("Krzysztof"), "Krawczyk", Arrays.asList("+42 123456789"), "krzys@gmail.com",new Address("Jackowa",42,24, "Poznaniu","01-224"));
        Client clientTwo = new Client(Arrays.asList("Mateusz", "Michal"), "Bednarek", Arrays.asList("+42 123456789","+42 455445455") ,new Address("Jana Pawla II",21,37, "Warszawa","02-113"));

        Courier courierOne = new Courier(Arrays.asList("Jacek"), "Sieczko", Arrays.asList("+42 123456789"), "jaczko@gmail.com", "980511100118", 1000.53f, "4444/22/55555");
        Courier courierTwo = new Courier(Arrays.asList("Szymon","Milosz"), "Kwiatkowski", Arrays.asList("+42 987654321"), "11111111111", 2000.26f, "2222/33/111111");

        ServiceTechnician serviceTechnicianOne = new ServiceTechnician(Arrays.asList("Piotr"), "Strzala", Arrays.asList("+42 222222222"), "pstrzala@wp.pl", "12332112322", 6000.33f, Title.inzynier, Arrays.asList("certyfikat AWS","certyfikat Cisco"));
        ServiceTechnician serviceTechnicianTwo = new ServiceTechnician(Arrays.asList("Adam", "Kuba"), "Brudka", Arrays.asList("+42 333333333","+42 444444444"), "99999999988", 6000.53f, Title.technik, Arrays.asList("certyfikat Cisco"));
    }
}