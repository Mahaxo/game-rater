package pl.coderslab.gamerater.model;

import javax.persistence.*;

@Entity
@Table(name = "platfoms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
