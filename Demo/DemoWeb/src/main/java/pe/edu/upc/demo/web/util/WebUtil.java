package pe.edu.upc.demo.web.util;

import org.apache.log4j.Logger;
import pe.edu.upc.demo.util.SystemUtil;
import static java.text.MessageFormat.format;

public final class WebUtil {
    
    private WebUtil(){
        
    }
    
    public static String controlarError(Exception exception, final Logger log){
        StringBuilder sb = new StringBuilder();
        String idError = SystemUtil.idError();
        sb.append(format("Código de error: {0} \n", idError));
        sb.append(format("Mensaje de error: {0} \n", exception.getMessage()));
        if(exception.getCause() != null){
            StackTraceElement[] elem = exception.getCause().getStackTrace();
            for(StackTraceElement ex : elem){
                sb.append(format("Clase ''{0}'' en la linea ''{1}'' en el método ''{2}'' \n",
                        ex.getClassName(), ex.getLineNumber(), ex.getMethodName()));
            }
        }
        sb.append("Imprimir toda la traza del error: \n");
        log.error(sb.toString(), exception);
        return "Ocurrior un error inesperado, código de error: " + idError;
    }
   
}
