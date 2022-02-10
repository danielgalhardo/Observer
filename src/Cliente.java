import java.util.Observable;
import java.util.Observer;

public class Cliente implements  Observer {

    private String nome;
    private String posicao;



    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getPosicao(FilaBanco fila) throws Exception {
        fila.addObserver(this);
        return posicao;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void entrarFila(FilaBanco fila)
    {
        fila.addObserver(this);
        fila.adicionarClienteFila(this);

    }


    public void sairFila(FilaBanco fila)

    {
        fila.deleteObserver(this);
        fila.retirarClienteFila(this);

    }
    @Override
    public void update(Observable fila, Object arg)
    {
        this.posicao = this.nome + ",sua posicao na fila eh " + fila.toString();

    }
}
