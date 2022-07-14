package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void acimaDeMilBonusZero() {
		BonusService service = new BonusService();

		 assertThrows(IllegalArgumentException.class,
		 () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new
		 BigDecimal("25000"))));
//		try {
//			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//			fail("Nao deu a exception");
//		} catch (Exception e) {
//			assertEquals("Funcionario com salario maior do que 10000 nao pode receber bonus", e.getMessage());
//		}

	}

	@Test
	void bonusDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
