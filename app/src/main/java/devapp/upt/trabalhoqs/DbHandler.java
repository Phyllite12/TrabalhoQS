package devapp.upt.trabalhoqs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper{

    Context ct;

    //Nome das tabelas
    public static final String DB_MATERIAL = "Materiais";
    public static final String DB_ACCOUNTS = "Contas";
    public static final String DB_CONSUMIVEIS = "Consumiveis";
    public static final String DB_COMPONENTS = "Componentes";
    public static final String DB_PEDIDOS_ACESSO = "PedidosAcesso";
    public static final String DB_PEDIDOS_MATERIAL = "PedidosMaterial";

    //TABLE Materiais
    public static final String MCOD = "MCOD";
    public static final String MTIPO = "MTIPO";
    public static final String MDESCRICAO = "MDESCRICAO";
    public static final String MUNIDADES = "MUNIDADES";
    public static final String MDISPONIBILIDADE = "MDISPONIBILIDADE";

    //TABLE Contas
    public static final String CNOME = "CNOME";
    public static final String CNUM = "CNUM";
    public static final String CPASS = "CPASS";
    public static final String CTIPO = "CTIPO";

    //TABLE Consumiveis
    public static final String CONSCOD = "CONSCOD";
    public static final String CONSMCOD = "CONSMCOD";
    public static final String CONSDESCRICAO = "CONSDESCRICAO";
    public static final String CONSUNIDADES = "CONSUNIDADES";
    public static final String CONSDISPONIBILIDADE = "CONSDISPONIBILIDADE ";

    //TABLE Componentes
    public static final String COMSCOD = "COMSCOD";
    public static final String COMSMCOD = "COMSMCOD";
    public static final String COMSDESCRICAO = "COMSDESCRICAO";
    public static final String COMSUNIDADES = "COMSUNIDADES";
    public static final String COMSDISPONIBILIDADE = "COMSDISPONIBILIDADE ";

    //TABLE PedidosAcesso
    public static final String PACOD = "PACOD";
    public static final String PANOMEPROF = "PANOMEPROF";
    public static final String PANUM = "PANUM";
    public static final String PACOMENTARIO = "PACOMENTARIO";

    //TABLE PedidosMaterial
    public static final String PMCOD = "PMCOD";
    public static final String PMCODPRODUTO = "PMCODPRODUTO";
    public static final String PMQUANTIDADE = "PMQUANTIDADE";
    public static final String PMCODPROF = "PMCODPROF";

    //DATABASE DEFINITIONS
    public static final String DBNAME = "mydatabase";

    private static final int VERSION = 1;

    //Construtor
    public DbHandler(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
        this.ct = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryMateriaisTable = String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER, %s TEXT)", DB_MATERIAL, MCOD, MTIPO, MDESCRICAO, MUNIDADES, MDISPONIBILIDADE);
        String queryContasTable = String.format("CREATE TABLE %s( %s TEXT , %s INTEGER PRIMARY KEY, %s TEXT, %s TEXT)", DB_ACCOUNTS, CNOME, CNUM, CPASS, CTIPO);
        String queryConsumiveisTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, FOREIGN KEY(%s), %s TEXT, %s INTEGER, %s TEXT)", DB_CONSUMIVEIS, CONSCOD, CONSMCOD, CONSDESCRICAO, CONSUNIDADES, CONSDISPONIBILIDADE);
        String queryComponentesTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, FOREIGN KEY(%s), %s TEXT, %s INTEGER, %s TEXT)", DB_COMPONENTS, COMSCOD, COMSMCOD, COMSDESCRICAO, COMSUNIDADES, COMSDISPONIBILIDADE);
        String queryPedidosAcessoTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, % TEXT)", DB_PEDIDOS_ACESSO, PACOD, PANOMEPROF, PANUM, PACOMENTARIO);
        String queryPedidosMaterialTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, FOREIGN KEY(%s), %s INTEGER, FOREIGN KEY(%s))", DB_PEDIDOS_MATERIAL, PMCOD, PMCODPRODUTO, PMQUANTIDADE, PMCODPROF);
        sqLiteDatabase.execSQL(queryMateriaisTable);
        sqLiteDatabase.execSQL(queryContasTable);
        sqLiteDatabase.execSQL(queryConsumiveisTable);
        sqLiteDatabase.execSQL(queryComponentesTable);
        sqLiteDatabase.execSQL(queryPedidosAcessoTable);
        sqLiteDatabase.execSQL(queryPedidosMaterialTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_MATERIAL);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_ACCOUNTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_CONSUMIVEIS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_COMPONENTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_PEDIDOS_ACESSO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_PEDIDOS_MATERIAL);
        onCreate(sqLiteDatabase);
    }




    //Adds
    public void addMaterial(Material material) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s','%s');", DB_MATERIAL, MCOD, MTIPO, MDESCRICAO, MUNIDADES, MDISPONIBILIDADE, material.getCod(), material.getTipo(), material.getDescricao(), material.getnUnidades(), material.isDisponibilidade());
        db.execSQL(query);
    }

    public void addContas(Conta conta) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES('%s','%s','%s','%s');", DB_ACCOUNTS, CNOME, CNUM, CPASS, CTIPO, conta.getNome(), conta.getNum(), conta.getPass(), conta.getTipo());
        db.execSQL(query);
    }

    public void addConsumiveis(Consumivel consumivel) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s','%s');", DB_CONSUMIVEIS, CONSCOD, CONSMCOD, CONSDESCRICAO, CONSUNIDADES, CONSDISPONIBILIDADE, consumivel.getCod(), consumivel.getCodMaterial(), consumivel.getDescricao(), consumivel.getnUnidades(), consumivel.isDisponibilidade());
        db.execSQL(query);
    }

    public void addComponentes(Componente componente) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s','%s');", DB_COMPONENTS, COMSCOD, COMSMCOD, COMSDESCRICAO, COMSUNIDADES, COMSDISPONIBILIDADE, componente.getCod(), componente.getCodMaterial(), componente.getDescricao(), componente.getnUnidades(), componente.isDisponibilidade());
        db.execSQL(query);
    }

    public void addPedidosAcesso(PedidoAcesso pedidoAcesso) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES('%s','%s','%s','%s');", DB_PEDIDOS_ACESSO, PACOD, PANOMEPROF, PANUM, PACOMENTARIO, pedidoAcesso.getCod(), pedidoAcesso.getNomeProfessor(), pedidoAcesso.getNum(), pedidoAcesso.getComentario());
        db.execSQL(query);
    }

    public void addPedidosMaterial(PedidoMaterial pedidoMaterial) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES('%s','%s','%s','%s');", DB_PEDIDOS_MATERIAL, PMCOD, PMCODPRODUTO, PMQUANTIDADE, PMCODPROF, pedidoMaterial.getPedidoCod(), pedidoMaterial.getCod(), pedidoMaterial.getQuantidade(), pedidoMaterial.getcodProf());
        db.execSQL(query);
    }
    //Fim Adds






    //Deletes
    public void DeleteConta(int num) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_ACCOUNTS, CNUM, num);
        db.execSQL(query);
    }

    public void DeleteConsumiveis(int cod) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_CONSUMIVEIS, CONSCOD, cod);
        db.execSQL(query);
    }

    public void DeleteComponente(int cod) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_COMPONENTS, COMSCOD, cod);
        db.execSQL(query);
    }

    public void DeleteMaterial(int cod) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM %s WHERE %s = %s", DB_MATERIAL, MCOD, cod);
        db.execSQL(query);
    }
    //Fim Deletes







    //Listagens
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
                p.setComentario(cursor.getString(1));
                pedidoAcessos.add(p);
            } while (cursor.moveToNext());
        }
        return pedidoAcessos;
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
            do {
                m.setCod(cursor.getInt(0));
                m.setTipo(cursor.getString(1));
                m.setDescricao(cursor.getString(2));
                m.setnUnidades(cursor.getInt(3));
                m.setDisponibilidade(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return m;
    }

    public ArrayList<Consumivel> getConsumivel() {
        ArrayList<Consumivel> consumivels = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s", DB_CONSUMIVEIS);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Consumivel c = new Consumivel();
                c.setCod(cursor.getInt(0));
                c.setCodMaterial(cursor.getInt(1));
                c.setDescricao(cursor.getString(2));
                c.setnUnidades(cursor.getInt(3));
                c.setDisponibilidade(cursor.getString(4));
                consumivels.add(c);
            } while (cursor.moveToNext());
        }
        return consumivels;
    }

    public ArrayList<Consumivel> getConsumivelMaterial(int CodMaterial) {
        ArrayList<Consumivel> consumivels = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_CONSUMIVEIS, CONSMCOD, CodMaterial);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Consumivel c = new Consumivel();
                c.setCod(cursor.getInt(0));
                c.setCodMaterial(cursor.getInt(1));
                c.setDescricao(cursor.getString(2));
                c.setnUnidades(cursor.getInt(3));
                c.setDisponibilidade(cursor.getString(4));
                consumivels.add(c);
            } while (cursor.moveToNext());
        }
        return consumivels;
    }

    public Consumivel getConsumivel(int CodConsumivel) {
        Consumivel c = new Consumivel();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_CONSUMIVEIS, CONSCOD, CodConsumivel);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                c.setCod(cursor.getInt(0));
                c.setCodMaterial(cursor.getInt(1));
                c.setDescricao(cursor.getString(2));
                c.setnUnidades(cursor.getInt(3));
                c.setDisponibilidade(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return c;
    }

    public ArrayList<Componente> getComponente() {
        ArrayList<Componente> componentes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s", DB_COMPONENTS);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Componente c = new Componente();
                c.setCod(cursor.getInt(0));
                c.setCodMaterial(cursor.getInt(1));
                c.setDescricao(cursor.getString(2));
                c.setnUnidades(cursor.getInt(3));
                c.setDisponibilidade(cursor.getString(4));
                componentes.add(c);
            } while (cursor.moveToNext());
        }
        return componentes;
    }

    public ArrayList<Componente> getComponenteMaterial(int CodMaterial) {
        ArrayList<Componente> componentes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_COMPONENTS, COMSMCOD, CodMaterial);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Componente c = new Componente();
                c.setCod(cursor.getInt(0));
                c.setCodMaterial(cursor.getInt(1));
                c.setDescricao(cursor.getString(2));
                c.setnUnidades(cursor.getInt(3));
                c.setDisponibilidade(cursor.getString(4));
                componentes.add(c);
            } while (cursor.moveToNext());
        }
        return componentes;
    }

    public Componente getComponente(int codComponente) {
        Componente c = new Componente();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("Select * FROM %s WHERE %s = %s", DB_COMPONENTS, COMSCOD, codComponente);
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                c.setCod(cursor.getInt(0));
                c.setCodMaterial(cursor.getInt(1));
                c.setDescricao(cursor.getString(2));
                c.setnUnidades(cursor.getInt(3));
                c.setDisponibilidade(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return c;
    }
    //Fim Listagens







    //Updates
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

    public void updateStockConsumivel(int quantidade, int codConsumivel) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_CONSUMIVEIS, CONSUNIDADES, quantidade, CONSCOD, codConsumivel);
        db.execSQL(query);
    }

    public void updateDisponibilidadeConsumivel(int disponibilidade, int codConsumivel) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_CONSUMIVEIS, CONSDISPONIBILIDADE, disponibilidade, CONSCOD, codConsumivel);
        db.execSQL(query);
    }

    public void updateStockComponente(int quantidade, int codComponente) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_COMPONENTS, COMSDISPONIBILIDADE, quantidade, COMSCOD, codComponente);
        db.execSQL(query);
    }

    public void updateDisponibilidadeComponente(int disponibilidade, int codComponente) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("UPDATE * SET %s = %s WHERE %s = %s", DB_COMPONENTS, COMSUNIDADES, disponibilidade, COMSCOD, codComponente);
        db.execSQL(query);
    }
    //Fim Updates

}
