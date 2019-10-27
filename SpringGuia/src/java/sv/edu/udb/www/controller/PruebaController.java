/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author neon
 */
@Controller
public class PruebaController {
    
    @RequestMapping("saludo")
    public String saludar(Model model){
        model.addAttribute("nombre","Guillermo Calderon");
        return "hola";
    }
    
}
