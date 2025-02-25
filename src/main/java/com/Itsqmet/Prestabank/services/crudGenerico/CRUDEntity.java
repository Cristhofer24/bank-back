package com.Itsqmet.Prestabank.services.crudGenerico;

public interface CRUDEntity <T, ID> {

    // Método para crear una entidad
    T create(T entity);

    // Método para leer una entidad por ID
    T read(ID id);

    // Método para actualizar una entidad
    T update(T entity);

    // Método para eliminar una entidad por ID
    void delete(ID id);

}
