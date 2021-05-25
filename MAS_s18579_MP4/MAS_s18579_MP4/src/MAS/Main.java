package MAS;

import MAS.Classes.*;
import MAS.Classes.Enum.Condition;
import MAS.Classes.Enum.State;
import MAS.Classes.Enum.Title;
import MAS.Classes.Enum.ToP;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
	    // -- Ogr. atrybutu --
        System.out.println("====================");
        Client clt1 = new Client("Szymon","Sieczko",new Address("Jaculkowa",16,26,"Warszawa","02-777"),20);
        //clt1.setAge(16);
        clt1.setAge(24);

        Order ord1 = new Order(LocalDate.now(),LocalDate.now().plusDays(2), ToP.kartaplatnicza,new Address("Jaculkowa",16,26,"Warszawa","02-777"), State.wtrakcie);
        //ord1.setDeliveryDate(LocalDate.now().minusDays(2));



        // -- Ogr. unique --
        System.out.println("====================");
        Device dev1 = new Device("11/22/3333", "PS5", 12.34, "spec1");
        //Device dev2 = new Device("11/22/3333", "PS5", 12.34, "spec1");

        //dev1.setIdNumber("11/22/3333");
        dev1.setIdNumber("12/22/3333");


        // -- Ogr. subset --
        System.out.println("====================");
        Service s1 = new Service(LocalDate.now(), Condition.nowy);
        ServiceTechnician st1 = new ServiceTechnician("Jacek","Placek",20.56, Title.doktor, Arrays.asList("qual1"));

        st1.linkSubset(s1);
        s1.linkSubset(st1);
        st1.showLinkSubset();
        s1.showManager();
        s1.showWorkers();


        // -- Ogr. ordered --
        System.out.println("====================");
        ServiceTechnician st2 = new ServiceTechnician("Placek","Jacek",21.56, Title.doktor, Arrays.asList("qual1"));
        st1.printExtent();
        st2.printExtent();


        // -- Ogr. bag --
        System.out.println("====================");
        Courier cr2 = new Courier("Milosz","Kwiatkowski",123.5,"11/22/3333");
        Order or2 = new Order(LocalDate.now(),LocalDate.now().plusDays(2),ToP.kartaplatnicza,new Address("Jaculkowa",16,26,"Warszawa","02-777"), State.wtrakcie);
        CourierOrder co1 = new CourierOrder(LocalDate.now(),cr2,or2);
        co1.showLinks();


        // -- Ogr. xor --
        System.out.println("====================");
        clt1.addXORRoles();
        //clt1.addLinkXOROrder(ord1);
        clt1.addLinkXORService(s1);
        // -- Ogr. wlasne --
        cr2.setDrivingLicenceNumber("123456");
        //cr2.setDrivingLicenceNumber("abc");
    }
}
