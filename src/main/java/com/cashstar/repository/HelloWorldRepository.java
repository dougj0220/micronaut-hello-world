package com.cashstar.repository;

import com.cashstar.entity.HelloWorld;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
    HelloWorld findByText(String text);
}
