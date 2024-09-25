package ru.soapclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.soapclient.api.NumberToWordsService;
import ru.soapclient.dto.NumberToWordsDto;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
public class SoapClientController {

    private final NumberToWordsService service;

    @RequestMapping("/number-to-words/{number}")
    public NumberToWordsDto numberToWords(@PathVariable BigInteger number) {
        return service.numberToWordsRequest(number);
    }

}
