package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.auth.IAuthService;

import javax.inject.Inject;

public class AuthController extends Controller {

    private final IAuthService authService;

    @Inject
    public AuthController(IAuthService authService){
        this.authService = authService;
    }

    public Result login() {
        return ok(views.html.index.render());
    }

}
