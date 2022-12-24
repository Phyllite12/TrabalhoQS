package devapp.upt.trabalhoqs.ClassesObjetos;

public class PedidoAcesso {

    private int cod;
    private String nomeProfessor;
    private int num;
    private String comentario;

    public PedidoAcesso(int cod, String nomeProfessor, int num, String comentario) {
        this.cod = cod;
        this.nomeProfessor = nomeProfessor;
        this.num = num;
        this.comentario = comentario;
    }

    public PedidoAcesso() {
        this.cod = 0;
        this.nomeProfessor = "";
        this.num = 0;
        this.comentario = "";
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public int getNum() {
        return num;
    }

    public String getComentario() {
        return comentario;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
