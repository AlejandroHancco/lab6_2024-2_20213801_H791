package com.example.lab6.controller;

import com.example.lab6.entity.Artista;
import com.example.lab6.entity.Evento;
import com.example.lab6.repository.ArtistaRepository;
import com.example.lab6.repository.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.interfaces.EdECKey;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/EventMaster")
public class menuController {

    final EventoRepository eventoRepository;
    final ArtistaRepository artistaRepository;

    public menuController(EventoRepository eventoRepository, ArtistaRepository artistaRepository) {
        this.eventoRepository = eventoRepository;
        this.artistaRepository = artistaRepository;
    }

    @GetMapping("/inicio")
    public String showInicio(Model model) {
        return "inicio";
    }

    @GetMapping("/eventos")
    public String showEventos(Model model) {
        model.addAttribute("eventList",eventoRepository.findAll());
        return "eventos";
    }

    @GetMapping("/artistas")
    public String showArtistas(Model model) {
        model.addAttribute("artistaList",artistaRepository.findAll());
        return "artistas";
    }
    @GetMapping("/infoEvent/{id}")
    public String infoEvent( @ModelAttribute("evento") Evento evento, Model model, @PathVariable int id) {


        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        if(eventoOptional.isPresent()) {
            evento = eventoOptional.get();
            model.addAttribute("evento", evento);
            model.addAttribute("eventList",eventoRepository.findAll());
            return "editEventos";
        }else{
            return "redirect:/EventMaster/eventos";
        }

    }
    @GetMapping("/infoArtista/{id}")
    public String infoArtista( @ModelAttribute("artista") Artista artista, Model model, @PathVariable int id) {
        model.addAttribute("generos", List.of("Pop", "Rock", "Jazz", "Hip Hop", "Clásica"));


        Optional<Artista> artistaOptional = artistaRepository.findById(id);
        if(artistaOptional.isPresent()) {
            artista = artistaOptional.get();
            model.addAttribute("artista", artista);
            return "formArtistas";
        }else{
            return "redirect:/EventMaster/artistas";
        }

    }

    @GetMapping("/nuevoEvento")
    public String nuevoEvento (@ModelAttribute("evento") Evento evento){
        return "editEventos";
    }
    @GetMapping("/contactos")
    public String contacto (){
        return "contactos";
    }
    @GetMapping("/nuevoArtista")
    public String nuevoArtista (@ModelAttribute("artista") Artista artista, Model model){
        model.addAttribute("generos", List.of("Pop", "Rock", "Jazz", "Hip Hop", "Clásica"));

        return "formArtistas";
    }

    @PostMapping("/saveEvento")
    public String saveEvento(
            @ModelAttribute("evento")@Valid Evento evento, BindingResult bindingResult, RedirectAttributes attr) {

        eventoRepository.save(evento);

        return "redirect:/EventMaster/eventos";
    }
    @PostMapping("/saveArtista")
    public String saveArtista(
            @ModelAttribute("evento")@Valid Artista artista, BindingResult bindingResult, RedirectAttributes attr) {

        artistaRepository.save(artista);

        return "redirect:/EventMaster/artistas";
    }

}
