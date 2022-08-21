package org.musalasoft.controlltower.domain.service;

import org.musalasoft.controlltower.domain.dto.MedicationDTO;
import org.musalasoft.controlltower.domain.dto.RegisterDroneDTO;

import java.util.List;

public interface DroneService {
    String register(RegisterDroneDTO registerDrone);
    List<String> getAvailableDrones();

    void load(String serialNumber, MedicationDTO medication);
}
