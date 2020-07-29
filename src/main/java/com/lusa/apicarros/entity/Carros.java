package com.lusa.apicarros.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = "id")
})
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull(message = "Marca não pode ser vazio")
    private String Marca;

    @NotNull(message = "Modelo não pode ser vazio")
    private String Modelo;

}
