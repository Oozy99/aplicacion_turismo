package com.example.TurismoaApplication.servicios;

import com.example.TurismoaApplication.modelos.Empresa;
import com.example.TurismoaApplication.modelos.Oferta;
import com.example.TurismoaApplication.repositorios.OfertaRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaServicio {

    @Autowired
    OfertaRespositorio ofertaRepositorio;
    @Autowired
    OfertaRespositorio ofertaRespositorio;


    public Oferta registrarOferta(Oferta datosARegistrar) throws Exception {
        try{

          return  (this.ofertaRepositorio.save(datosARegistrar));


        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Oferta modificarOferta(Integer id,Oferta datosAModificar) throws Exception{
        try {

            Optional<Oferta> ofertaEncontrada = this.ofertaRepositorio.findById(id);
            if( ofertaEncontrada.isEmpty()){
                throw new Exception("oferta no encontrada");
            }
            Oferta ofertaQueExiste = ofertaEncontrada.get();

            ofertaQueExiste.setTitulo(datosAModificar.getTitulo());
            ofertaQueExiste.setDescripcion(datosAModificar.getDescripcion());

            return (this.ofertaRepositorio.save(ofertaQueExiste));

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    public Oferta buscarOfertaId(Integer id) throws Exception {
        try {
            Optional<Oferta> bucarOferta=this.ofertaRepositorio.findById(id);
            if (bucarOferta.isEmpty()){
                throw new Exception("empresa no encontrada");
            }
            return bucarOferta.get();

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Oferta> buscarOfertas() throws Exception {
        try {
            List<Oferta>litaOferta= this.ofertaRepositorio.findAll();
            return litaOferta;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarOferta(Integer id) throws Exception {


        try{

            Optional<Oferta> ofertaOptional=this.ofertaRepositorio.findById(id);

            if(ofertaOptional.isPresent()){
                this.ofertaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("oferta no encontrada");
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
