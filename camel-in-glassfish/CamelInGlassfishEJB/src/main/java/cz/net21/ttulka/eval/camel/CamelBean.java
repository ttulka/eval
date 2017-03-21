package cz.net21.ttulka.eval.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by Tomas Tulka
 */
@Stateless
@Local(CamelService.class)
@LocalBean
public class CamelBean implements CamelService {

    static final String CONTENT = "Greetings from the bean!";

    public String doSomething() {
        try {
            CamelContext context = new DefaultCamelContext();
            context.setStreamCaching(true);
            context.addRoutes(new RouteBuilder() {
                public void configure() {
                    from("file://test").to("file://test");
                }
            });
            context.start();
            Thread.sleep(1000);
            context.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return CONTENT;
    }
}
