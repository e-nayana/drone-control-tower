package org.musalasoft.controlltower.transport.controller;

import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.dto.ModelDTO;
import org.musalasoft.controlltower.domain.service.ModelService;
import org.musalasoft.controlltower.transport.CreateModelReq;
import org.musalasoft.libs.response.RESTResponse;
import org.musalasoft.libs.response.RESTResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/models")
public class ModelController {

    private final ModelMapper modelMapper;
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelMapper modelMapper, ModelService modelService) {
        this.modelMapper = modelMapper;
        this.modelService = modelService;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RESTResponse create(@Valid @RequestBody CreateModelReq request) {
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("id", modelService.create(modelMapper.map(request, ModelDTO.class)))
                .responseBuilder().build();
    }

    @RequestMapping(method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RESTResponse getAll() {
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("models", modelService.getAll())
                .responseBuilder().build();
    }

    @RequestMapping(path = "/{model_id}", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RESTResponse get(@PathVariable("model_id") String modelId) {
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("models", modelService.get(modelId))
                .responseBuilder().build();
    }
}
