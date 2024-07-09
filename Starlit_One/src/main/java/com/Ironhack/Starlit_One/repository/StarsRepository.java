package com.Ironhack.Starlit_One.repository;

import com.Ironhack.Starlit_One.model.Stars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarsRepository extends JpaRepository<Stars, String> {
}
