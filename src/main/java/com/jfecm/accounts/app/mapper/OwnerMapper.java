package com.jfecm.accounts.app.mapper;

import com.jfecm.accounts.app.dto.OwnerDto;
import com.jfecm.accounts.app.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends BaseMapper<Owner, OwnerDto> {
}
