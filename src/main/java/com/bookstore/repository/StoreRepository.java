package com.bookstore.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.BookStoreModel;

@Repository
public interface StoreRepository extends CrudRepository<BookStoreModel, Long> {}
