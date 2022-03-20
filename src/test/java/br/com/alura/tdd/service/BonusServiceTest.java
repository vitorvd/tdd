package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("25000"))));

        /** Usado geralmente para capturar as mensagens de erros do Try/Catch. **/
//        try{
//            service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("25000")));
//            fail("Não deu o Exception!"); //Logo o teste falhou. Para forçar esse caso, comente o throw na BonusService.
//        }catch (Exception e) {
//            assertEquals("Funcionário com salário maior do que R$ 10.000,00 reais não pode receber bônus.", e.getMessage());
//        }

    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
