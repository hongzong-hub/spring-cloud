package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    private DepartService departService;
    //申明服务发现客户端
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean delHandler(@PathVariable Integer id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandler(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandler(@PathVariable Integer id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/getAll")
    public List<Depart> ListHandler() {

        return departService.listAllDeparts();
    }
    @GetMapping("/discovery")
    public List<String> discoveryHandler(){
        List<String> services = client.getServices();
        for(String name:services){
            //获取当前遍历微服务名称的所有提供者主机
            List<ServiceInstance> instances = client.getInstances(name);
            for(ServiceInstance instance:instances)

            {
                //获取当前提供者的唯一标识:service id
                String serviceId = instance.getServiceId();
                String instancedId= instance.getInstanceId();
                String host = instance.getHost();
                Map<String, String> metadata = instance.getMetadata();
                System.out.println("servicesId="+serviceId);
                System.out.println("instanceId="+instancedId);
                System.out.println("host="+host);
                System.out.println("metadata="+metadata);


            }

        }
        return services;
    }
}
