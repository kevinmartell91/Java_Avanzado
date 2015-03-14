package pe.edu.upc.demo.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;

@WebListener
public class SessionListener implements HttpSessionListener{

    
    private static final Logger LOG = Logger.getLogger(SessionListener.class);
    private static int totalSesiones = 0;
    
    public static int cantidadSesiones(){
        return totalSesiones;
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        if(totalSesiones<0){
            totalSesiones = 0;
        }
        totalSesiones ++;
        LOG.info("::::::: LISTENER ::::::: SessionListener --> metodo sessionCreated");
        LOG.info("::::::: LISTENER ::::::: SessionListener --> Cantidad Sesiones: " 
                + totalSesiones);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if(totalSesiones<0){
            totalSesiones = 0;
        }
        totalSesiones --;
        LOG.info("::::::: LISTENER ::::::: SessionListener --> metodo sessionDestroyed");
        LOG.info("::::::: LISTENER ::::::: SessionListener --> Cantidad Sesiones: " 
                + totalSesiones);
    }
    
    
    
}
