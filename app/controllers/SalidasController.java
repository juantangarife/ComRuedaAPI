package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.eventos.salidas.ISalidasService;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class SalidasController extends Controller {

    private final ISalidasService salidasService;

    @Inject
    public SalidasController(ISalidasService salidasService){
        this.salidasService = salidasService;
    }

    public Result getSalidas() {
        return ok(views.html.index.render());
    }

    public Result crearSalida() {
        return ok(views.html.index.render());
    }

}
