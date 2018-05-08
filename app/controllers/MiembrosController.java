package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.miembros.IMiembrosService;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class MiembrosController extends Controller {

    private final IMiembrosService miembrosService;

    @Inject
    public MiembrosController(IMiembrosService miembrosService){
        this.miembrosService = miembrosService;
    }

    public Result getMiembros() {
        return ok(views.html.index.render());
    }

    public Result agregarMiembro() {
        return ok(views.html.index.render());
    }

}
