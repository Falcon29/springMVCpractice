/*
 *
 * =======================================================================
 *
 * Copyright (c) 2009-2021 Sony Network Entertainment International, LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Sony Network Entertainment International, LLC.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with
 * Sony Network Entertainment International, LLC.
 *
 * =======================================================================
 *
 * For more information, please see http://www.sony.com/SCA/outline/corporation.shtml
 *
 */

package ru.ache.springmvcpractice.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {    //можно не передавать параметры
        String name = request.getParameter( "name" );
        String surname = request.getParameter( "surname" );

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    /**
    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam("surname") String surname) {    //нужно передавать параметры  либо required=false
        System.out.println("Hello, " + name + " " + surname);

        return "first/goodbye";
    }    */

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute( "message", "Hello, " + name + " " + surname );

        return "first/goodbye";
    }
}
