package com.demo.base;

import com.common.base.BaseController;
import com.common.base.BasePO;
import com.common.base.BaseService;
import com.demo.entity.Students;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author : shenhao
 * @date : 2019/7/31 16:43
 */
public class DefaultController<S extends BaseService,P extends BasePO> extends BaseController<S,P> {

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody @Valid P p){
        service.insert(p);
        return "ok";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody @Valid P p){
        service.delete(p);
        return "ok";
    }

}
