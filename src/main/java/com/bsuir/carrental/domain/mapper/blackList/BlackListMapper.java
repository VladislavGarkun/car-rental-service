package com.bsuir.carrental.domain.mapper.blackList;

import com.bsuir.carrental.dao.model.blackList.BlackList;
import com.bsuir.carrental.domain.dto.blackList.BlackListDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlackListMapper {

    BlackListDto toDto(BlackList blackList);

    List<BlackListDto> toListDto(List<BlackList> blackListList);

}