package com.ControllersViews.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ControllersViews.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
