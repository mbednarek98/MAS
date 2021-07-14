package sample.GUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sample.classes.*;
import sample.classes.enums.State;
import sample.classes.enums.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

public class CreateTreatment extends JFrame{
    private JPanel treatmentPanel;
    private JTextField dataField;
    private JTextField typeField;
    private JList vetList;
    private JList animalList;
    private JButton addBtn;
    private JButton payuBtn;
    private JButton blikBtn;
    private JButton cardBtn;
    private JButton moneyBtn;

    public CreateTreatment(String title, Client client) {
        super(title);
        dataField.setText(LocalDate.now().toString());
        ObjectsModel<Animal> modelActor1 = new ObjectsModel<Animal>(getAnimal());
        animalList.setModel(modelActor1);
        animalList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(arg0.getClickCount() == 2) {
                    showAnimal((Animal) animalList.getSelectedValue());
                }
            }
        });

        ObjectsModel<Person> modelActor2 = new ObjectsModel<Person>(getVetClient());
        vetList.setModel(modelActor2);
        vetList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(arg0.getClickCount() == 2) {
                    showVet((Person) vetList.getSelectedValue());
                }
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(treatmentPanel);
        this.pack();
        addBtn.addActionListener(e -> {
            showAnimal();
        });
        payuBtn.addActionListener(e -> {
            Payment newPayment = new Payment("PayU", Status.zlozona, LocalDate.now());
            Animal animal = (Animal) animalList.getSelectedValue();
            Person personVet = (Person) vetList.getSelectedValue();
            Vet vet = getVetById(personVet.getId());
            if(animal != null && vet != null){
                Treatment treatment = new Treatment(LocalDate.now(),typeField.getText(),false, State.nowy);
                treatment.addVet(vet);
                client.addTreatment(treatment);
                animal.addTreatment(treatment);
                treatment.addPayment(newPayment);
                addOnClick(treatment);
                JFrame treatmenSaved = new TreatmentSaved("Zapisano!",personVet,treatment,newPayment);
                treatmenSaved.setVisible(true);
            }
        });
        blikBtn.addActionListener(e -> {
            Payment newPayment = new Payment("BLIK", Status.zlozona, LocalDate.now());
            Animal animal = (Animal) animalList.getSelectedValue();
            Person personVet = (Person) vetList.getSelectedValue();
            Vet vet = getVetById(personVet.getId());
            if(animal != null && vet != null){
                Treatment treatment = new Treatment(LocalDate.now(),typeField.getText(),false, State.nowy);
                treatment.addVet(vet);
                client.addTreatment(treatment);
                animal.addTreatment(treatment);
                treatment.addPayment(newPayment);
                addOnClick(treatment);
                JFrame treatmenSaved = new TreatmentSaved("Zapisano!",personVet,treatment,newPayment);
                treatmenSaved.setVisible(true);
            }
        });
        cardBtn.addActionListener(e -> {
            Payment newPayment = new Payment("Card", Status.zlozona, LocalDate.now());
            Animal animal = (Animal) animalList.getSelectedValue();
            Person personVet = (Person) vetList.getSelectedValue();
            Vet vet = getVetById(personVet.getId());
            if(animal != null && vet != null){
                Treatment treatment = new Treatment(LocalDate.now(),typeField.getText(),false, State.nowy);
                treatment.addVet(vet);
                client.addTreatment(treatment);
                animal.addTreatment(treatment);
                treatment.addPayment(newPayment);
                addOnClick(treatment);
                JFrame treatmenSaved = new TreatmentSaved("Zapisano!",personVet,treatment,newPayment);
                treatmenSaved.setVisible(true);
            }
        });
        moneyBtn.addActionListener(e -> {
            Payment newPayment = new Payment("Gotowka", Status.zlozona, LocalDate.now());
            Animal animal = (Animal) animalList.getSelectedValue();
            Person personVet = (Person) vetList.getSelectedValue();
            Vet vet = getVetById(personVet.getId());
            if(animal != null && vet != null){
                Treatment treatment = new Treatment(LocalDate.now(),typeField.getText(),false, State.nowy);
                treatment.addVet(vet);
                client.addTreatment(treatment);
                animal.addTreatment(treatment);
                treatment.addPayment(newPayment);
                addOnClick(treatment);
                JFrame treatmenSaved = new TreatmentSaved("Zapisano!",personVet,treatment,newPayment);
                treatmenSaved.setVisible(true);
            }
        });
    }


    private void showAnimal(Animal animal){
        JFrame cc = new ShowAnimal(animal.toString(), animal, this);
        cc.setVisible(true);
    }

    private void showAnimal(){
        JFrame cc = new ShowAnimal("Nowy zwierzak", this);
        cc.setVisible(true);
    }

    private void showVet(Person person){
        Vet vet = getVetById(person.getId());
        JFrame cc = new ShowVet(person.toString(), person, vet );
        cc.setVisible(true);
    }

    private void addOnClick(Treatment treatment){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(treatment);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
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

    public List<Animal> getAnimal(){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        List<Animal> animalDB = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            animalDB = session.createQuery( "FROM Animal" ).list();
            System.out.println(animalDB);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
        ObjectsModel<Animal> modelActor1 = new ObjectsModel<Animal>(animalDB);
        animalList.setModel(modelActor1);
        return animalDB;
    }

    public List<Person> getVetClient(){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        List<Person> personDB = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            personDB = session.createQuery( "SELECT p FROM Person p inner join p.vet" ).list();
            System.out.println(personDB);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
        return personDB;
    }

    private Vet getVetById(long id){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        List<Vet> cltDB = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            cltDB = session.createQuery( "SELECT p.vet FROM Person p inner join p.vet WHERE p.id="+(int)id ).list();
            System.out.println(cltDB);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
        return cltDB.get(0);
    }
}
