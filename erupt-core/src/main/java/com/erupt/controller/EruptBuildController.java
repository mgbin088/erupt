package com.erupt.controller;


import com.erupt.constant.RestPath;
import com.erupt.core.model.EruptModel;
import com.erupt.service.CoreService;
import com.google.gson.Gson;
import org.fusesource.jansi.Ansi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Erupt 页面结构构建信息
 * Created by liyuepeng on 9/28/18.
 */
@RestController
@RequestMapping(RestPath.ERUPT_BUILD)
public class EruptBuildController {

    @Autowired
    private CoreService startService;

    @GetMapping("/list/{erupt}")
    @ResponseBody
    public EruptModel getEruptTableView(@PathVariable("erupt") String eruptName) {
        Gson gson = new Gson();
        System.out.println(ansi().fg(Ansi.Color.RED).a(gson.toJson(CoreService.ERUPTS.get(eruptName))));
        return CoreService.ERUPTS.get(eruptName);
    }

    @GetMapping("/row/edit/{erupt}")
    @ResponseBody
    public void getEruptAddForms(@PathVariable("erupt") String erupt) {

    }

    @GetMapping("/row/edit/{erupt}/{id}")
    @ResponseBody
    public void getEruptEditForms(@PathVariable("erupt") String erupt, @PathVariable("id") Serializable id) {

    }


}
