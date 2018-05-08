package dao.marketplace.productos;

import dao.DatabaseExecutionContext;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;

public class ProductoDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public ProductoDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }
}
