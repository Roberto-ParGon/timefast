package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pojo.Mensaje;
import pojo.Unidad;

public class ImpUnidad {

    public static Mensaje registrarUnidad(Unidad unidad) {
        Mensaje msj = new Mensaje();
        SqlSession conexionBD = mybatis.MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                int resultado = conexionBD.insert("unidad.registrarUnidad", unidad);
                conexionBD.commit();

                if (resultado > 0) {
                    msj.setError(false);
                    msj.setMensaje("Unidad registrada con éxito");
                } else {
                    msj.setError(true);
                    msj.setMensaje("No se pudo registrar la unidad");
                }

            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje(e.getMessage());
            }

        } else {
            msj.setError(true);
            msj.setMensaje("Error: no hubo conexión");
        }

        return msj;
    }

    public static Mensaje editarUnidad(Unidad unidad) {
        Mensaje msj = new Mensaje();

        SqlSession conexionBD = mybatis.MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.update("unidad.editarUnidad", unidad);
                conexionBD.commit();

                if (resultado > 0) {
                    msj.setError(false);
                    msj.setMensaje("Unidad actualizada con éxito.");
                } else {
                    msj.setError(true);
                    msj.setMensaje("No se pudo actualizar la unidad");
                }

            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje(e.getMessage());
            }

        } else {
            msj.setError(true);
            msj.setMensaje("Error: no hubo conexión.");
        }

        return msj;
    }

    public static Mensaje eliminarUnidad(String vin) {
        Mensaje msj = new Mensaje();

        SqlSession conexionBD = mybatis.MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("vin", vin);
                int resultado = conexionBD.delete("unidad.editarUnidad", parametros);
                if (resultado > 0) {
                    msj.setError(false);
                    msj.setMensaje("Unidad eliminada con éxito.");
                } else {
                    msj.setError(true);
                    msj.setMensaje("No se pudo eliminar la unidad.");
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje(e.getMessage());
            }
        } else {
            msj.setError(true);
            msj.setMensaje("Error: no hubo conexión");
        }

        return msj;
    }

    public static List<Unidad> obtenerUnidadVin(String vin) {
        List<Unidad> lista = new ArrayList();
        SqlSession conexionBD = mybatis.MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("vin", vin);
                lista = conexionBD.selectList("unidad.obtenerUnidadVin", parametros);

            } catch (Exception e) {
            }
        }
        return lista;
    }

    public static List<Unidad> obtenerUnidadNii() {
        //TODO
        return null;
    }

    public static List<Unidad> obtenerUnidadesMarca(String marca) {
        List<Unidad> lista = new ArrayList<>();
        SqlSession conexionBD = mybatis.MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("marca", marca);
                lista = conexionBD.selectList("unidad.obtenerUnidadesMarca", parametros);
            } catch (Exception e) {
            }
        }
        return lista;
    }

    public static List<Unidad> obtenerUnidades() {
        SqlSession conexionBD = mybatis.MyBatisUtil.obtenerConexion();
        List<Unidad> unidades = null;
        try {
            unidades = conexionBD.selectList("unidad.obtenerUnidades");
        } catch (Exception e) {
        }

        return unidades;
    }

}
