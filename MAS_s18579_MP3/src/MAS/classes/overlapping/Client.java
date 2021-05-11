package MAS.classes.overlapping;

import MAS.classes.overlapping.Address;
import MAS.object.ObjectPlusPlus;

public class Client extends ObjectPlusPlus {
    // -- Atrybuty klasy --
    private Address residanceAddress;                    // adresZamieszkania

    // -- Konstruktory --
    public Client(Address residanceAddress){
        super();
        this.residanceAddress = residanceAddress;
    }

    // -- Getter --

    public Address getResidanceAddress() {
        return residanceAddress;
    }


    // -- Setter --

    public void setResidanceAddress(Address residanceAddress) {
        this.residanceAddress = residanceAddress;
    }

    @Override
    public String toString() {
        return super.toString()+"Klasa Klient\n"+
                "-> Adres zamieszkania:\t\n" + residanceAddress + ",\n";
    }
}
