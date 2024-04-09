package org.nobase.nobase_backend.repository;

import org.nobase.nobase_backend.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes,Long> {
}
