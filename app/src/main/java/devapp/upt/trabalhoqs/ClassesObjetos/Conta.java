package devapp.upt.trabalhoqs.ClassesObjetos;

public class Conta {

    private String nome;
    private int num;
    private String pass;
    private String tipo;
    private int perm;

    public Conta(String nome, int num, String pass, String tipo, int perm) {
        this.nome = nome;
        this.num = num;
        this.pass = pass;
        this.tipo = tipo;
        this.perm = perm;
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

    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }
}
