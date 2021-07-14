package sample.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sample.classes.*;
import sample.classes.enums.Specialization;
import sample.classes.enums.State;
import sample.classes.enums.Status;
import sample.classes.enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ExampleData {
    public static void setExampleData(){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            /** Przykladowe dane dla adresow */
            System.out.println("Created Addresses:");
            Address address1 = new Address("ul. Jerzego Zaruby", 17, 29, "Warszawa");
            Address address2 = new Address("ul. Parzeczewska", 43, 11, "Zgierz");
            Address address3 = new Address("ul. KEN", 45, 64, "Warszawa");
            Address address4 = new Address("ul. Piekna", 12, 32, "Warszawa");
            System.out.println("-->"+address1 + "\n"+"-->"+address2 + "\n"+"-->"+address3 + "\n"+"-->"+address4 + "\n");

            /** Przykladowe dane dla przydzialow */
            System.out.println("Created Allocations:");
            Allocation allocation1 = new Allocation(LocalDateTime.now().minusMinutes(1), LocalDateTime.now(), LocalDate.now());
            Allocation allocation2 = new Allocation(LocalDateTime.now().minusMinutes(5), LocalDateTime.now(), LocalDate.now());
            Allocation allocation3 = new Allocation(LocalDateTime.now().minusMinutes(20), LocalDateTime.now(), LocalDate.now());
            Allocation allocation4 = new Allocation(LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), LocalDate.now());
            System.out.println("-->"+allocation1 + "\n"+"-->"+allocation2 + "\n"+"-->"+allocation3 + "\n"+"-->"+allocation4 + "\n");

            /** Przykladowe dane dla zwierzat */
            System.out.println("Created Animals:");
            Animal animal1 = new Animal(Type.gad,"gatunek1", "plamki", "Jacek", Arrays.asList("na nasiona"));
            Animal animal2 = new Animal(Type.ssak,"gatunek2", "slepe oko", "Szymon", Arrays.asList("czlowiek"));
            Animal animal3 = new Animal(Type.ptak,"gatunek3", "brak nogi", "Adas", Arrays.asList("nabial"));
            Animal animal4 = new Animal(Type.ryba,"gatunek4", "bez glowy", "Milosz", Arrays.asList("wode"));
            System.out.println("-->"+animal1 + "\n"+"-->"+animal2 + "\n"+"-->"+animal3 + "\n"+"-->"+animal4 + "\n");

            /** Przykladowe dane dla klientow */
            System.out.println("Created Clients:");
            Client client1 = new Client("jacex@gmail.com");
            Client client2 = new Client("szymonex@wp.pl");
            Client client3 = new Client("miloszex@o2.pl");
            Client client4 = new Client("pieknis@gmail.com");
            System.out.println("-->"+client1 + "\n"+"-->"+client2 + "\n"+"-->"+client3 + "\n"+"-->"+client4 + "\n");

            /** Przykladowe dane dla lekow */
            System.out.println("Created Medicines:");
            Medicine medicine1 = new Medicine("typ1", 12, Arrays.asList("sennosc", "nadpobudliwosc"));
            Medicine medicine2 = new Medicine("typ2", 23, Arrays.asList("sennosc"));
            Medicine medicine3 = new Medicine("typ3", 34, Arrays.asList("nadpobudliwosc"));
            Medicine medicine4 = new Medicine("typ4", 45, Arrays.asList("sennosc", "reflux"));
            System.out.println("-->"+medicine1 + "\n"+"-->"+medicine2 + "\n"+"-->"+medicine3 + "\n"+"-->"+medicine4 + "\n");

            /** Przykladowe dane dla platnosci */
            System.out.println("Created Payments:");
            Payment payment1 = new Payment("Blik", Status.zlozona, LocalDate.now());
            Payment payment2 = new Payment("Karta", Status.anulowana, LocalDate.now());
            Payment payment3 = new Payment("Gotowka", Status.wTrakcie, LocalDate.now());
            Payment payment4 = new Payment("PayU", Status.wykonana, LocalDate.now());
            System.out.println("-->"+payment1 + "\n"+"-->"+payment2 + "\n"+"-->"+payment3 + "\n"+"-->"+payment4 + "\n");

            /** Przykladowe dane dla ludzi */
            System.out.println("Created People:");
            Person person1 = new Person("Jacek","Sieczko","123456789");
            Person person2 = new Person("Szymon","Bednarek","987654321");
            Person person3 = new Person("Adam","Brodka","192837465");
            Person person4 = new Person("Jan","Kwiatkowski","102938476");
            Person person5 = new Person("Piotr","Sieczko","123456789");
            Person person6 = new Person("imie6","nazwisko6","987654321");
            Person person7 = new Person("imie7","nazwisko7","192837465");
            Person person8 = new Person("imie8","nazwisko8","102938476");
            Person person9 = new Person("imie9","nazwisko9","123456789");
            Person person10 = new Person("imie10","nazwisko10","987654321");
            Person person11 = new Person("imie11","nazwisko11","192837465");
            Person person12 = new Person("imie12","nazwisko12","102938476");
            System.out.println("-->"+person1 + "\n"+"-->"+person2 + "\n"+"-->"+person3 + "\n"+"-->"+person4 + "\n");

            /** Przykladowe dane dla pokojow */
            System.out.println("Created Rooms:");
            Room room1 = new Room(12, "operacyjny", Arrays.asList("sprzet1", "sprzet2"));
            Room room2 = new Room(13, "badaniowy", Arrays.asList("sprzet3"));
            Room room3 = new Room(14, "wizytowy", Arrays.asList("sprzet4", "sprzet5"));
            Room room4 = new Room(15, "operacyjny", Arrays.asList("sprzet5", "sprzet6"));
            System.out.println("-->"+room1 + "\n"+"-->"+room2 + "\n"+"-->"+room3 + "\n"+"-->"+room4 + "\n");

            /** Przykladowe dane dla chorob */
            System.out.println("Created Sicknesses:");
            Sickness sickness1 = new Sickness("Covid-19",Arrays.asList("dusznosci","goraczka"),"nieuleczalne");
            Sickness sickness2 = new Sickness("Swinka",Arrays.asList("dusznosci","goraczka"),"uleczalne");
            Sickness sickness3 = new Sickness("Gangrena",Arrays.asList("dusznosci","goraczka"),"powrotowe");
            Sickness sickness4 = new Sickness("Grypa",Arrays.asList("dusznosci","goraczka"),"uleczalne");
            System.out.println("-->"+sickness1 + "\n"+"-->"+sickness2 + "\n"+"-->"+sickness3 + "\n"+"-->"+sickness4 + "\n");

            /** Przykladowe dane dla zabiegow */
            System.out.println("Created Treatments:");
            Treatment treatment1 = new Treatment(LocalDate.now(), "wizyta", false, State.nowy);
            Treatment treatment2 = new Treatment(LocalDate.now().minusDays(5), "operacja", true, State.wTrakcie);
            Treatment treatment3 = new Treatment(LocalDate.now().minusDays(10), "wizyta", false, State.przyjety);
            Treatment treatment4 = new Treatment(LocalDate.now().minusDays(15), "wizyta", false, State.wykonany);
            System.out.println("-->"+treatment1 + "\n"+"-->"+treatment2 + "\n"+"-->"+treatment3 + "\n"+"-->"+treatment4 + "\n");

            /** Przykladowe dane dla weterynarzy */
            System.out.println("Created Vets:");
            Vet vet1 = new Vet("12345678900", 12.1, Specialization.ChorobyPsowIKotow, "kwalifikacja1");
            Vet vet2 = new Vet("00987654321", 12.1, Specialization.ChirurgiaWeterynaryjna, "kwalifikacja2");
            Vet vet3 = new Vet("11111111111", 12.1, Specialization.ChorobyDrobiuOrazPtakowOzdobnych, "kwalifikacja3");
            Vet vet4 = new Vet("22222222222", 12.1, Specialization.ChorobyZwierzatFuterkowych, "kwalifikacja4");
            System.out.println("-->"+vet1 + "\n"+"-->"+vet2 + "\n"+"-->"+vet3 + "\n"+"-->"+vet4 + "\n");

            /** Przykladowe dane dla pielegniarek */
            System.out.println("Created VetNurses:");
            VetNurse vetnurse1 = new VetNurse("00000000000", 12.1,5,200);
            VetNurse vetnurse2 = new VetNurse("99999999999", 12.1,5,200);
            VetNurse vetnurse3 = new VetNurse("88888888888", 12.1,5,200);
            VetNurse vetnurse4 = new VetNurse("77777777777", 12.1,5,200);
            System.out.println("-->"+vetnurse1 + "\n"+"-->"+vetnurse2 + "\n"+"-->"+vetnurse3 + "\n"+"-->"+vetnurse4 + "\n");

            /** Przykladowe polaczenia */
            System.out.println("Creating new associations\n");
            client1.addAddress(address1);
            client2.addAddress(address2);
            client3.addAddress(address3);
            client4.addAddress(address4);

            client1.addTreatment(treatment1);
            client2.addTreatment(treatment2);
            client3.addTreatment(treatment3);
            client4.addTreatment(treatment4);

            person1.addClient(client1);
            person2.addClient(client2);
            person3.addClient(client3);
            person4.addClient(client4);

            person5.addVet(vet1);
            person6.addVet(vet2);
            person7.addVet(vet3);
            person8.addVet(vet4);

            person9.addVetNurse(vetnurse1);
            person10.addVetNurse(vetnurse2);
            person11.addVetNurse(vetnurse3);
            person12.addVetNurse(vetnurse4);


            treatment1.addMedicine(medicine1);
            treatment2.addMedicine(medicine2);
            treatment2.addMedicine(medicine3);
            treatment3.addMedicine(medicine3);
            treatment4.addMedicine(medicine4);

            treatment1.addRoom(room1);
            treatment2.addRoom(room2);
            treatment3.addRoom(room3);
            treatment4.addRoom(room4);

            treatment1.addAllocation(allocation1);
            treatment1.addAllocation(allocation2);
            treatment2.addAllocation(allocation2);
            treatment3.addAllocation(allocation3);
            treatment4.addAllocation(allocation4);

            treatment1.addVet(vet1);
            treatment1.addVet(vet2);
            treatment2.addVet(vet1);
            treatment3.addVet(vet3);
            treatment4.addVet(vet4);


            treatment1.addPayment(payment1);
            treatment2.addPayment(payment2);
            treatment3.addPayment(payment3);
            treatment4.addPayment(payment4);

            animal1.addSickness(sickness1);
            animal2.addSickness(sickness2);
            animal3.addSickness(sickness3);
            animal4.addSickness(sickness1);
            animal1.addSickness(sickness4);

            animal1.addTreatment(treatment1);
            animal2.addTreatment(treatment2);
            animal3.addTreatment(treatment3);
            animal4.addTreatment(treatment4);

            vetnurse1.addAllocation(allocation1);
            vetnurse2.addAllocation(allocation2);
            vetnurse3.addAllocation(allocation3);
            vetnurse4.addAllocation(allocation4);

            vet1.addTreatment(treatment1);
            vet2.addTreatment(treatment2);
            vet3.addTreatment(treatment3);
            vet4.addTreatment(treatment4);

            System.out.println("Created associations\nSaving to database");
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(address1);
            session.save(address2);
            session.save(address3);
            session.save(address4);

            session.save(allocation1);
            session.save(allocation2);
            session.save(allocation3);
            session.save(allocation4);

            session.save(animal1);
            session.save(animal2);
            session.save(animal3);
            session.save(animal4);

            session.save(client1);
            session.save(client2);
            session.save(client3);
            session.save(client4);

            session.save(medicine1);
            session.save(medicine2);
            session.save(medicine3);
            session.save(medicine4);

            session.save(payment1);
            session.save(payment2);
            session.save(payment3);
            session.save(payment4);

            session.save(person1);
            session.save(person2);
            session.save(person3);
            session.save(person4);

            session.save(sickness1);
            session.save(sickness2);
            session.save(sickness3);
            session.save(sickness4);

            session.save(treatment1);
            session.save(treatment2);
            session.save(treatment3);
            session.save(treatment4);

            session.save(vet1);
            session.save(vet2);
            session.save(vet3);
            session.save(vet4);

            session.save(vetnurse1);
            session.save(vetnurse2);
            session.save(vetnurse3);
            session.save(vetnurse4);
            session.getTransaction().commit();
            System.out.println("Saved!");

            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Client> clientDb = session.createQuery( "from Client" ).list();
            System.out.println(clientDb);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
    }
}
