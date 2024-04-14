package com.example.ims.repository;

import com.example.ims.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Long> {

}
