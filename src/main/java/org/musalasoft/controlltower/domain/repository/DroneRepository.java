package org.musalasoft.controlltower.domain.repository;

import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.service.state.engine.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {
    List<Drone> getDroneByStateAndAndBatteryCapacityGreaterThan(State.States states, Integer batteryCapacity);
    Drone getDroneBySerialNumber(String serialNumber);
}
