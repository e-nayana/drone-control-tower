package org.musalasoft.controlltower.transport.controller;


import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.service.DroneControlTowerService;
import org.musalasoft.controlltower.transport.LoadMedicationReq;
import org.musalasoft.libs.response.RESTResponse;
import org.musalasoft.libs.response.RESTResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/drone-control")
public class DroneControlTowerController {

    private ModelMapper modelMapper;
    private DroneControlTowerService droneControlTowerService;

    @Autowired
    public DroneControlTowerController(ModelMapper modelMapper, DroneControlTowerService droneControlTowerService) {
        this.modelMapper = modelMapper;
        this.droneControlTowerService = droneControlTowerService;
    }

    @RequestMapping(path = "load/{drone-serial}", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RESTResponse loadMedication(@Valid @RequestBody LoadMedicationReq request, @PathVariable("drone-serial") String droneSerial) {

        droneControlTowerService.load(droneSerial, modelMapper.map(request, MedicationDTO.class));
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .responseBuilder()
                .build();
    }

}
