package com.abc.configure;

import com.abc.bean.Depart;
import com.abc.fallback.FeignConfigureFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Component
@FeignClient(name= "abcmsc-provider-depart",fallback = FeignConfigureFallBack.class)//fallback 熔断是服务降级返回调用的类
public interface FeignConfigure {

    @RequestMapping(value = "/provider/depart/getAll")
    List<Depart> hello();
}
