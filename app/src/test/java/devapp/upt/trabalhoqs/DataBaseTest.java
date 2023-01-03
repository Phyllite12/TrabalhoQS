package devapp.upt.trabalhoqs;

import static org.junit.Assert.assertEquals;
import android.content.Context;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import devapp.upt.trabalhoqs.ClassesObjetos.Conta;
import devapp.upt.trabalhoqs.ClassesObjetos.Material;
import devapp.upt.trabalhoqs.ClassesObjetos.PedidoAcesso;
import devapp.upt.trabalhoqs.ClassesObjetos.PedidoMaterial;

    public class DataBaseTest  {

        DbHandler db;
        Context ct;

        @BeforeEach
        public void setUp(){
            db = new DbHandler(ct);
        }


        //Adds
        @Test
        @DisplayName("Deve verificar se contas são adicionadas")
        public void shouldAddAccount(){
            db.addContas(new Conta("Marco", 43050, "123asd", "professor", 1));
            assertEquals(1, db.checkContaTable());
        }

        @Test
        @DisplayName("Deve verificar se Materiais são adicionadas")
        public void shouldAddMaterial(){
            db.addMaterial(new Material(24343, "drone", "drone", 10, "disponivel"));
            assertEquals(1, db.checkMaterialTable());
        }

        @Test
        @DisplayName("Deve verificar se Pedidos de Acesso são adicionadas")
        public void shouldAddPedidosAcesso(){
            db.addPedidosAcesso(new PedidoAcesso("António", 32394));
            assertEquals(1, db.checkPedidosAcessoTable());
        }

        @Test
        @DisplayName("Deve verificar se Pedidos de Material são adicionadas")
        public void shouldAddPedidosMaterail(){
            db.addPedidosMaterial(new PedidoMaterial(43284, 3, 74832));
            assertEquals(1, db.checkPedidosMaterialTable());
        }
        //Fim Adds

        //Deletes
        @Test
        @DisplayName("Deve apagar uma Conta existente")
        public void apagaConta(){
            db.addContas(new Conta("Marco", 43050, "123asd", "professor", 1));
            db.DeleteConta(43050);
            assertEquals(2, db.checkContaTable());
        }

        @Test
        @DisplayName("Deve apagar um Pedido de Acesso existente")
        public void apagaPedidoAcesso(){
            db.addPedidosAcesso(new PedidoAcesso("António", 32394));
            db.DeletePedidoAcesso(32395);
            assertEquals(2, db.checkPedidosAcessoTable());
        }

        @Test
        @DisplayName("Deve apagar um Pedido de Material existente")
        public void apagaPedidoMaterial(){
            db.addPedidosMaterial(new PedidoMaterial(43284, 3, 74832));
            db.DeleteConta(74832);
            assertEquals(2, db.checkPedidosMaterialTable());
        }
        //Fim Deletes

        //Listagens
        @Test
        @DisplayName("Deve armazenar os dados da tabela Material num Array")
        public void arrayMaterial(){
            ArrayList<Material> materials = new ArrayList<>();
            db.addMaterial(new Material(24343, "drone", "drone", 10, "disponivel"));
            materials = db.getMaterial();
            assertEquals(1, materials.size());
        }

        @Test
        @DisplayName("Deve armazenar os dados da tabela Pedidos Acesso num Array")
        public void arrayPedidosAcesso(){
            ArrayList<PedidoAcesso> pedidoAcessos = new ArrayList<>();
            db.addPedidosAcesso(new PedidoAcesso("António", 32394));
            pedidoAcessos = db.getPedidosDeAcesso();
            assertEquals(1, pedidoAcessos.size());
        }

        @Test
        @DisplayName("Deve armazenar os dados da tabela Pedidos de Material num Array")
        public void arrayPedidosMaterial(){
            ArrayList<PedidoMaterial> pedidoMaterials = new ArrayList<>();
            db.addPedidosMaterial(new PedidoMaterial(43284, 3, 74832));
            pedidoMaterials = db.getPedidosDeMaterial();
            assertEquals(1, pedidoMaterials.size());
        }
        //Fim Listagens

        //updates
        @Test
        @DisplayName("Deve atualizar o stock")
        public void updateStock(){
            db.addMaterial(new Material(24343, "drone", "drone", 10, "disponivel"));
            db.updateStockMaterial(5, 24343);
            Material materials = db.getMaterial(24343);
            assertEquals(5, materials.getnUnidades());
        }

        @Test
        @DisplayName("Deve atualizar a permissao")
        public void updatePemission() {
            db.addContas(new Conta("Marco", 43050, "123asd", "professor", 1));
            db.updatePerm(2, 43050);
            Conta conta = db.getConta(24343);
            assertEquals(5, conta.getPerm());
        }
    }