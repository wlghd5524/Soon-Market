package org.nobase.nobase_backend.repository;

import org.nobase.nobase_backend.entity.Elec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElecRepository extends JpaRepository<Elec,Long> {
}
