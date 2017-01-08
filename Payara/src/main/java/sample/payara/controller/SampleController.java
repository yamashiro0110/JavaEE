package sample.payara.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sample.payara.ejb.SampleEjb;
import sample.payara.model.SampleModel;

@Stateless
@Path("/sample")
public class SampleController {
    @Inject
    private SampleEjb sampleEjb;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return "Hello Payara!!";
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SampleModel> list() {
        return sampleEjb.findAll();
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SampleModel search(@QueryParam("id") Long id) {
        return this.sampleEjb.findBy(id);
    }

}
