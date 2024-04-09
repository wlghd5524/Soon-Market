package org.nobase.nobase_backend.repository;

import org.nobase.nobase_backend.entity.LifeGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeGoodsRepository extends JpaRepository<LifeGoods,Long> {
}
