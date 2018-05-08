package dao.eventos.salidas;

import dao.DatabaseExecutionContext;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Transaction;
import model.eventos.salidas.Salida;
import model.marketplace.productos.Producto;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SalidaDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public SalidaDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<List<Salida>> getSalidas(){
        return supplyAsync(() -> {
            return ebeanServer.find(Salida.class).findList();
        }, executionContext);
    }

    public CompletionStage<Boolean> agregarSalida(){
        Transaction txn = ebeanServer.beginTransaction();

        return supplyAsync(() -> {
            boolean response = false;
            try {
                Salida s = new Salida();
                // TODO Crear la salida
                ebeanServer.insert(s);
                txn.commit();
                response = true;
            } finally {
                txn.end();
            }
            return response;
        }, executionContext);
    }

}
