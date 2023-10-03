package com.ensat.services;

import com.ensat.entities.Error;

public interface ErrorService {

    Iterable<Error> listAllErrors();

    Error getErrorById(Integer id);

    Error saveError(Error error);

    Error editdb(Error error);

    void deleteError(Integer id);

}
