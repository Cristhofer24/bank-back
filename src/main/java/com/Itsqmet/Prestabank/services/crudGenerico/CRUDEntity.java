package com.Itsqmet.Prestabank.services.crudGenerico;

public interface CRUDEntity <T, ID> {

    T create(T entity);

    T read(ID id);

    T update(T entity);

    void delete(ID id);

}
