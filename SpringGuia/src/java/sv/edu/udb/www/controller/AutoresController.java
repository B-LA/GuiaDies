/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.edu.udb.www.entities.Autores;
import sv.edu.udb.www.model.AutoresModel;

/*
 *
 * @author neon
 */
@Controller
@RequestMapping("autores")
public class AutoresController {
    
    AutoresModel autoresModel = new AutoresModel();
    
    @RequestMapping("list")
    public String listarAutores(Model model){
        
        model.addAttribute("listarAutores",autoresModel.listarAutores());
        
        return "autores/listar";
        
    }
    
    @RequestMapping(value = "create",method = RequestMethod.GET )
    public String nuevoAutor(Model model){
        model.addAttribute("autor",new Autores());
        return "autores/nuevo";
    }
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String insertarAutor(@ModelAttribute("autor") Autores autor,Model model, RedirectAttributes atributos){
        if(autoresModel.insertarAutor(autor)>0){
            atributos.addAttribute("exito", "Autor registrado exitosamente");
            
            return "redirect:/autores/list";
        }else{
            model.addAttribute("autor",autor);
            return "/autores/nuevo";
        }
    }
    
    @RequestMapping(value = "edit/{codigo}",method = RequestMethod.GET)
    public String obtenerAutor(@PathVariable("codigo") String codigo,Model model){
        model.addAttribute("autor",autoresModel.obtenerAutor(codigo));
        return "autores/editar";
    }
       
    @RequestMapping(value = "edit/{codigo}",method = RequestMethod.POST)
    public String modificarAutor(Autores autor,Model model,RedirectAttributes atributo){
        if(autoresModel.modificarAutor(autor)>0){
            atributo.addAttribute("Exito","Autor modificado");
            return "redirect:/autores/list";
        }else{
            model.addAttribute("autor",autor);
            return "/autores/editar";
        }
    }
    
    @RequestMapping("delete/{codigo}")
    public String eliminarAutor(@PathVariable("codigo") String codigo,Model model,RedirectAttributes atributos){
        if(autoresModel.eliminarAutor(codigo)>0){
            atributos.addAttribute("Exito","Editorial eliminado exitosamente");
        } else{
        atributos.addAttribute("Fracaso","No se puede eliminar este autor");
    }
        return "redirect:/autores/list";
    }
    
}
