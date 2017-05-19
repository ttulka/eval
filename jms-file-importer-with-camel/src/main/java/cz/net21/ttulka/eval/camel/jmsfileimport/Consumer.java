package cz.net21.ttulka.eval.camel.jmsfileimport;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by ttulka
 */
@Component
public class Consumer {

    @JmsListener(destination = "${destinationName}")
    public void onNewDicomFile(String dicomFile) {
        System.out.println("Importing a dicom file: " + dicomFile);
    }
}
