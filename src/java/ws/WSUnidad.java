package ws;

import com.google.gson.Gson;
import dominio.ImpUnidad;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pojo.Mensaje;
import pojo.Unidad;

@Path("unidad")
public class WSUnidad {
    
    @Path("registrarUnidad")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarUnidad(String jsonUnidad){
        try{
            Gson gson = new Gson();
            Unidad unidad = gson.fromJson(jsonUnidad, Unidad.class);
            return ImpUnidad.registrarUnidad(unidad);
        }catch(Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    
    @Path("editarUnidad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUnidad(String jsonUnidad){
        try{
            Gson gson = new Gson();
            Unidad unidad = gson.fromJson(jsonUnidad, Unidad.class);
            return ImpUnidad.editarUnidad(unidad);
        }catch(Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarUnidad")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUnidad(@QueryParam("vin") String vin){
        return ImpUnidad.eliminarUnidad(vin);
    }
    
    @GET
    @Path("obtenerUnidadVin/{vin}")
    public List<Unidad> obtenerUnidadVin(@PathParam("vin")String vin){
        return ImpUnidad.obtenerUnidadVin(vin);
    }
    
    @GET
    @Path("obtenerUnidadVin/{nii}")
    public List<Unidad> obtenerUnidadNii(@PathParam("nii")String nii){
        //TODO
        return ImpUnidad.obtenerUnidadNii();
    }
    
    @GET
    @Path("obtenerUnidadVin/{marca}")
    public List<Unidad> obtenerUnidadMarca(@PathParam("marca")String marca){
        return ImpUnidad.obtenerUnidadesMarca(marca);
    }
    
    @Path("obtenerUnidades")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad> obtenerUnidades(){
        return ImpUnidad.obtenerUnidades();
    }

            
}
