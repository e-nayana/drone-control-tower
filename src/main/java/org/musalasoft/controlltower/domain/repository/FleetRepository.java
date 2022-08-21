package org.musalasoft.controlltower.domain.repository;

import org.musalasoft.controlltower.domain.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, String> {
}
