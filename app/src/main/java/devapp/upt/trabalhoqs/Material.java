package devapp.upt.trabalhoqs;

public class Material
{
    private int cod; //Código do material
    private String tipo; //Tipo do material
    private String descricao; //Descrição do Material
    private int nUnidades;//Número de unidades existentes
    private boolean disponibilidade; //Estado de disponibilidade

    public Material(int cod, String tipo, String descricao, int nUnidades)
    {
        this.cod = cod;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nUnidades = nUnidades;
        this.disponibilidade = true;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getnUnidades() {
        return nUnidades;
    }

    public void setnUnidades(int nUnidades) {
        this.nUnidades = nUnidades;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Material{" +
                "cod=" + cod +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", nUnidades=" + nUnidades +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
