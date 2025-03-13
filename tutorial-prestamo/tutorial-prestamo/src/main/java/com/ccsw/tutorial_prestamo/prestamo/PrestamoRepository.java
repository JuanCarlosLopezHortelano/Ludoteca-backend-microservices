package com.ccsw.tutorial_prestamo.prestamo;

import com.ccsw.tutorial_prestamo.prestamo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long>, JpaSpecificationExecutor<Prestamo> {

}