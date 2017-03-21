package cz.net21.ttulka.eval.camel.web;

import cz.net21.ttulka.eval.camel.CamelBean;
import cz.net21.ttulka.eval.camel.CamelService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Tomas Tulka
 */
@Stateless
@LocalBean
@Path("/")
public class Endpoint {

    @EJB
    private CamelService service;

    @GET
    @Produces("text/plain;charset=UTF-8")
    public String callService() {
        return service.doSomething();
    }
}
