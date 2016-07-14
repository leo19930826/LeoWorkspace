package com.leo.test;

import java.io.Serializable;

/**
 * Created by LI on 16/5/20.
 */
public interface IBaseDao<T extends Object, PK extends Serializable> {
    public T get(Class<T> entityClass);

    public void getApi();
}
