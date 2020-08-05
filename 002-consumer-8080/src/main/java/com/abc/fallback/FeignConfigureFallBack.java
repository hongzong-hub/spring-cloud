package com.abc.fallback;

import com.abc.bean.Depart;
import com.abc.configure.FeignConfigure;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignConfigureFallBack implements FeignConfigure {

    @Override
    public List<Depart> hello() {
        return null;
    }
}
