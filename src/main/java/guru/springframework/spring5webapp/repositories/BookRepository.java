/*
 * This code is part of pirobase PIM.
 * This code is developed by the pirobase imperia gmbh.
 * Do not make any changes.
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Copyright (C) pirobase imperia gmbh
 * All Rights Reserved.
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Book;

/**
 * BookRepository
 *
 * @since Pirobase PIM<sup>®</sup> 9.0
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
