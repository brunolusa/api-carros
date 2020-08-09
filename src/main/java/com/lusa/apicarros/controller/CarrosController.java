package com.lusa.apicarros.controller;

import com.lusa.apicarros.dto.v1.CarrosDTO;
import com.lusa.apicarros.entity.Carros;
import com.lusa.apicarros.entity.Carros_;
import com.lusa.apicarros.repository.CarrosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@Api(value = "Carros", tags = "Carros")
public class CarrosController {

    private final CarrosRepository carrosRepository;

    public CarrosController(CarrosRepository carrosRepository) {
        this.carrosRepository = carrosRepository;
    }

    @GetMapping("/api/v1/carros/{id}")
    @ApiOperation(value = "Retorna o carro filtrando pelo ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Carros encontrados", response = CarrosDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Carro não encontrado")
    })
    public ResponseEntity<Carros> getCarro(@PathVariable Long id) {
        return carrosRepository.findById(id).
                map(carros -> ResponseEntity.ok().body(carros)).
                orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/api/v1/carros")
    @ApiOperation(value = "Retorna todos os Carros existentes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Carros encontrados", response = CarrosDTO.class, responseContainer = "List"),
            @ApiResponse(code = 204, message = "Carro não encontrado")
    })
    public List<Carros> getAllCarros(@RequestParam(name = "id", required = false) Long id) {
        Example<Carros> example =
            Example.of( Carros.builder().id(id).build(),
                    ExampleMatcher.matchingAny().
                            withMatcher(Carros_.ID, ExampleMatcher.GenericPropertyMatchers.contains()));
        return carrosRepository.findAll(example);
    }

    @DeleteMapping("/api/v1/carros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Removendo um carro existente filtrando pelo ID", code = 204)
    @ApiResponses({
            @ApiResponse(code = 204, message = "Carro removido com sucesso"),
            @ApiResponse(code = 404, message = "Carro não encontrado", response = CarrosDTO.class)
    })
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return carrosRepository.findById(id)
                .map(carro -> {
                    carrosRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/v1/carros")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria um novo Carro", code = 201)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Carro criado com sucesso", response = CarrosDTO.class)
    })
    public Carros novoCarro(@Valid @RequestBody Carros carro) {
        return carrosRepository.save(new ModelMapper().map(carro, Carros.class));
    }

    @PutMapping("/api/v1/carros/{id}")
    @ApiOperation(value = "Atualiza um carro existente filtrando pelo ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Carro alterado com sucesso", response = CarrosDTO.class),
            @ApiResponse(code = 404, message = "Carro não encontrado")
    })
    public ResponseEntity<?> atualizaCarro(@RequestBody Carros carro, @PathVariable("id") long id) {
            return carrosRepository.findById(id)
                    .map(c -> {
                        c.setModelo(carro.getModelo());
                        c.setMarca(carro.getMarca());
                        Carros carroAtualizado = carrosRepository.save(c);
                        return ResponseEntity.accepted().body(carroAtualizado);
                    }).orElse(ResponseEntity.notFound().build());
    }

}
