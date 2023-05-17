package br.com.api.residencia.calculadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.residencia.calculadora.domains.Calculadora;


@Repository
public interface CalculadoraRepository extends JpaRepository<Calculadora, Integer> {

}