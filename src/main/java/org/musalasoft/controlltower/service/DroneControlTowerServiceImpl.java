package org.musalasoft.controlltower.service;

import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.entity.Medication;
import org.musalasoft.controlltower.domain.excepion.ServiceLevelException;
import org.musalasoft.controlltower.domain.repository.DroneRepository;
import org.musalasoft.controlltower.domain.repository.MedicationRepository;
import org.musalasoft.controlltower.domain.service.DroneControlTowerService;
import org.musalasoft.controlltower.service.state.engine.ControlPanel;
import org.musalasoft.controlltower.service.state.engine.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneControlTowerServiceImpl implements DroneControlTowerService {

    private DroneRepository droneRepository;

    private MedicationRepository medicationRepository;
    private ModelMapper modelMapper;

    @Autowired
    public DroneControlTowerServiceImpl(DroneRepository droneRepository, ModelMapper modelMapper, MedicationRepository medicationRepository) {
        this.droneRepository = droneRepository;
        this.modelMapper = modelMapper;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public void load(String droneSerial, MedicationDTO medicationDTO) {
        Drone drone = droneRepository.getDroneBySerialNumber(droneSerial);
        if (drone == null) {
            throw new ServiceLevelException("Cannot find the drone by serial id-" + droneSerial);
        }
        Medication medication = modelMapper.map(medicationDTO, Medication.class);
        medication.setDrone(drone);
        medication = medicationRepository.save(medication);
        drone.setMedication(medication);
        /*
           Handle drone state cycle by state engine.
         */
        ControlPanel controlPanel = Factory.DroneController.getController(drone);
        controlPanel.startLoading(controlPanel);

        droneRepository.save(controlPanel.getDrone());
    }

    public void completeLoading(String droneSerial) {
        Drone drone = droneRepository.getDroneBySerialNumber(droneSerial);
        if (drone == null) {
            throw new ServiceLevelException("Cannot find the drone by serial id-" + droneSerial);
        }

        /*
           Handle drone state cycle by state engine.
         */
        ControlPanel controlPanel = Factory.DroneController.getController(drone);
        controlPanel.completeLoading(controlPanel);

        droneRepository.save(controlPanel.getDrone());
    }


}
