package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private static ReajusteService service;
    private static Funcionario funcionario;

    /*
    * Outras anotações interessantes:
    * @AfterEach - depois de cada um dos métodos de testes
    * @BeforeAll - antes de TODOS os métodos de testes (O método que conter essa anotação deve ser STATIC)
    * @AfterAll - depois de TODOS os métodos de testes (O método que conter essa anotação deve ser STATIC)
    **/
    @BeforeEach /* Antes de cada um dos métodos de testes, chame esse */
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Vitor", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, DesempenhoEnum.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, DesempenhoEnum.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, DesempenhoEnum.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
