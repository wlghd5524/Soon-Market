package org.nobase.nobase_backend.repository;

import org.nobase.nobase_backend.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long> {
}
