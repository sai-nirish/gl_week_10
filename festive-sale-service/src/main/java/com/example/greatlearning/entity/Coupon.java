package com.example.greatlearning.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon{

    @Id
    private Integer id;

    @Column(unique = true)
    private String code;

    @Column
    private Integer discountPercent;

}
