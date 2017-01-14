package sample.payara.controller.joda;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/joda")
@Produces(MediaType.APPLICATION_JSON)
public class JodaDateTimeController {

    /*
     * FIXME: JAX-RSとObjectMapperのアダプタが必要?
     */
    @GET
    public JodaDateTimeRequest get(@BeanParam final JodaDateTimeRequest request) {
        return request;
    }

    /**
     * @see JodaDateTimeRequest
     */
    @POST
    public JodaDateTimeRequest post(final JodaDateTimeRequest request) {
        return request;
    }

}
