package com.lusa.apicarros;

import com.lusa.apicarros.entity.Carros;
import com.lusa.apicarros.repository.CarrosRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
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

}
