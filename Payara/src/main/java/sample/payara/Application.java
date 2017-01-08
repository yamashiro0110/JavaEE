package sample.payara;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Application extends ResourceConfig {

    public Application() {
        packages(this.getClass().getPackage().getName());
        register(JacksonFeature.class);
    }
}
