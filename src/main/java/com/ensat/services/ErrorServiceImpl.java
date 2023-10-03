package com.ensat.services;

import com.ensat.entities.Error;
import com.ensat.repositories.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {
     @Autowired
    private ErrorRepository errorRepository;

    @Override
    public Iterable<Error> listAllErrors() {
        return errorRepository.findAll();
    }

    @Override
    public Error getErrorById(Integer id) {
        return errorRepository.findById(id).get();
    }

    @Override
    public Error saveError(Error error) {
        return errorRepository.save(error);
    }

    @Override
    public Error editdb(Error error) {
        Integer id = error.getId();
        errorRepository.deleteById(id);
        return errorRepository.save(error);
    }

    @Override
    public void deleteError(Integer id) {
        errorRepository.deleteById(id);
    }

}
