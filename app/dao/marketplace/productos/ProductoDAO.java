package dao.marketplace.productos;

import dao.DatabaseExecutionContext;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Transaction;
import model.marketplace.productos.Producto;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class ProductoDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public ProductoDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<List<Producto>> getProductos() {
        return supplyAsync(() -> {
            return ebeanServer.find(Producto.class).findList();
        }, executionContext);
    }

    public CompletionStage<Boolean> agregarProducto() {
        Transaction txn = ebeanServer.beginTransaction();

        return supplyAsync(() -> {
            boolean response = false;
            try {
                Producto p = new Producto();
                // TODO Crear el producto
                ebeanServer.insert(p);
                txn.commit();
                response = true;
            } finally {
                txn.end();
            }
            return response;
        }, executionContext);
    }

    public CompletionStage<Long> comprarProducto(Long idProducto, Long cantidad) {
        Transaction txn = ebeanServer.beginTransaction();
        return supplyAsync(() -> {
            try {
                Producto producto = ebeanServer.find(Producto.class).setId(idProducto).findUnique();
                if (producto != null) {
                    // TODO Disminuir la cantidad
                    ebeanServer.update(producto);
                    txn.commit();
                }
            } finally {
                txn.end();
            }
            return idProducto;
        }, executionContext);
    }
}
