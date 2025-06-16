package com.ferma.terenuri_agricole.ierbicid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IerbicidRepository extends JpaRepository<Ierbicid,Long> {
}
