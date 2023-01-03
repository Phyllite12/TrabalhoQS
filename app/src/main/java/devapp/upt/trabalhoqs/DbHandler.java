package devapp.upt.trabalhoqs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.ClassesObjetos.Conta;
import devapp.upt.trabalhoqs.ClassesObjetos.Material;
import devapp.upt.trabalhoqs.ClassesObjetos.PedidoAcesso;
import devapp.upt.trabalhoqs.ClassesObjetos.PedidoMaterial;

public class DbHandler extends SQLiteOpenHelper{

    Context ct;


    /*
    Nome das tabelas.
     */
    public static final String DB_MATERIAL = "Materiais";
    public static final String DB_ACCOUNTS = "Contas";
    public static final String DB_PEDIDOS_ACESSO = "PedidosAcesso";
    public static final String DB_PEDIDOS_MATERIAL = "PedidosMaterial";

    /*
    Tabela Materiais.
    */
    public static final String MCOD = "MCOD";
    public static final String MTIPO = "MTIPO";
    public static final String MDESCRICAO = "MDESCRICAO";
    public static final String MUNIDADES = "MUNIDADES";
    public static final String MDISPONIBILIDADE = "MDISPONIBILIDADE";

    /*
    Tabela Contas.
    */
    public static final String CNOME = "CNOME";
    public static final String CNUM = "CNUM";
    public static final String CPASS = "CPASS";
    public static final String CTIPO = "CTIPO";
    public static final String CPERM = "CPERM";

    /*
    Tabela Pedidos de Acesso.
    */
    public static final String PACOD = "PACOD";
    public static final String PANOMEPROF = "PANOMEPROF";
    public static final String PANUM = "PANUM";

    /*
    Tabela Pedidos de Materiais.
    */
    public static final String PMCOD = "PMCOD";
    public static final String PMCODPRODUTO = "PMCODPRODUTO";
    public static final String PMQUANTIDADE = "PMQUANTIDADE";
    public static final String PMCODPROF = "PMCODPROF";

    /*
    Definições da Base de Dados.
    */
    public static final String DBNAME = "mydatabase";

    private static final int VERSION = 1;

    /*
    Construtor
    */
    public DbHandler(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
        this.ct = context;
    }

