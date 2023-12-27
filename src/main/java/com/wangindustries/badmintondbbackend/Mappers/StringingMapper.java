package com.wangindustries.badmintondbbackend.Mappers;

import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.models.PatchStringingRequestBody;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StringingMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStringingFromPatchStringingRequestBody(PatchStringingRequestBody patchStringingRequestBody, @MappingTarget Stringing stringing);
}
