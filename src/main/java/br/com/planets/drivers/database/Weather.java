package br.com.planets.drivers.database;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Rogério Alves
 */
@Data
@Entity(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "day")
    private Integer day;

    @Column(name = "weather")
    private String weather;
}
