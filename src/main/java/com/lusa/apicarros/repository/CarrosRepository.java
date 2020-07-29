package com.lusa.apicarros.repository;

import com.lusa.apicarros.entity.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface CarrosRepository extends JpaRepository<Carros, Long>, JpaSpecificationExecutor<Carros> {

    Optional<Carros> findById(@Param("id") Long id);

    @Transactional
    void deleteById(@Param("id") Long id);

}
