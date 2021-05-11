package MAS;

import MAS.classes.dynamic.*;
import MAS.classes.dynamic.Employee;
import MAS.classes.multiple.aspect.Computer;
import MAS.classes.multiple.aspect.VR;
import MAS.classes.multiple.inheritance.AllInOne;
import MAS.classes.overlapping.*;

import java.util.Arrays;

public class Main {
    /** MiniProjekt 3               MAIN
     * Skladowe:                    Linki:
     * Poliformiczne wolanie metod  -> {@link Employee#getSalaryWithBonus()} {@link ServiceTechnician#getSalaryWithBonus()} {@link Courier#getSalaryWithBonus()}
     * Overlapping                  -> {@link User}
     * Wielodziedziczenie           -> {@link AllInOne}
     * Wieloaspektowe               -> {@link MAS.classes.multiple.Device}
     * Dynamiczne                   -> {@link Employee}
     */
    public static void main(String[] args) {
        // -- Dynamiczne --
        Employee emp_1 = new Courier(Arrays.asList("Jacek"),"Sieczko","99999999999",1234.55f,"11/22/333",DriverCat.D);
        Employee emp_2 = new ServiceTechnician(Arrays.asList("Adam"),"Brodka","99999999999",1234.55f,Title.technik,Arrays.asList("qual1","qual2"), 25.55);

        System.out.println(emp_1 + "\n" +emp_2);

        emp_1 =  new ServiceTechnician(emp_1,Title.technik,Arrays.asList("qual1","qual2"), 25);
        emp_2 =  new Courier(emp_2,"22/33/44",DriverCat.A);

        System.out.println(emp_1 + "\n" +emp_2);
        // -- Poliformizm --

        System.out.println(emp_1.getSalaryWithBonus());
        System.out.println(emp_2.getSalaryWithBonus());

        // -- Overlapping --
        User Jacek = new User(Arrays.asList("Jacek"),"Sieczko",Arrays.asList("123456789"),"abc@cbd.pl",new Address("Kwiatkowska",15,29,"Warszawa","02-222"));
        User Adam = new User(Arrays.asList("Adam"),"Brodka",Arrays.asList("987654321"),"abc@gmail.com","99999999999",1234.55f);
        // -- Wielodziedziczenie --

        AllInOne aio = new AllInOne(24.55, 24,"abc","1920x1600", "nvidia gtx 1050", "inteli i7 5490", "asus atx", "ddr4 16gb","plastic",25.55);

        // -- Wieloaspektowe --

        VR vr_1 = new VR(12.22, 25, "szklo");
        VR vr_2 = new VR(12.22, 25.5, "type-C", "plastik");

        System.out.println(vr_1 + "\n" + vr_2);

        vr_1.setTypeOfConnection("cable", "type-C",2.45);
        vr_2.setTypeOfConnection("battery", 25);

        System.out.println(vr_1 + "\n" + vr_2);

    }
}
