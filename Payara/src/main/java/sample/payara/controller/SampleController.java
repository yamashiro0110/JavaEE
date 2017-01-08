package sample.payara.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import sample.payara.ejb.SampleEjb;
import sample.payara.model.SampleModel;

@Stateless
@Path("/sample")
public class SampleController {
    @EJB
    private SampleEjb sampleEjb;

    @GET
    @Produces("text/plain")
    public String index() {
        return "Hello Payara!!";
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public SampleModel json(@QueryParam("id") Long id) {
        return this.sampleEjb.findBy(id);
    }

}
