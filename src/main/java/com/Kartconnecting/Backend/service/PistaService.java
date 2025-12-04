package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.Pista;
import java.util.List;

public interface PistaService {

    List<Pista> findAll();

    Pista findById(Integer id);

    Pista save(Pista pista);

    Pista update(Integer id, Pista pista);

    void delete(Integer id);
}




