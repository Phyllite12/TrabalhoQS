package devapp.upt.trabalhoqs.ClassesObjetos;

public class PedidoMaterial {

    private int pedidoCod;
    private int cod;
    private int quantidade;
    private int codProf;

    public PedidoMaterial(int pedidoCod, int cod, int quantidade, int codProf) {
        this.pedidoCod = pedidoCod;
        this.cod = cod;
        this.quantidade = quantidade;
        this.codProf = codProf;
    }

    public PedidoMaterial() {
        this.pedidoCod = 0;
        this.cod = 0;
        this.quantidade = 0;
        this.codProf = 0;
    }

    public int getPedidoCod() {
        return pedidoCod;
    }

    public int getCod() {
        return cod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPedidoCod(int pedidoCod) {
        this.pedidoCod = pedidoCod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getcodProf() {
        return codProf;
    }

    public void setcodProf(int codProf) {
        this.codProf = codProf;
    }
}
