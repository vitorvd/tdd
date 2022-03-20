package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Vitor", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, DesempenhoEnum.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Vitor", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, DesempenhoEnum.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Vitor", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, DesempenhoEnum.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }


}
