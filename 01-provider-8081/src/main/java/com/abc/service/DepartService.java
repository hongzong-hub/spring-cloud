package com.abc.service;

import com.abc.bean.Depart;

import java.util.List;

public interface DepartService {
    boolean saveDepart(Depart depart);

    boolean removeDepartById(Integer id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(Integer id);

    List<Depart> listAllDeparts();
}
