package table;

import javax.persistence.*;

@Entity
@Table(name="footballer")
public class Footballer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    int idFootballer;
    @ManyToOne
    @JoinColumn(name="club")
    FootballClub fc;
    @Column(name="firstName")
    String firstName;
    @Column(name="lastName")
    String secondName;
    @Column(name="age")
    int age;

    public Footballer (FootballClub fc, String firstName, String secondName, int age){
        this.fc = fc;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Footballer (int idFootballer, FootballClub fc, String firstName, String secondName, int age){
        this.idFootballer = idFootballer;
        this.fc = fc;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Footballer (int idFootballer, String firstName, String secondName, int age){
        this.idFootballer = idFootballer;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Footballer (String firstName, String secondName, int age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Footballer (){
    }

    public int getIdFootballer (){
        return idFootballer;
    }

    public void setIdFootballer (int idFootballer){
        this.idFootballer = idFootballer;
    }

    public String getFirstName (){
        return firstName;
    }

    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    public String getSecondName (){
        return secondName;
    }

    public void setSecondName (String secondName){
        this.secondName = secondName;
    }

    public int getAge (){
        return age;
    }

    public void setAge (int age){
        this.age = age;
    }

    public FootballClub getFc (){
        return fc;
    }

    public void setFc (FootballClub fc){
        this.fc = fc;
    }

    @Override
    public String toString (){
        return  "ID: " + idFootballer + "\n" + "Football Club: " + fc  +"\n" + " First name: " + firstName + " Surname: " + secondName  +" Age: " + age;
    }
}
