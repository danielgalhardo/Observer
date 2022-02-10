import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class ClienteTest {

    @Test
    void deveNotificarPrimeiroDaFila() throws Exception {
        FilaBanco fila = new FilaBanco();
        Cliente daniel = new Cliente("Daniel");
        daniel.entrarFila(fila);
        fila.encontraPosicaoDoCliente(daniel);
        assertEquals("Daniel,sua posicao na fila eh 1", daniel.getPosicao(fila));
    }

    @Test
    void deveRetornarTotalClientesNaFila()
    {
        FilaBanco fila = new FilaBanco();
        Cliente daniel = new Cliente("Daniel");
        Cliente maria = new Cliente("maria");
        Cliente joao = new Cliente("joao");
        daniel.entrarFila(fila);
        maria.entrarFila(fila);
        joao.entrarFila(fila);
        assertEquals(3, fila.getQuantidadeClientes());
    }

    @Test
    void deveRetornarTotalClientesNaFilaComRemocao()
    {
        FilaBanco fila = new FilaBanco();
        Cliente daniel = new Cliente("Daniel");
        Cliente maria = new Cliente("maria");
        Cliente joao = new Cliente("joao");
        daniel.entrarFila(fila);
        maria.entrarFila(fila);
        joao.entrarFila(fila);
        assertEquals(3, fila.getQuantidadeClientes());
        maria.sairFila(fila);
        assertEquals(2, fila.getQuantidadeClientes());
    }


    @Test
    void deveNotificarTodosOsClientes() throws Exception {
        FilaBanco fila = new FilaBanco();
        Cliente daniel = new Cliente("Daniel");
        Cliente maria = new Cliente("Maria");
        Cliente joao = new Cliente("Joao");
        daniel.entrarFila(fila);
        maria.entrarFila(fila);
        joao.entrarFila(fila);
        fila.encontraPosicaoDoCliente(daniel);
        assertEquals("Daniel,sua posicao na fila eh 1", daniel.getPosicao(fila));
        fila.encontraPosicaoDoCliente(maria);
        assertEquals("Maria,sua posicao na fila eh 2", maria.getPosicao(fila));
        maria.sairFila(fila);
        fila.encontraPosicaoDoCliente(joao);
        assertEquals("Joao,sua posicao na fila eh 2", joao.getPosicao(fila));
    }


    @Test
    void naoDeveNotificar() throws Exception {
        FilaBanco fila = new FilaBanco();
        Cliente daniel = new Cliente("Daniel");
        Cliente maria = new Cliente("Maria");
        Cliente joao = new Cliente("Joao");
        Cliente marcio = new Cliente("Marcio");
        daniel.entrarFila(fila);
        maria.entrarFila(fila);
        joao.entrarFila(fila);
        fila.encontraPosicaoDoCliente(daniel);
        assertEquals("Daniel,sua posicao na fila eh 1", daniel.getPosicao(fila));
        fila.encontraPosicaoDoCliente(maria);
        assertEquals("Maria,sua posicao na fila eh 2", maria.getPosicao(fila));
        fila.encontraPosicaoDoCliente(joao);
        assertEquals("Joao,sua posicao na fila eh 3", joao.getPosicao(fila));
        fila.encontraPosicaoDoCliente(marcio);
        assertNull(marcio.getPosicao(fila));
    }

}
