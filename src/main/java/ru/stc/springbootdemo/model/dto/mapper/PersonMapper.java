package ru.stc.springbootdemo.model.dto.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.stc.springbootdemo.model.Person;
import ru.stc.springbootdemo.model.dto.PersonDto;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);

    Person toPerson(PersonDto personDTO);

    @InheritInverseConfiguration
    PersonDto toPersonDto(Person person);

}
