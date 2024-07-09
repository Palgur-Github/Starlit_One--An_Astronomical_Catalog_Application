package com.Ironhack.Starlit_One.repository;

import com.Ironhack.Starlit_One.model.StarPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarPatternRepository extends JpaRepository<StarPattern, Integer> {
    List<StarPattern> findAllByTranslation(String translation);
    List<StarPattern> findAllByDiscoveryPeriod(String discoveryPeriod);
    List<StarPattern> findAllByPatternType(String patternType);

}
