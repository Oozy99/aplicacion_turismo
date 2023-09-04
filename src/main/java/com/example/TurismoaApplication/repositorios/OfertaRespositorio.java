package com.example.TurismoaApplication.repositorios;

import com.example.TurismoaApplication.modelos.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRespositorio  extends JpaRepository<Oferta,Integer> {
}
