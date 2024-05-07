package com.jiaul.virtualtutor.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopRepo extends JpaRepository<Shop,Integer> {
}
