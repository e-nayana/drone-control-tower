package org.musalasoft.controlltower.domain.service;

import org.musalasoft.controlltower.domain.dto.MedicationDTO;

public interface DroneControlTowerService {
    void load(String droneSerial, MedicationDTO medication);
    void completeLoading(String droneSerial);
}
