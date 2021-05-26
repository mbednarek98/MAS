package MAS;

import MAS.Classes.Client;
import MAS.Classes.Courier;
import MAS.Classes.Device;
import MAS.Classes.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            System.out.println("Created clients:");
            Client client1 = new Client("ul. Jerzego Zaruby 17/29","Adam","Brodka","123456789");
            Client client2 = new Client("ul. Parzeczewska 43","Szymon","Sieczko","987654321");
            System.out.println(client1);
            System.out.println(client2);


            System.out.println("Created reservations:");
            Reservation reservation1 = new Reservation(LocalDate.now(),LocalDate.now(), Reservation.TypeOfPayment.Paypal, Reservation.State.Wykonana);
            Reservation reservation2 = new Reservation(LocalDate.now(),LocalDate.now(), Reservation.TypeOfPayment.Przelew, Reservation.State.Anulowana);
            System.out.println(reservation1);
            System.out.println(reservation2);

            System.out.println("Created cevices:");
            Device device1 = new Device("PS5", 12.23);
            Device device2 = new Device("XBOX SERIES X", 32.21);
            System.out.println(device1);
            System.out.println(device2);

            System.out.println("Created couriers:");
            Courier courier1 = new Courier("12345678999", 12.23,"Jacek","Kwiatkowski","123456789");
            Courier courier2 = new Courier("99999999999", 22.22,"Pawel","Molenda","765421234");
            System.out.println(courier1);
            System.out.println(courier2);

            client1.addReservation(reservation1);
            client1.addReservation(reservation2);

            device1.addReservation(reservation1);
            device1.addReservation(reservation2);

            courier1.addReservation(reservation1);
            courier1.addReservation(reservation2);


            System.out.println("===========================");
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(client1);
            session.save(client2);
            session.save(reservation1);
            session.save(reservation2);
            session.save(device1);
            session.save(device2);
            session.save(courier1);
            session.save(courier2);
            session.getTransaction().commit();
            session.close();



            System.out.println("\nMovies and actors from the db:");

            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Client> clientFormDB = session.createQuery( "from Client" ).list();
            System.out.println("Clients:\n");
            for (Client client : clientFormDB) System.out.println(client);

            List<Reservation> reservationFormDB = session.createQuery( "from Reservation" ).list();
            System.out.println("Orders:\n");
            for (Reservation reservation : reservationFormDB) System.out.println(reservation);

            List<Courier> courierFormDB = session.createQuery( "from Courier" ).list();
            System.out.println("Courier:\n");
            for (Courier courier : courierFormDB) System.out.println(courier);

            List<Device> deviceFormDB = session.createQuery( "from Device" ).list();
            System.out.println("Devices:\n");
            for (Device device : deviceFormDB) System.out.println(device);

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
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