package com.bairagi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class RootController {
	@RequestMapping(value="/")
	public String index(){
		return "index";
	}

}
