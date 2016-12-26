package com.food.controller;import com.food.model.MethodLogModel;import com.food.service.TestService;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.util.StringUtils;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.servlet.ModelAndView;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;/** * Created by user on 16-11-5. */@Controller@RequestMapping(value = "/test")public class TestController {    private Logger logger = LoggerFactory.getLogger(TestController.class);    @Autowired    private TestService testService;    //访问地址：http://localhost:8011/test/success    @RequestMapping(value = "/success", method = RequestMethod.GET)    public ModelAndView success(int id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {        if (id <= 0) {            ModelAndView modelAndView = new ModelAndView("success");            modelAndView.addObject("message", "id必须大于0");            return modelAndView;        }        MethodLogModel methodLogModel = testService.TestFunction(id);        ModelAndView modelAndView = new ModelAndView("success");        if (methodLogModel == null) {            modelAndView.addObject("message", null);        } else {            modelAndView.addObject("message", methodLogModel.toString());        }        return modelAndView;    }    //访问地址：http://localhost:8080/Test/returnString    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码    /**     *     * @param id     * @return     */    @ResponseBody    @RequestMapping(value = "test", produces = {"text/plain;charset=UTF-8"})    public String test(int id) {        if (id <= 0) {            return "参数id必须大于0";        }        MethodLogModel methodLogModel = testService.TestFunction(id);        if (methodLogModel != null) {            return methodLogModel.toString();        }        return "null";    }}