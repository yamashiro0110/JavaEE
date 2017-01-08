package sample.payara.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.dao.AppleMyBatisDao;
import sample.payara.mybatis.dao.PineappleMyBatisDao;

@Stateless
@Path("mybatis")
public class MyBatisController {
    @Inject
    private AppleMyBatisDao appleMyBatisDao;
    @Inject
    private PineappleMyBatisDao pineappleMyBatisDao;

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyBatisUser> list() {
        return this.appleMyBatisDao.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyBatisUser search(@PathParam("id") Long id) {
        return appleMyBatisDao.findBy(id);
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyBatisUser> search(@QueryParam("name") String name) {
        return pineappleMyBatisDao.findByName(name);
    }

}
