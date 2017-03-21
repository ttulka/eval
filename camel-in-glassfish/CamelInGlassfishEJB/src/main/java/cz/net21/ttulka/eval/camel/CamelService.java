package cz.net21.ttulka.eval.camel;

import javax.ejb.Remote;

/**
 * Created by Tomas Tulka
 */
@Remote
public interface CamelService {

    String doSomething();
}
