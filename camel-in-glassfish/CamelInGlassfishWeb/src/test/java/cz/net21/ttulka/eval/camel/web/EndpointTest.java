package cz.net21.ttulka.eval.camel.web;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomas Tulka
 */
public class EndpointTest {

    @Test
    public void callServiceTest() {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setReadTimeout(600000);
//        factory.setConnectTimeout(600000);
//
//        RestTemplate restTemplate = new RestTemplate(factory);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + Base64.encodeBase64String((uid + ":" + password).getBytes()));
//
//        HttpEntity<String> request = new HttpEntity<>(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange("http://127.0.0.1:8080/camel", HttpMethod.GET, request, String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
