package com.example.TurismoaApplication.controladores;

import com.example.TurismoaApplication.modelos.Oferta;
import com.example.TurismoaApplication.repositorios.OfertaRespositorio;
import com.example.TurismoaApplication.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Oferta")
public class OfertaControladores {
    @Autowired
    OfertaServicio ofertaServicio;
    @Autowired
    OfertaRespositorio ofertaRespositorio;

    @PostMapping
    public ResponseEntity<?> registraOferta(@RequestBody Oferta datosARegistrar){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.registrarOferta(datosARegistrar));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @PutMapping("{idOferta}")
    public ResponseEntity<?> modificarOferta(@RequestBody Oferta datosAModificar, @PathVariable Integer idOferta ){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.modificarOferta(idOferta,datosAModificar));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }


    @GetMapping("{id}")
    public ResponseEntity<?> buscarUnaOfertaid(@PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.buscarOfertaId(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasOferta(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.buscarOfertas());

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<?> eliminarOferta(@PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.eliminarOferta(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}

