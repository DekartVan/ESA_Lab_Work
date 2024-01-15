package com.ssau.lab4.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "events_log", schema = "public")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Event extends BaseModel {

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "uuid")
    private UUID objectUuid;
}
