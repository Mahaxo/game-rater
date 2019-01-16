package pl.coderslab.gamerater.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<D, I extends Serializable> {

    D save(D dto);

    D updateById(I id);

    D findById(I id);

    void removeById(I id);

    List<D> getAll();

}

