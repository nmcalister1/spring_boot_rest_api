package com.nmcalister.database_postgres.services.impl;

import com.nmcalister.database_postgres.domain.entities.AuthorEntity;
import com.nmcalister.database_postgres.repositories.AuthorRepository;
import com.nmcalister.database_postgres.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

        private AuthorRepository authorRepository;

        public AuthorServiceImpl(AuthorRepository authorRepository) {
            this.authorRepository = authorRepository;
        }

        @Override
        public AuthorEntity save(AuthorEntity authorEntity) {
            return authorRepository.save(authorEntity);
        }

        @Override
        public List<AuthorEntity> findAll() {
            return StreamSupport.stream(authorRepository.findAll().spliterator(), false).collect(Collectors.toList());
        }

        @Override
        public Optional<AuthorEntity> findOne(Long id) {
            return authorRepository.findById(id);
        }

        @Override
        public boolean isExists(Long id) {
            return authorRepository.existsById(id);
        }

        @Override
        public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity) {
            authorEntity.setId(id);
            return authorRepository.findById(id).map(existingAuthor -> {
                if (authorEntity.getName() != null) {
                    existingAuthor.setName(authorEntity.getName());
                }
                if (authorEntity.getAge() != null) {
                    existingAuthor.setAge(authorEntity.getAge());
                }
                return authorRepository.save(existingAuthor);
            }).orElseThrow(() -> new RuntimeException("Author not found"));
        }

        @Override
        public void delete(Long id) {
            authorRepository.deleteById(id);
        }
}
