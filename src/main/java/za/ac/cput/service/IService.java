package za.ac.cput.service;
import za.ac.cput.domain.Country;

import java.util.List;
import java.util.Optional;

    public interface IService <T, ID> {
        T save(T t);
        Optional<T> read(ID id);
        void delete(ID id);
        List<T> findAll();
    }

