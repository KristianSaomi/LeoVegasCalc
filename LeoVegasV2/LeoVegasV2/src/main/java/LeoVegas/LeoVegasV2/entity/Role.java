package LeoVegas.LeoVegasV2.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String name;

    //En Constructor varsin - id

    public Role(String name) {
        this.name = name;
    }
    public Role(Long id) {
        this.id = id;
    }

    //En Default constructor som hypernate kräver
    public Role() {
        //Empty Constructor for hypernate
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
