package org.musalasoft.controlltower.domain.repository;

import org.musalasoft.controlltower.domain.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
}
