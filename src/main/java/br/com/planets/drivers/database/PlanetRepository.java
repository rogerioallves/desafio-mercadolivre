package br.com.planets.drivers.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rogério Alves
 */
@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
