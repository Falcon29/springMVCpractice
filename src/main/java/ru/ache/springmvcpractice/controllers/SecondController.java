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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exitMethod() {
        return "second/exit";
    }

    @GetMapping("/calculator")
    public String calculatorMethod(@RequestParam("a") int a,
                                   @RequestParam("b") int b,
                                   @RequestParam("action") String action,
                                   Model model) {
        double result = 0;

        switch (action) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mult":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                throw new IllegalStateException( "Unexpected value: " + action );
        }
        model.addAttribute( "result", result );
        return "second/calculator";
    }
}
