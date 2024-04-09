package org.nobase.nobase_backend.repository;

import org.nobase.nobase_backend.entity.Etc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtcRepository extends JpaRepository<Etc,Long> {
}
