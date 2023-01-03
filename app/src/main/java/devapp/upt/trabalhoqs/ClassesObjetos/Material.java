package devapp.upt.trabalhoqs.ClassesObjetos;

public class Material {
    private int cod; //Código do material
    private String tipo; //Tipo do material
    private String descricao; //Descrição do Material
    private int nUnidades;//Número de unidades existentes
    private String disponibilidade; //Estado de disponibilidade

    public Material(int cod, String tipo, String descricao, int nUnidades, String disponibilidade) {
        this.cod = cod;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nUnidades = nUnidades;
        this.disponibilidade = disponibilidade;
    }

    /*
    Inicialização das variàveis.
     */
    public Material() {
        this.cod = 0;
        this.tipo = "";
        this.descricao = "";
        this.nUnidades = 0;
        this.disponibilidade = "";
    }

    /*
    Devolve o código do material.
     */
    public int getCod() {
        return cod;
    }

    /*
    Devolve o tipo do material.
     */
    public String getTipo() {
        return tipo;
    }

    /*
    Devolve a descrição do material.
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*
    Devolve o número de unidades de cada material.
     */
    public int getnUnidades() {
        return nUnidades;
    }

    public void setnUnidades(int nUnidades) {
        this.nUnidades = nUnidades;
    }

    /*
    Devolve a disponibilidade do material.
     */
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

    /*
    É devolvido o material com a sua descrição.
     */
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
