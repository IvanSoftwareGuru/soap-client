package ru.soapclient.mapper;

import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.soapclient.dto.NumberToWordsDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class NumberToWordsMapper {

    @Mappings(
            value = {
                    @Mapping(target = "result", source = "numberToWordsResult"),
            })
    public abstract NumberToWordsDto toDto(NumberToWordsResponse soapResponse);
}
