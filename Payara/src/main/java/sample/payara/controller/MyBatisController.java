package sample.payara.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.param.MyBatisUserSearchParam;
import sample.payara.mybatis.repotiroy.AppleMyBatisRepository;
import sample.payara.mybatis.repotiroy.PineappleMyBatisRepository;

@Stateless
@Path("mybatis")
public class MyBatisController {
    @Inject
    private AppleMyBatisRepository appleMyBatisRepository;
    @Inject
    private PineappleMyBatisRepository pineappleMyBatisRepository;

    @GET
    @Path("apple/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyBatisUser> list() {
        return this.appleMyBatisRepository.findAll();
    }

    @GET
    @Path("apple/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyBatisUser search(@PathParam("id") final Long id) {
        return appleMyBatisRepository.findBy(id);
    }

    @GET
    @Path("pineapple/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyBatisUser> search(@QueryParam("name") final String name) {
        return pineappleMyBatisRepository.findByName(name);
    }

    @POST
    @Path("apple/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MyBatisUser> search(final MyBatisUserSearchParam param) {
        return appleMyBatisRepository.findBy(param);
    }

    @POST
    @Path("apple/search/xml_mapper")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MyBatisUser> searchByXmlMapper(final MyBatisUserSearchParam param) {
        return appleMyBatisRepository.findByXmlMapper(param);
    }

}
