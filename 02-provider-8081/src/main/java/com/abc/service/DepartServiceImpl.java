package com.abc.service;

import com.abc.bean.Depart;
import com.abc.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository departRepository;

    @Override
    public boolean saveDepart(Depart depart) {
        //对于save（)的参数，根据其id的不同有以下三种情况
        //depart的id为null
        //depart的id不为null，且DB中的该id存在，save()执行时修改
        //depart的id不为null，且DB中该id不存在，save()执行插入操作，
        //但其插入后的记录id值并不是这里指定的id,而是其根据指定的id生成的策略所生成的id
        Depart obj = departRepository.save(depart);

        return obj != null ? true : false;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if (departRepository.existsById(id)) {
            departRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = departRepository.save(depart);

        return obj != null ? true : false;
    }

    @Override
    public Depart getDepartById(Integer id) {
        if (departRepository.existsById(id)) {
            return departRepository.getOne(id);
        }
        return null;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return departRepository.findAll();
    }
}
