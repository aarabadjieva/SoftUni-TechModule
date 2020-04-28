package softuni.bandregister.entities;

import javax.persistence.*;


@Entity
@Table(name = "bands")
public class Band {
   private Integer id;
   private String name;
   private String members;
   private double honorarium;
   private String genre;

    public Band(String name, String members, double honorarium, String genre) {
        this.name = name;
        this.members = members;
        this.honorarium = honorarium;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    @Column
    public double getHonorarium() {
        return honorarium;
    }

    public void setHonorarium(double honorarium) {
        this.honorarium = honorarium;
    }

    @Column(nullable = false)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Band() {
    }
}
