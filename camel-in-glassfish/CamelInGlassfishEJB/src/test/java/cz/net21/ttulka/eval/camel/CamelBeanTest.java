package cz.net21.ttulka.eval.camel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Tomas Tulka
 */
public class CamelBeanTest {

    private static EJBContainer ejbContainer;
    private static Context ctx;

    @BeforeClass
    public static void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDown() {
        ejbContainer.close();
    }

    @Test
    public void testFindAll() {
        try {
            CamelService service = (CamelService) ctx.lookup("java:global/classes/CamelBean!cz.net21.ttulka.eval.camel.CamelService");
            assertNotNull(service);

            String response = service.doSomething();
            assertNotNull(response);
            assertEquals(CamelBean.CONTENT, response);
        }
        catch (NamingException e) {
            throw new AssertionError(e);
        }
    }
}
