package org.musalasoft.controlltower.service;

import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.dto.RegisterDroneDTO;
import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.entity.Fleet;
import org.musalasoft.controlltower.domain.entity.Medication;
import org.musalasoft.controlltower.domain.entity.Model;
import org.musalasoft.controlltower.domain.excepion.ServiceLevelException;
import org.musalasoft.controlltower.domain.repository.DroneRepository;
import org.musalasoft.controlltower.domain.repository.FleetRepository;
import org.musalasoft.controlltower.domain.repository.ModelRepository;
import org.musalasoft.controlltower.domain.service.DroneService;
import org.musalasoft.controlltower.service.state.engine.Factory;
import org.musalasoft.controlltower.domain.service.state.engine.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {

    private final ModelMapper modelMapper;
    private DroneRepository droneRepository;
    private ModelRepository modelRepository;

    private FleetRepository fleetRepository;

    @Autowired
    public DroneServiceImpl(ModelMapper modelMapper, DroneRepository droneRepository, ModelRepository modelRepository, FleetRepository fleetRepository) {
        this.modelMapper = modelMapper;
        this.droneRepository = droneRepository;
        this.modelRepository = modelRepository;
        this.fleetRepository = fleetRepository;
    }
    @Override
    public Integer getDroneBatteryLevel(String droneSerial){
        if(droneSerial == null || "".equals(droneSerial)){
            throw new ServiceLevelException("drone serial number cannot be null or empty");
        }
        Drone drone = droneRepository.getDroneBySerialNumber(droneSerial);
        if(drone == null){
            throw new ServiceLevelException("cannot find a drone for serial number " + droneSerial);
        }
        return drone.getBatteryCapacity();
    }
    @Override
    public Medication checkMedicationLoad(String droneSerial) {
        if(droneSerial == null || "".equals(droneSerial)){
            throw new ServiceLevelException("drone serial number cannot be null or empty");
        }
        Drone drone = droneRepository.getDroneBySerialNumber(droneSerial);
        if(drone == null){
            throw new ServiceLevelException("cannot find a drone for serial number " + droneSerial);
        }
        return drone.getMedication();

    }

    @Override
    public String register(RegisterDroneDTO registerDrone) {
        Drone drone = modelMapper.map(registerDrone, Drone.class);

        Optional<Model> model = modelRepository.findById(registerDrone.getModel());
        if(model.isEmpty()){
            throw new ServiceLevelException("cannot find the model "+ registerDrone.getModel());
        }

        Optional<Fleet> fleet = fleetRepository.findById("default");
        if(fleet.isEmpty()){
            throw new ServiceLevelException("default fleet cannot be found");
        }
        drone.setFleet(fleet.get());
        drone.setModel(model.get());
        drone.setState(Factory.DroneState.getState(drone.getState()).getStates());
        return droneRepository.save(drone).getId();
    }

    @Override
    public List<String> getAvailableDrones() {
        List<Drone> droneList = droneRepository.getDroneByStateAndAndBatteryCapacityGreaterThan(State.States.IDLE, 25);
        return droneList.stream().map(drone -> drone.getSerialNumber()).collect(Collectors.toList());
    }

}
