package dao.auth;

import dao.DatabaseExecutionContext;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import model.auth.User;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;

import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class UserDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public UserDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<User> getUsuario(String username, String password) {
        return supplyAsync(() -> {
            // TODO filtrar usuario
            return ebeanServer.find(User.class).findUnique();
        }, executionContext);
    }
}
