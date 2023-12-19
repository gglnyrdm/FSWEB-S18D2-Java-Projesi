package com.workintech.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit extends Plant{
    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    @NotNull
    private FruitType fruitType;
}
