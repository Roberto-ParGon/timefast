package mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

private final static String RESOURCE = "mybatis/mybatisConfig.xml";
    private final static String ENVIROMENT = "development";
    
    public static SqlSession obtenerConexion(){
        SqlSession ConnectionDB = null;
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            //SqlSessionFactory openConnection = new SqlSessionFactoryBuilder().build(reader);
            SqlSessionFactory openConnection = new SqlSessionFactoryBuilder().build(reader, ENVIROMENT);
           
            ConnectionDB = openConnection.openSession();
            System.out.println("Conexión a la base de datos establecida");
        } catch (IOException ex) {
            System.err.println("Error al intentar conectar con la base de datos: " + ex.getMessage());
        }
        return ConnectionDB;
    }
}

