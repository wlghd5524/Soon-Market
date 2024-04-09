package org.nobase.nobase_backend.repository;

import org.nobase.nobase_backend.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes,Long> {
}
