package com.dol.school.service.api;

import java.util.List;
import java.util.Map;

public interface IBaseService {
    /**
     *
     * @param map
     * @return
     */
    List<Map<String,Object>> getAll(Map<String,Object> map);

    /**
     *
     * @param id
     * @return
     */
    Map<String,Object> getById(String id);


    Integer add(Map<String,Object> map);

    Integer edit(Map<String,Object> map);

    Integer delete(String id);
}
