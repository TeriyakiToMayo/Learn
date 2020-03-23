package com.javatpoint.controllers;  

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.javatpoint.JDBC.JDBC_Util;
import com.javatpoint.beans.Employee;

  
@Controller  
public class EmployeeController {  
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @RequestMapping("/hello")  
    public String display(Model m)  
    {  
        m.addAttribute("emp", new Employee());  
        return "viewpage";  
    }  
    
    @RequestMapping("/helloagain")  
    public String submitForm( @Valid @ModelAttribute("emp") Employee e, BindingResult br)  
    {  
    	
    	System.out.println("password " + e.getPassword());
    	
        if(br.hasErrors())  
        {  
            return "viewpage";  
        }  
        else  
        {  
        return "final";  
        }  
        
        
    }  
}  

