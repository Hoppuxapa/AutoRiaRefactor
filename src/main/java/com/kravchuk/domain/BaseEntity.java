package com.kravchuk.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public @Data
class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}