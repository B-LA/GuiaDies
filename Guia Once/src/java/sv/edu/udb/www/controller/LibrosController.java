/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.edu.udb.www.entities.Libros;
import sv.edu.udb.www.model.AutoresModel;
import sv.edu.udb.www.model.EditorialesModel;
import sv.edu.udb.www.model.GenerosModel;
import sv.edu.udb.www.model.LibrosModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("libros")
public class LibrosController {

    EditorialesModel editorialesModel = new EditorialesModel();
    GenerosModel generosModel = new GenerosModel();
    AutoresModel autoresModel = new AutoresModel();
    LibrosModel librosModel = new LibrosModel();

    @RequestMapping("list")
    public String listarLibros(Model model) {
        model.addAttribute("listaLibros", librosModel.listarLibros());
        return "libros/listar";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String nuevoLibro(Model model) {
        model.addAttribute("listaEditoriales", editorialesModel.listarEditoriales());
        model.addAttribute("listaAutores", autoresModel.listarAutores());
        model.addAttribute("listaGeneros", generosModel.listarGeneros());
        model.addAttribute("libro", new Libros());
        return "libros/nuevo";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String insertarLibro(@ModelAttribute("libro") Libros libro, Model model, RedirectAttributes atributos) {
        if (librosModel.insertarLibro(libro) > 0) {
            atributos.addFlashAttribute("exito", "Libro registrado exitosamente");
            return "redirect:/libros/list";
        } else {
            model.addAttribute("listaEditoriales", editorialesModel.listarEditoriales());
            model.addAttribute("listaAutores", autoresModel.listarAutores());
            model.addAttribute("listaGeneros", generosModel.listarGeneros());
            model.addAttribute("libro", libro);
            return "libros/nuevo";
        }

    }

}
