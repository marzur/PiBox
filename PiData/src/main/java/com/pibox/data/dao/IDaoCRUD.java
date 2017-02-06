package com.pibox.data.dao;

/**
 * Created by Marcin Żuralski on 30.09.2016.
 * <p>
 * T - Transfer Object (Entity or Document) class
 * X - Class of the id column
 */
public interface IDaoCRUD<T, X> {

    /**
     * Save the instance (new or existed) to db
     *
     * @param s
     * @return
     */
    public T insert(T s);

    /**
     * Delete the instance from db
     *
     * @param s
     */
    public void delete(T s);


    /**
     * Find an instance by ID
     *
     * @param id
     */
    public T findById(X id);
}
