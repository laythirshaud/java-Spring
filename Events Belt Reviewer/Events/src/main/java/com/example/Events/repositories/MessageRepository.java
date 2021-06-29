package com.example.Events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Events.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}