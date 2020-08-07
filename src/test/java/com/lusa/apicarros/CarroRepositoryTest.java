package com.lusa.apicarros;

import com.lusa.apicarros.entity.Carros;
import com.lusa.apicarros.repository.CarrosRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarroRepositoryTest {

    @Autowired
    private CarrosRepository carrosRepository;

    @Test
    public void buscarTodosOsCarros(){
        List<Carros> carrosList = carrosRepository.findAll();
        assertThat(carrosList.size()).isEqualTo(7);
    }
    @Test
    public void buscarCarroPorId(){
        Optional<Carros> carro = carrosRepository.findById(1L);
        assertThat(carro.get().getMarca().equals("Ford"));
        assertThat(carro.get().getModelo().equals("Focus"));
    }
    @Test
    public void deleteCarroPorId(){
        carrosRepository.deleteById(2L);
    }
    @Test
    public void postCarro(){
        Carros c = new Carros();

        c.setMarca("Teste");
        c.setModelo("Teste");
        c.setId(99L);


        Carros novoCarro = carrosRepository.save(c);
        assertThat(novoCarro.getMarca().equals("Teste"));
        assertThat(novoCarro.getModelo().equals("Teste"));
    }
}