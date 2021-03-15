package pers.lcy.graduationdesign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.lcy.graduationdesign.service.JavaSourceCompileExecService;

@Controller
public class CompileExecController {
    public static Logger logger= LoggerFactory.getLogger(CompileExecController.class);

    @Autowired
    JavaSourceCompileExecService javaSourceCompileExecService;

    @RequestMapping(value = "/runjavacode",method = {RequestMethod.POST})
    @ResponseBody
    public String runJavaCode(@RequestParam("source")String soucre,
                              @RequestParam("systemIn")String systemIN){
        String result= javaSourceCompileExecService.execute(soucre,systemIN);
        logger.info(result);
        return result;
    }
}
