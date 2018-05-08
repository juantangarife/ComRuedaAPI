package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.marketplace.productos.IProductosService;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class MarketplaceController extends Controller {

    private final IProductosService productosService;

    @Inject
    public MarketplaceController(IProductosService productosService){
        this.productosService = productosService;
    }

    public Result getProductos() {
        return ok(views.html.index.render());
    }

    public Result agregarProducto() {
        return ok(views.html.index.render());
    }

    public Result comprarProducto(Long id) {
        return ok(views.html.index.render());
    }
}
