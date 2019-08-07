package ${package}.controller;

import ${package}.base.DefaultController;
import ${package}.entity.po.${className}PO;
import ${package}.service.${className}Service;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author : ${author}
* @date : ${date}
* @version 1.0
*/
@RestController
@RequestMapping("/${className}")
@Api(value = "/${className}")
public class ${className}Controller extends DefaultController<${className}Service, ${className}PO> {



}