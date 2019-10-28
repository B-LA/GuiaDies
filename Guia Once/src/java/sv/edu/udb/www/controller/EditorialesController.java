/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.edu.udb.www.entities.Editoriales;
import sv.edu.udb.www.model.EditorialesModel;

/**
 *
 * @author neon
 */

@Controller
@RequestMapping("editoriales")
public class EditorialesController {
    
    EditorialesModel editorialesModel = new EditorialesModel();
    
    @RequestMapping("list")
    public String listarEditoriales(Model model){
        
        model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
        
        
        return "editoriales/listar";
    }
    
    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String nuevoEditorial(Model model){
        model.addAttribute("editorial", new Editoriales());
        return "editoriales/nuevo";
    }
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String insertarEditorial(@ModelAttribute("editorial") Editoriales editorial,
            Model model, BindingResult result,RedirectAttributes atributos){
       
        if(result.hasErrors()){
             model.addAttribute("editorial",editorial);
            return "/editoriales/nuevo";
        }
        
        if(editorialesModel.insertarEditorial(editorial)>0){
            atributos.addFlashAttribute("exito","Edditorial registrado exitosamente");
            
            return "redirect:/editoriales/list";
        }else{
            
           model.addAttribute("editorial",editorial);
           result.addError(new ObjectError("codigoEditorial","Ya existe una editorial con este codigo"));
            return "editoriales/nuevo";
        }
            
    }
    
    @RequestMapping(value = "edit/{codigo}", method = RequestMethod.GET)
    public String obtenerEditorial(@PathVariable("codigo") String codigo, Model model){
       model.addAttribute("editorial",editorialesModel.obtenerEditorial(codigo));
       return "editoriales/editar";
    }
    
    
    @RequestMapping(value = "edit/{codigo}",method = RequestMethod.POST)
    public String modificarEditorial(Editoriales editorial,Model model, RedirectAttributes atributos){
        if(editorialesModel.modificarEditorial(editorial)>0){
            atributos.addFlashAttribute("Exito","Editorial modificado exitosamente");
            return "redirect:/editoriales/list";
        }else{
            model.addAttribute("editorial",editorial);
            return "editoriales/editar";
        }
        
    }
    
    @RequestMapping("delete/{codigo}")
    public String eliminarEditorial(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos){
    if(editorialesModel.eliminarEditorial(codigo)>0){
        atributos.addFlashAttribute("exito","Editorial eliminado exitosamente");
    }else{
        atributos.addFlashAttribute("Fracaso","No se puede eliminar este editorial");
    }
    return "redirect:/editoriales/list";
    }
    
}
