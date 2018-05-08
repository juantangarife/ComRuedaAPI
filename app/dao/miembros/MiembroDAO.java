package dao.miembros;

import dao.DatabaseExecutionContext;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Transaction;
import model.marketplace.productos.Producto;
import model.miembros.Miembro;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class MiembroDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public MiembroDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<List<Miembro>> getMiembros(){
        return supplyAsync(() -> {
            return ebeanServer.find(Miembro.class).findList();
        }, executionContext);
    }

    public CompletionStage<Boolean> agregarMiembro() {
        Transaction txn = ebeanServer.beginTransaction();

        return supplyAsync(() -> {
            boolean response = false;
            try {
                Miembro m = new Miembro();
                // TODO Crear el producto
                ebeanServer.insert(m);
                txn.commit();
                response = true;
            } finally {
                txn.end();
            }
            return response;
        }, executionContext);
    }
}
