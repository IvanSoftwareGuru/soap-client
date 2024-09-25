package ru.soapclient.service;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.soapclient.api.NumberToWordsService;
import ru.soapclient.client.DataaccessClient;
import ru.soapclient.dto.NumberToWordsDto;
import ru.soapclient.mapper.NumberToWordsMapper;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class NumberToWordsServiceImpl implements NumberToWordsService {

    private final DataaccessClient client;
    private final NumberToWordsMapper mapper;

    @Override
    public NumberToWordsDto numberToWordsRequest(BigInteger number) {
        NumberToWords numberToWordsResponseRequest = new NumberToWords();
        numberToWordsResponseRequest.setUbiNum(number);

        NumberToWordsResponse numberToWordsResponse = client.numberToWords(numberToWordsResponseRequest);


        return mapper.toDto(numberToWordsResponse);
    }
}
