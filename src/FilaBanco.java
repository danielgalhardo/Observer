import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class FilaBanco extends Observable {

    private List<Cliente> listaClientes;
    private int quantidadeClientes;
    private int posicao;

    public FilaBanco()
    {
        quantidadeClientes = 0;
        posicao = 0;
        listaClientes = new ArrayList<Cliente>();
    }

    public void adicionarClienteFila(Cliente novoCliente)
    {

        listaClientes.add(novoCliente);
        quantidadeClientes = listaClientes.size();
        setChanged();
        notifyObservers();

    }

    public void retirarClienteFila(Cliente clienteAtendido)
    {
        listaClientes.remove(clienteAtendido);
        quantidadeClientes = listaClientes.size();
        setChanged();
        notifyObservers();
    }

    public int getQuantidadeClientes() {
        return quantidadeClientes;
    }

    public void setQuantidadeClientes(int quantidadeClientes) {
        this.quantidadeClientes = quantidadeClientes;
    }

    public void encontraPosicaoDoCliente(Cliente cliente) throws Exception {

        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).getNome() == cliente.getNome())
            {
               posicao = i + 1;
            }
        }
        setChanged();
        notifyObservers();
    }



    @Override
    public String toString() {
        return String.valueOf(posicao);

    }
}

