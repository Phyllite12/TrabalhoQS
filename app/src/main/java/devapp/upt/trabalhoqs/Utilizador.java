package devapp.upt.trabalhoqs;

public class Utilizador {

    String nome;
    int numero;
    String password;

    public Utilizador(String nome, int numero, String password) {
        this.nome = nome;
        this.numero = numero;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", password='" + password + '\'' +
                '}';
    }
}
