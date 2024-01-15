package com.ssau.lab4.models;

import lombok.*;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail_condition")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MailCondition extends BaseModel {

    @Column(name = "address")
    private String address;

    @Column(name = "condition")
    private String condition;

}