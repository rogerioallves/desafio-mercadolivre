package br.com.planets.controller;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Rogério Alves
 */
@Getter
@Builder
public class CalculateWeatherResponse {
    private Integer dia;
    private String clima;
}
