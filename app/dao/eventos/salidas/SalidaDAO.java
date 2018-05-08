package dao.eventos.salidas;

import dao.DatabaseExecutionContext;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;

public class SalidaDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public SalidaDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }
}
