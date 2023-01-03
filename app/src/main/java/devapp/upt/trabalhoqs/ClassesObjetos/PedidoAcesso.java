package devapp.upt.trabalhoqs.ClassesObjetos;

public class PedidoAcesso {

    private int cod;
    private String nomeProfessor;
    private int num;

    public PedidoAcesso(String nomeProfessor, int num) {
        this.nomeProfessor = nomeProfessor;
        this.num = num;
    }

    /*
    Incialização das variàveis.
     */
    public PedidoAcesso() {
        this.cod = 0;
        this.nomeProfessor = "";
        this.num = 0;
    }

    /*
    Devolve o nome do professor que solicitou o pedido de acesso ao laboratório.
     */
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    /*
    Devolve número do pedido de acesso.
     */
    public int getNum() {
        return num;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /*
    Devolve código do pedido de acesso.
     */
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
