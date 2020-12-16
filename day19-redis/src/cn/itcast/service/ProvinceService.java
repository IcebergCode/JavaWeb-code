package cn.itcast.service;

import cn.itcast.domian.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
