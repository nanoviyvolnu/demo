package com.example.demo;


import com.example.demo.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
