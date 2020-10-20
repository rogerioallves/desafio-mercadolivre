package br.com.planets.drivers.database;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Rogério Alves
 */
@Data
@Entity(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "translation_moviment")
    private String translationMoviment;

    @Column(name = "velocity")
    private Integer velocity;

    @Column(name = "distance_from_sun")
    private Integer distanceFromSun;

    @Column(name = "position_x")
    private Double position_x;

    @Column(name = "position_y")
    private Double position_y;
}
