package devapp.upt.trabalhoqs;

import java.util.ArrayList;

public class GerirMaterial
{
    ArrayList<Material> listaM; //Lista Matererias
    ArrayList<Material>listaCons;//Lista Consumiveis
    ArrayList<Material>listaC; //Lista Componentes


    /**
     *
     */
    public GerirMaterial()
    {
        this.listaM = new ArrayList<Material>(); //Lista de materiais
        this.listaCons = new ArrayList<Material>(); //Lista de materiais do tipo consumiveis
        this.listaC = new ArrayList<Material>(); //Lista de materiais do tipo componentes
    }
    public void registarMaterial(Material temp)
    {
        listaM.add(temp);
        if(temp.getTipo().equalsIgnoreCase("Consumiveis"))
        {
            listaCons.add(temp);
        }
        else
        {
            listaC.add(temp);
        }
    }
    public void imprimirListaMateriais()
    {
        for (int i = 0; i < listaM.size(); i++)
        {
            System.out.println(listaM.get(i));
        }
    }
    public void imprimirListaConsumiveis()
    {
        for (int i = 0; i < listaCons.size(); i++)
        {
            System.out.println(listaCons.get(i));
        }
    }
    public void imprimirListaComponentes()
    {
        for (int i = 0; i < listaC.size(); i++)
        {
            System.out.println(listaC.get(i));
        }
    }
    public void pesquisarDispoConsumiveis()
    {
        for (int i = 0; i < listaCons.size(); i++)
        {
            System.out.print(listaCons.get(i).getCod());
            System.out.print(listaCons.get(i).isDisponibilidade());
        }
    }
    public void pesquisarDispoComponentes()
    {
        for (int i = 0; i < listaC.size(); i++)
        {
            System.out.print(listaC.get(i).getCod());
            System.out.print(listaC.get(i).isDisponibilidade());
        }
    }


}
