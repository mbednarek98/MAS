package MAS;

import MAS.classes.*;
import MAS.classes.Console;
import MAS.restrictions.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    /** MiniProjekt 2            MAIN
     * Skladowe:                Linki:
     * Asocjacja 1-*            -> {@link Courier#addOrder(Order)}
     *                          -> {@link Order#setCourier(Courier)}
     * Asocjacja z atrubytem    -> {@link DeviceService#setConsole(Console)}
     *                          -> {@link DeviceService#setServiceTechnician(ServiceTechnician)}
     * Asocjacja kwalifikowana  -> {@link Order#addConsoleQualif(Console)}
     *                          -> {@link Order#deleteConsole(String)}
     * Kompozycja               -> {@link Order#createOrder(Client, LocalDate, LocalDate, TypeofPayment, Address, State)}
     *
     * W kazdym przypadku:
     *      -> liczność jeden do wielu lub wiele do wiele
     *      -> automatyczne tworzenie połoczenia zwrotnego
     */
    public static void main(String[] args) throws Exception {
        Client clientOne = new Client(Arrays.asList("Krzysztof"), "Krawczyk", Arrays.asList("+42 123456789"), "krzys@gmail.com",new Address("Jackowa",42,24, "Poznaniu","01-224"));
        // kompozycja dodawanie
        Order orderOne = Order.createOrder(clientOne,LocalDate.of(2021, 03,11), LocalDate.of(2021, 03,11), TypeofPayment.kartaplatnicza, new Address("Józkowa",15,28, "Kraków","06-334"), State.zlozona);
        Order orderTwo = Order.createOrder(clientOne,LocalDate.of(2021, 03,11), LocalDate.of(2021, 03,11), TypeofPayment.kartaplatnicza, new Address("Józkowa",15,28, "Kraków","06-334"), State.zlozona);



        // ----- One to Many Association ------
        Courier courierOne = new Courier(Arrays.asList("Jacek"), "Sieczko", Arrays.asList("+42 123456789"), "jaczko@gmail.com", "980511100118", 1000.53f, "4444/22/55555");
        Courier courierTwo = new Courier(Arrays.asList("Szymon","Milosz"), "Kwiatkowski", Arrays.asList("+42 987654321"), "11111111111", 2000.26f, "2222/33/111111");
//        //dodawanie
//        courierTwo.addOrder(orderOne);
//        courierTwo.addOrder(orderTwo);
//        System.out.println(courierOne);
//        System.out.println(courierTwo);
//        //usuwanie
//        courierTwo.deleteOrder(orderOne);
//        System.out.println(courierTwo);


        // ------------------------------------

        // --- Association With Attribute -----
        Console conTwo = new Console("Ja/333.cek",2.3f,"xklocek 360",214.55);
        ServiceTechnician serviceTechnicianOne = new ServiceTechnician(Arrays.asList("Piotr"), "Strzala", Arrays.asList("+42 222222222"), "pstrzala@wp.pl", "12332112322", 6000.33f, Title.inzynier, Arrays.asList("certyfikat AWS","certyfikat Cisco"));
        DeviceService serviceOne = new DeviceService( LocalDate.of(2021, 03,11),Condition.wtrakcie);
//        //dodawanie
//        conTwo.setDeviceService(serviceOne);
//        serviceTechnicianOne.setDeviceService(serviceOne);
//        System.out.println(serviceOne);
//        //usuwanie
//        System.out.println(serviceOne);
//        serviceTechnicianOne.deleteDeviceService(serviceOne);
//        System.out.println(serviceOne);
//        conTwo.deleteDeviceService(serviceOne);
//        System.out.println(serviceOne);
        // ------------------------------------

        // ------ Qualified Association -------
        Console conOne = new Console("Ja/123.ek",2.3f,"PS5",214.55);
//        //dodanie
//        orderOne.addConsoleQualif(conOne);
//        System.out.println(orderOne.findConsoleQualif(conOne.getIdNumber()));
//        //usuwanie
//        orderOne.deleteConsole(conOne.getIdNumber());
//        System.out.println(orderOne.findConsoleQualif(conOne.getIdNumber()));

        // ------------------------------------

        // ---------- Composition -------------
        //usuwanie
        System.out.println(clientOne);
        Client.deleteClient(clientOne);
        System.out.println(clientOne);  // w Jave nie mozemy manualnie usunac obiektu
        // ------------------------------------
    }

}