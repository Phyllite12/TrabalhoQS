package devapp.upt.trabalhoqs.ClassesObjetos;

public class Material
{
    private int cod; //Código do material
    private String tipo; //Tipo do material
    private String descricao; //Descrição do Material
    private int nUnidades;//Número de unidades existentes
    private String disponibilidade; //Estado de disponibilidade

    public Material(int cod, String tipo, String descricao, int nUnidades, String disponibilidade)
    {
        this.cod = cod;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nUnidades = nUnidades;
        this.disponibilidade = disponibilidade;
    }

    public Material() {
        this.cod = 0;
        this.tipo = "";
        this.descricao = "";
        this.nUnidades = 0;
        this.disponibilidade = "";
    }

    public int getCod() {
        return cod;
    }

    public String getTipo() {
        return tipo;
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

    public String isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