    /*

     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryMateriaisTable = String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER, %s TEXT)", DB_MATERIAL, MCOD, MTIPO, MDESCRICAO, MUNIDADES, MDISPONIBILIDADE);
        String queryContasTable = String.format("CREATE TABLE %s( %s TEXT , %s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER)", DB_ACCOUNTS, CNOME, CNUM, CPASS, CTIPO, CPERM);
        String queryPedidosAcessoTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)", DB_PEDIDOS_ACESSO, PACOD, PANOMEPROF, PANUM);
        String queryPedidosMaterialTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s INTEGER, %s INTEGER, %s INTEGER)", DB_PEDIDOS_MATERIAL, PMCOD, PMCODPRODUTO, PMQUANTIDADE, PMCODPROF);
        sqLiteDatabase.execSQL(queryMateriaisTable);
        sqLiteDatabase.execSQL(queryContasTable);
        sqLiteDatabase.execSQL(queryPedidosAcessoTable);
        sqLiteDatabase.execSQL(queryPedidosMaterialTable);
    }

    /*

     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_MATERIAL);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_ACCOUNTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_PEDIDOS_ACESSO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_PEDIDOS_MATERIAL);
        onCreate(sqLiteDatabase);
    }

    /*
    Início Adds.

    Método para adicionar materiais à BD.
     */
    public void addMaterial(Material material) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s','%s');", DB_MATERIAL, MCOD, MTIPO, MDESCRICAO, MUNIDADES, MDISPONIBILIDADE, material.getCod(), material.getTipo(), material.getDescricao(), material.getnUnidades(), material.isDisponibilidade());
        db.execSQL(query);
    }

    /*
    Método para adicionar contas à BD.
     */
    public void addContas(Conta conta) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s','%s');", DB_ACCOUNTS, CNOME, CNUM, CPASS, CTIPO, CPERM, conta.getNome(), conta.getNum(), conta.getPass(), conta.getTipo(), conta.getPerm());
        db.execSQL(query);
    }

    /*
    Método para adicionar pedidos de acesso à BD.
     */
    public void addPedidosAcesso(PedidoAcesso pedidoAcesso) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s) VALUES('%s','%s','%s');", DB_PEDIDOS_ACESSO, PACOD, PANOMEPROF, PANUM, pedidoAcesso.getCod(), pedidoAcesso.getNomeProfessor(), pedidoAcesso.getNum());
        db.execSQL(query);
    }

    /*
    Método para adicionar pedidos de materiais à BD.
     */
    public void addPedidosMaterial(PedidoMaterial pedidoMaterial) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES('%s','%s','%s','%s');", DB_PEDIDOS_MATERIAL, PMCOD, PMCODPRODUTO, PMQUANTIDADE, PMCODPROF, pedidoMaterial.getPedidoCod(), pedidoMaterial.getCod(), pedidoMaterial.getQuantidade(), pedidoMaterial.getcodProf());
        db.execSQL(query);
    }
    /*
    Fim Adds.
     */

    /*
    Início Deletes.
     */
    public void DeleteConta(int num) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_ACCOUNTS, CNUM, num);
        db.execSQL(query);
    }

    public void DeletePedidoAcesso(int cod) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_PEDIDOS_ACESSO, PACOD, cod);
        db.execSQL(query);
    }

    public void DeletePedidoMaterial(int cod) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_PEDIDOS_MATERIAL, PMCOD, cod);
        db.execSQL(query);
    }
    /*
    Fim Deletes.
     */

    /*
    Início Listagens.
     */
    public ArrayList<PedidoAcesso> getPedidosDeAcesso() {
        ArrayList<PedidoAcesso> pedidoAcessos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s", DB_PEDIDOS_ACESSO);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                PedidoAcesso p = new PedidoAcesso();
                p.setCod(cursor.getInt(0));
                p.setNomeProfessor(cursor.getString(1));
                p.setNum(cursor.getInt(2));
                pedidoAcessos.add(p);
            } while (cursor.moveToNext());
        }
        return pedidoAcessos;
    }

    public String getNomeProf(int cod) {
        String m = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_ACCOUNTS, CNUM, cod);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            m = cursor.getString(0);
        }
        return m;
    }

    public ArrayList<PedidoMaterial> getPedidosDeMaterial() {
        ArrayList<PedidoMaterial> pedidoAcessos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s", DB_PEDIDOS_MATERIAL);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                PedidoMaterial p = new PedidoMaterial();
                p.setPedidoCod(cursor.getInt(0));
                p.setCod(cursor.getInt(1));
                p.setQuantidade(cursor.getInt(2));
                p.setcodProf(cursor.getInt(3));
                pedidoAcessos.add(p);
            } while (cursor.moveToNext());
        }
        return pedidoAcessos;
    }

    public ArrayList<PedidoMaterial> getPedidosDeMaterialUtilizador(int codProfessor) {
        ArrayList<PedidoMaterial> pedidoAcessos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_PEDIDOS_MATERIAL, PMCODPROF, codProfessor);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                PedidoMaterial p = new PedidoMaterial();
                p.setPedidoCod(cursor.getInt(0));
                p.setCod(cursor.getInt(1));
                p.setQuantidade(cursor.getInt(2));
                p.setcodProf(cursor.getInt(3));
                pedidoAcessos.add(p);
            } while (cursor.moveToNext());
        }
        return pedidoAcessos;
    }

    public ArrayList<Material> getMaterial() {
        ArrayList<Material> materials = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s", DB_MATERIAL);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Material m = new Material();
                m.setCod(cursor.getInt(0));
                m.setTipo(cursor.getString(1));
                m.setDescricao(cursor.getString(2));
                m.setnUnidades(cursor.getInt(3));
                m.setDisponibilidade(cursor.getString(4));
                materials.add(m);
            } while (cursor.moveToNext());
        }
        return materials;
    }

    public Material getMaterial(int codMaterial) {
        Material m = new Material();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_MATERIAL, MCOD, codMaterial);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
                m.setCod(cursor.getInt(0));
                m.setTipo(cursor.getString(1));
                m.setDescricao(cursor.getString(2));
                m.setnUnidades(cursor.getInt(3));
                m.setDisponibilidade(cursor.getString(4));
        }
        return m;
    }

    public int GetQuantidade(int codMaterial){
    int m = 0;
    SQLiteDatabase db = this.getReadableDatabase();
    String query = String.format("Select * FROM %s WHERE %s = %s", DB_MATERIAL, MCOD, codMaterial);
    Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            m = (cursor.getInt(3));
    }
        return m;
    }

    public int GetPerm(int codMaterial){
        int m = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_MATERIAL, MCOD, codMaterial);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
                m = (cursor.getInt(3));
        }
        return m;
    }
    /*
    Fim Listagens.
     */

    /*
    Início Updates.
     */
    public void updateStockMaterial(int quantidade, int codMaterial) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_MATERIAL, MUNIDADES, quantidade, MCOD, codMaterial);
        db.execSQL(query);
    }

    public void updateDisponibilidadeMaterial(int disponibilidade, int codMaterial) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_MATERIAL, MDISPONIBILIDADE, disponibilidade, MCOD, codMaterial);
        db.execSQL(query);
    }

    /*
    Fim Updates.
     */

    /*
    Método para verificar contas na BD.
     */
    public String authCheck(String nome, String pass) {
        SQLiteDatabase db = getReadableDatabase();
        String queryAl = "SELECT * FROM " + DB_ACCOUNTS ;
        Cursor c = null;
        if (db != null) {
            c = db.rawQuery(queryAl, null);
        }
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                if (nome.equalsIgnoreCase(String.valueOf(c.getInt(1))) && pass.equalsIgnoreCase(String.valueOf(c.getInt(2)))) {
                    return String.valueOf(c.getInt(2));
                }
            }
        }
        return "";
    }

    public int checkContaTable() {
        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT * FROM " + DB_ACCOUNTS;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            return 1;
        } else {
            return 2;
        }
    }
    //populate table

    /*
    Método para verificar materiais na BD.
     */
    public int checkMaterialTable() {
        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT * FROM " + DB_MATERIAL;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){
            return 1;
        }
        else{
            return 2;
        }
    }

    /*
    Método para verificar pedidos de acesso na BD.
     */
    public int checkPedidosAcessoTable() {
        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT * FROM " + DB_PEDIDOS_ACESSO;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){
            return 1;
        }
        else{
            return 2;
        }
    }

    /*
    Método para verificar pedidos de materiais na BD.
     */
    public int checkPedidosMaterialTable() {
        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT * FROM " + DB_PEDIDOS_MATERIAL;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){
            return 1;
        }
        else{
            return 2;
        }
    }

    /*
    Método para atualizar permissões na BD.
     */
    public void updatePerm(int perm, int codProf) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_ACCOUNTS, CPERM, perm, CNUM, codProf);
        db.execSQL(query);
    }

    /*
    Método para obter contas a partir da BD.
     */
    public Conta getConta(int codConta) {
        Conta m = new Conta();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_ACCOUNTS, CNUM, codConta);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            m.setNome(cursor.getString(0));
            m.setNum(cursor.getInt(1));
            m.setPass(cursor.getString(2));
            m.setTipo(cursor.getString(3));
            m.setPerm(cursor.getInt(4));
        }
        return m;
    }
}