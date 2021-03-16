package com.cashstar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
//@Table(name="HelloWorld", schema = "mock_processor")
public class HelloWorld extends BaseEntity {
    private String text;
}
