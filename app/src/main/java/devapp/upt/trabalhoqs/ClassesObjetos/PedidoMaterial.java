package devapp.upt.trabalhoqs.ClassesObjetos;

public class PedidoMaterial {

    private int pedidoCod;
    private int cod;
    private int quantidade;
    private int codProf;

    /*

     */
    public PedidoMaterial(int cod, int quantidade, int codProf) {
        this.cod = cod;
        this.quantidade = quantidade;
        this.codProf = codProf;
    }

    /*
    Inicialização das variàveis.
     */
    public PedidoMaterial() {
        this.pedidoCod = 0;
        this.cod = 0;
        this.quantidade = 0;
        this.codProf = 0;
    }

    /*
    Devolve código do pedido.
     */
    public int getPedidoCod() {
        return pedidoCod;
    }

    /*
    Devolve o código.
     */
    public int getCod() {
        return cod;
    }

    /*
    Devolve a quantidade de materiais solicitados.
     */
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

    /*
    Devolve código do professor que solicitou os materiais.
     */
    public int getcodProf() {
        return codProf;
    }

    public void setcodProf(int codProf) {
        this.codProf = codProf;
    }
}
