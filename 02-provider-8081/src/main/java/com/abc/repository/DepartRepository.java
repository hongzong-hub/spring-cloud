package com.abc.repository;

import com.abc.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//第一个泛型是，当前Repository所操作对象的类型
//第二个泛型是，当前Repository所操作对象的id类型
public interface DepartRepository extends JpaRepository<Depart, Integer> {

    List<Depart> findByName(String name);
}
