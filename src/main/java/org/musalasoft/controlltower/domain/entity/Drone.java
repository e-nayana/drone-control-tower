package org.musalasoft.controlltower.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.musalasoft.controlltower.domain.service.state.engine.State;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fleet_id", referencedColumnName = "id")
    private Fleet fleet;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    @OneToOne(fetch = FetchType.EAGER,
            mappedBy = "drone")
    private Medication medication;

    @Column(name = "battery_capacity")
    private Integer batteryCapacity;
    private State.States state;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
