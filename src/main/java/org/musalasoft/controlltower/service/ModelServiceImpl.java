package org.musalasoft.controlltower.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.Definitions;
import org.musalasoft.controlltower.domain.dto.ModelDTO;
import org.musalasoft.controlltower.domain.entity.Model;
import org.musalasoft.controlltower.domain.excepion.ServiceLevelException;
import org.musalasoft.controlltower.domain.repository.ModelRepository;
import org.musalasoft.controlltower.domain.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper mapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, @Qualifier(Definitions.MODEL_MAPPER_BEAN_NAME) ModelMapper mapper) {
        this.modelRepository = modelRepository;
        this.mapper = mapper;
    }

    @Override
    public String create(ModelDTO modelDTO) {
        if (modelDTO == null || "".equals(modelDTO.getName())) {
            log.error("name cannot be null when creating drone model");
            throw new ServiceLevelException("name cannot be null when creating drone model");
        }
        log.debug("Creating a drone model.", modelDTO);
        Model model = mapper.map(modelDTO, Model.class);
        return modelRepository.save(model).getId();
    }

    @Override
    public List<Model> getAll() {
        log.debug("fetching all drone models");
        return modelRepository.findAll();
    }

    @Override
    public Model get(String id) {
        if (id == null) {
            log.error("Cannot find id");
            throw new ServiceLevelException("id cannot be null");
        }
        log.debug("fetching drone models for id", id);
        Optional<Model> model = modelRepository.findById(id);
        if(model.isEmpty()){
            log.debug("cannot find drone model for id " + id);
            throw new ServiceLevelException("cannot find drone model for id " + id);
        }
        return model.get();
    }
}
