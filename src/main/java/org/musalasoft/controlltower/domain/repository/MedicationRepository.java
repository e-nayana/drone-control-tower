package org.musalasoft.controlltower.domain.repository;

import org.musalasoft.controlltower.domain.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String> {
}
