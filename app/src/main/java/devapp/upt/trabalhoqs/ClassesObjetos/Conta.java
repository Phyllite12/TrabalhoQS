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

    /*
    Inicialização das variàveis
     */
    public Conta() {
        this.nome = "";
        this.num = 0;
        this.pass = "";
        this.tipo = "";
        this.perm = 0;
    }

    /*
    Devolve o nome do utilizador.
     */
    public String getNome() {
        return nome;
    }

    /*
    Devolve o número do utilizador.
     */
    public int getNum() {
        return num;
    }

    /*
    Devolve a password do utilizador.
     */
    public String getPass() {
        return pass;
    }

    /*
    Devolve o tipo de utilizador.
     */
    public String getTipo() {
        return tipo;
    }

    /*
    Define o nome do utilizador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
    Define o número do utilizador.
     */
    public void setNum(int num) {
        this.num = num;
    }

    /*
    Define a password do utilizador.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /*
    Define o tipo do utilizador.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*
    Devolve o tipo de permissão do utilizador.
     */
    public int getPerm() {
        return perm;
    }

    /*
    Define o tipo de permissão do utilizador.
     */
    public void setPerm(int perm) {
        this.perm = perm;
    }
}