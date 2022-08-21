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

    @RequestMapping(path = "get-medication-load/{drone-serial}", method = RequestMethod.POST,
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RESTResponse getMedicationLoad(@PathVariable("drone-serial") String droneSerial) {

        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("serial_number", droneSerial)
                .setBodyAttribute("medication_load", droneService.checkMedicationLoad(droneSerial))
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

    @RequestMapping(path = "battery-level/{drone-serial}", method = RequestMethod.GET,
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RESTResponse getBatteryLevel(@PathVariable("drone-serial") String droneSerial) {

        droneService.getDroneBatteryLevel(droneSerial);
        return RESTResponseManager.headerBuilder(HttpStatus.CREATED)
                .bodyBuilder()
                .setBodyAttribute("serial_number", droneSerial)
                .setBodyAttribute("battery_level", droneService.getDroneBatteryLevel(droneSerial))
                .responseBuilder()
                .build();
    }
}
