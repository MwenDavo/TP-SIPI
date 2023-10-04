package ar.edu.uade.sipi.servicios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class ServicioGenerico<T, ID extends Serializable> implements IServicioGenerico<T, ID> {

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> object = getDao().findById(id);
        return object.orElse(null);
    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getDao().findAll().forEach(returnList::add);
        return returnList;
    }

    public abstract CrudRepository<T, ID> getDao();
}
