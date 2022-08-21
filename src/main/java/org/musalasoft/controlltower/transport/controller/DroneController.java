package org.musalasoft.controlltower.transport.controller;


import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.Definitions;
import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.dto.RegisterDroneDTO;
import org.musalasoft.controlltower.domain.service.DroneService;
import org.musalasoft.controlltower.transport.LoadMedicationReq;
import org.musalasoft.libs.response.RESTResponse;
import org.musalasoft.libs.response.RESTResponseManager;
import org.musalasoft.controlltower.transport.RegisterDroneRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/drone")
public class DroneController {

    private ModelMapper modelMapper;
    private DroneService droneService;

    @Autowired
    public DroneController(@Qualifier(Definitions.MODEL_MAPPER_BEAN_NAME) ModelMapper modelMapper, DroneService droneService) {
        this.modelMapper = modelMapper;
        this.droneService = droneService;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RESTResponse register(@Valid @RequestBody RegisterDroneRq request) {

        String id = droneService.register(modelMapper.map(request, RegisterDroneDTO.class));
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("id", id)
                .responseBuilder()
                .build();
    }

    @RequestMapping(path = "load/{drone-id}", method = RequestMethod.POST,
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RESTResponse loadMedication(@Valid @RequestBody LoadMedicationReq request, @PathVariable("drone-id") String droneId) {

        droneService.load(droneId, modelMapper.map(request, MedicationDTO.class));
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .responseBuilder()
                .build();
    }

    @RequestMapping(path = "available", method = RequestMethod.GET,
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RESTResponse getAvailableDrones() {

        List<String> availableDroneList = droneService.getAvailableDrones();
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("drones", availableDroneList)
                .responseBuilder()
                .build();
    }
}
