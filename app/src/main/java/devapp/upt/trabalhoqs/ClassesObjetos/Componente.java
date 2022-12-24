package devapp.upt.trabalhoqs.ClassesObjetos;

public class Componente {

    private int cod;
    private int codMaterial;
    private String descricao; //Descrição do Material
    private int nUnidades;//Número de unidades existentes
    private String disponibilidade; //Estado de disponibilidade

    public Componente(int cod, int codMaterial, String descricao, int nUnidades, String disponibilidade) {
        this.cod = cod;
        this.codMaterial = codMaterial;
        this.descricao = descricao;
        this.nUnidades = nUnidades;
        this.disponibilidade = disponibilidade;
    }

    public Componente() {
        this.cod = 0;
        this.codMaterial = 0;
        this.descricao = "";
        this.nUnidades = 0;
        this.disponibilidade = "";
    }

    public int getCod() {
        return cod;
    }

    public int getCodMaterial() {
        return codMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getnUnidades() {
        return nUnidades;
    }

    public String isDisponibilidade() {
        return disponibilidade;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setnUnidades(int nUnidades) {
        this.nUnidades = nUnidades;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
