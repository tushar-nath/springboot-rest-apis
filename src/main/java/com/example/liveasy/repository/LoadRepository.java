package com.example.liveasy.repository;

import com.example.liveasy.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {

    List<Load> findByShipperId (final String shipperId);

    Optional<Load> findByLoadId (final Long loadId);

}
