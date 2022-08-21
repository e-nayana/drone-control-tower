package org.musalasoft.controlltower.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.musalasoft.controlltower.domain.service.state.engine.State;

import javax.persistence.*;

@Entity
@Table(name = "drone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    private String serialNumber;

    @OneToOne(fetch = FetchType.EAGER,
            mappedBy = "id")
    private Model model;

    @OneToOne(fetch = FetchType.EAGER,
            mappedBy = "id")
    private Medication medication;

    private Integer batterCapacity;
    private State.States state;
}
