package edu.miu.e_registrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class SystAdminController {
    @Controller
    @RequestMapping("/eregistrar")
    public class SysAdminController {

        @GetMapping("/sysadmin")
        public String displaySysAdminPage() {
            return "secured/sysadmin";
        }
    }

}
