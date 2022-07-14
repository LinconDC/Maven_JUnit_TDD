package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void acimaDeMilBonusZero() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(
				new Funcionario("Rodrigo", LocalDate.now(), 
				new BigDecimal("25000")));
		
		
		assertEquals(BigDecimal.ZERO, bonus);
	}
	
	@Test
	void bonusDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(
				new Funcionario("Rodrigo", LocalDate.now(), 
				new BigDecimal("2500")));
		
		
		assertEquals(new BigDecimal("250"), bonus);
	}

}
