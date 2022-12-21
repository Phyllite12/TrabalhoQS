package devapp.upt.trabalhoqs;

public class Conta {

    private String nome;
    private int num;
    private String pass;
    private String tipo;

    public Conta(String nome, int num, String pass, String tipo) {
        this.nome = nome;
        this.num = num;
        this.pass = pass;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getNum() {
        return num;
    }

    public String getPass() {
        return pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
