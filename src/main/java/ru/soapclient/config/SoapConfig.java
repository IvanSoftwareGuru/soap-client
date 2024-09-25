package ru.soapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import ru.soapclient.client.DataaccessClient;

@Configuration
public class SoapConfig {


    @Bean
    WebServiceMessageFactory messageFactorySiebel() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_11);
        return messageFactory;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.dataaccess.webservicesserver");
        return marshaller;
    }

    @Bean
    public DataaccessClient ccxSiebelClient(Jaxb2Marshaller marshaller, WebServiceMessageFactory messageFactorySiebel) {
        DataaccessClient client = new DataaccessClient();
        client.setMessageFactory(messageFactorySiebel);
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setMessageSender(getMessageSender());
        return client;
    }

    private HttpComponentsMessageSender getMessageSender() {
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setReadTimeout(30000); // Set the read timeout in milliseconds
        return messageSender;
    }
}
