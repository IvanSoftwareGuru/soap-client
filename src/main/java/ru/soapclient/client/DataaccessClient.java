package ru.soapclient.client;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class DataaccessClient extends WebServiceGatewaySupport {

    public NumberToWordsResponse numberToWords(NumberToWords request) {
        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
