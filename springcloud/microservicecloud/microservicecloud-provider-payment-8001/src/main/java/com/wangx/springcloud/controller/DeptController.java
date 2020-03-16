package com.wangx.springcloud.controller;

import com.wangx.entity.Dept;
import com.wangx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/2/25 20:27
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    private String test;

    /**
     * 这块获取参数时必须加@RequestBody
     * 注解说明:
     * @RequestBody 主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
     *
     * 注：一个请求，只有一个RequestBody；一个请求，可以有多个RequestParam。
     *
     * 注：当同时使用@RequestParam（）和@RequestBody时，@RequestParam（）指定的参数可以是普通元素、
     *        数组、集合、对象等等(即:当，@RequestBody 与@RequestParam()可以同时使用时，原SpringMVC接收
     *        参数的机制不变，只不过RequestBody 接收的是请求体里面的数据；而RequestParam接收的是key-value
     *        里面的参数，所以它会被切面进行处理从而可以用普通元素、数组、集合、对象等接收)。
     *        即：如果参数时放在请求体中，传入后台的话，那么后台要用@RequestBody才能接收到；如果不是放在
     *        请求体中的话，那么后台接收前台传过来的参数时，要用@RequestParam来接收，或则形参前
     *        什么也不写也能接收。
     * ————————————————
     * 版权声明：本文为CSDN博主「justry_deng」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/justry_deng/article/details/80972817
     * @param dept
     * @return
     */
    @PostMapping(value = "/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }
    @GetMapping(value = "/get")
    public Dept get(Long id){
        return deptService.get(id);
    }
    @GetMapping(value = "/list")
    public List<Dept> list(){
        return deptService.list();
    }
}
