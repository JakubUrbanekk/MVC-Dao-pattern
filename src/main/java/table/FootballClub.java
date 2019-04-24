package table;

import javax.persistence.*;

@Entity
@Table(name="footballclub")
public class FootballClub{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int idFootballClub;
    @Column(name="name")
    String name;
    @Column(name="establishmentYear")
    int establishmentYear;

    public FootballClub (){
    }

    public FootballClub (int idFootballClub, String name, int establishmentYear){
        this.idFootballClub = idFootballClub;
        this.name = name;
        this.establishmentYear = establishmentYear;
    }

    public FootballClub (String name, int establishmentYear){
        this.name = name;
        this.establishmentYear = establishmentYear;
    }

    public int getIdFootballClub (){
        return idFootballClub;
    }

    public void setIdFootballClub (int idFootballClub){
        this.idFootballClub = idFootballClub;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public int getEstablishmentYear (){
        return establishmentYear;
    }

    public void setEstablishmentYear (int establishmentYear){
        this.establishmentYear = establishmentYear;
    }

    @Override
    public String toString (){
        return "ID " + idFootballClub + ", Name: " + name  +"," +  " Year of establishment: " + establishmentYear ;
    }
}
