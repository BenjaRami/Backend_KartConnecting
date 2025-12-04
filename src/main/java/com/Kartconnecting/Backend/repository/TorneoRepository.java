package com.Kartconnecting.Backend.repository;

import com.Kartconnecting.Backend.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
}
