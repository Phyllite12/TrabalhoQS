package devapp.upt.trabalhoqs.ClassesObjetos;

public class PedidoAcesso {

    private int cod;
    private String nomeProfessor;
    private int num;

    public PedidoAcesso(String nomeProfessor, int num) {
        this.nomeProfessor = nomeProfessor;
        this.num = num;
    }

    public PedidoAcesso() {
        this.cod = 0;
        this.nomeProfessor = "";
        this.num = 0;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public int getNum() {
        return num;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
