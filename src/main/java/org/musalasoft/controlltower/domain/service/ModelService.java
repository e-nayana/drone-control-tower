package org.musalasoft.controlltower.domain.service;

import org.musalasoft.controlltower.domain.dto.ModelDTO;
import org.musalasoft.controlltower.domain.entity.Model;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    String create(ModelDTO modelDTO);

    List<Model> getAll();

    Model get(String id);
}
