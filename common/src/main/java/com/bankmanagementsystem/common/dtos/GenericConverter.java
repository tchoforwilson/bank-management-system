package com.bankmanagementsystem.common.dtos;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public GenericConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Converts an entity to a DTO
     * 
     * @param entity   Entity to convert
     * @param dtoClass Target DTO class
     * @return Converted DTO object
     */
    public <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, dtoClass);
    }

    /**
     * Converts a DTO to an entity
     * 
     * @param dto         DTO to convert
     * @param entityClass Target entity class
     * @return Converted entity object
     */
    public <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, entityClass);
    }

    /**
     * Converts a list of entities to a list of DTOs
     * 
     * @param entities List of entities to convert
     * @param dtoClass Target DTO class
     * @return List of converted DTO objects
     */
    public <D, E> List<D> convertToDtoList(List<E> entities, Class<D> dtoClass) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(entity -> convertToDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    /**
     * Converts a list of DTOs to a list of entities
     * 
     * @param dtos        List of DTOs to convert
     * @param entityClass Target entity class
     * @return List of converted entity objects
     */
    public <D, E> List<E> convertToEntityList(List<D> dtos, Class<E> entityClass) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(dto -> convertToEntity(dto, entityClass))
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing entity with DTO data
     * 
     * @param dto    DTO containing updated data
     * @param entity Existing entity to update
     */
    public <D, E> void updateEntityFromDto(D dto, E entity) {
        if (dto == null || entity == null) {
            return;
        }
        modelMapper.map(dto, entity);
    }
}