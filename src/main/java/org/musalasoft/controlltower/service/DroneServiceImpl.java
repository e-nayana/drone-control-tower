package org.musalasoft.controlltower.service;

import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.dto.RegisterDroneDTO;
import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.excepion.ServiceLevelException;
import org.musalasoft.controlltower.domain.repository.DroneRepository;
import org.musalasoft.controlltower.domain.service.DroneService;
import org.musalasoft.controlltower.service.state.engine.Factory;
import org.musalasoft.controlltower.domain.service.state.engine.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {

    private ModelMapper modelMapper;
    private DroneRepository droneRepository;

    @Autowired
    public DroneServiceImpl(ModelMapper modelMapper, DroneRepository droneRepository) {
        this.modelMapper = modelMapper;
        this.droneRepository = droneRepository;
    }

    @Override
    public String register(RegisterDroneDTO registerDrone) {
        Drone drone = modelMapper.map(registerDrone, Drone.class);
        drone.setState(Factory.DroneState.getState(drone.getState()).getStates());
        return droneRepository.save(drone).getId();
    }

    @Override
    public void load(String serialNumber, MedicationDTO medication) {
       Drone drone = droneRepository.getDroneBySerialNumber(serialNumber);
       if(drone == null){
           throw new ServiceLevelException("Cannot find the drone by serial id-" + serialNumber);
       }


    }

    @Override
    public List<String> getAvailableDrones() {
        List<Drone> droneList = droneRepository.getDroneByStateAndAndBatterCapacityGreaterThan(State.States.IDLE, 25);
        return droneList.stream().map(drone -> drone.getSerialNumber()).collect(Collectors.toList());
    }

}
