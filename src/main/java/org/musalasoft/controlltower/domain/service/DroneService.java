package org.musalasoft.controlltower.domain.service;

import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.dto.RegisterDroneDTO;
import org.musalasoft.controlltower.domain.entity.Medication;

import java.util.List;

public interface DroneService {

    Integer getDroneBatteryLevel(String droneSerial);

    Medication checkMedicationLoad(String droneSerial);
    String register(RegisterDroneDTO registerDrone);
    List<String> getAvailableDrones();
}
