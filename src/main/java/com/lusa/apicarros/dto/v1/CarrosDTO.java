package com.lusa.apicarros.dto.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Carros")
public class CarrosDTO {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(required = true, example = "Chevrolet")
    private String marca;

    @ApiModelProperty(position = 1, required = true, example = "Celta")
    private String modelo;

    public CarrosDTO(Long id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
