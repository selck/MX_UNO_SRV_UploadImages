package mx.com.amx.unotv.noticias.upload.images.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.amx.unotv.noticias.upload.images.bo.ProcesoBO;
import mx.com.amx.unotv.noticias.upload.images.dto.ParametrosDTO;
import mx.com.amx.unotv.noticias.upload.images.util.CargaProperties;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.log4j.Logger;


public class UploadInfografia extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = Logger.getLogger(UploadGaleria.class);
	
    public UploadInfografia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Intento de Peticion Get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("==============UploadInfografia==============");
		PrintWriter out = response.getWriter();	      
		try {			
	        String result = "";
	        CargaProperties cargaProperties=new CargaProperties();
	        ParametrosDTO parametrosDTO=cargaProperties.obtenerPropiedades("ambiente.resources.properties");
        	boolean success = parametrosDTO.getPathLocalImagenesInfografia() != null && parametrosDTO.getPathLocalImagenesInfografia().length()>0?true:false;
        	
        	if(success)
        		result = procesaFicheros(request, parametrosDTO);
        	else 
        		result = null;
        	if( result != null ) {	        		        		
        		out.print( result );
        		return;
        	}	        	
	        logger.info("Ocurrio un error subiendo el archivo.");
	        out.print( "ERROR" );
		}catch(Exception ex){
			logger.error("Ocurrio un error subiendo el archivo: " + ex.getMessage() , ex);
			 out.print( "ERROR" );
		}
	}
	
	public String procesaFicheros(HttpServletRequest req, ParametrosDTO parametrosDTO ) {
        try {
        	//long maxBites = 1024*1024*parametrosDTO.getMaxMegas();    
        	long maxBites = 1024*parametrosDTO.getMaxKBImagenesInfografia();
            DiskFileUpload fu = new DiskFileUpload();
            fu.setSizeMax(1024*1024*parametrosDTO.getMaxMegas()); //50 es el numero de megas
            fu.setSizeThreshold(1024*1024*parametrosDTO.getMaxMegas());
            fu.setRepositoryPath("/tmp");
            List<FileItem> fileItems = fu.parseRequest(req);
            if(fileItems == null) {
                return null;
            }
            Iterator<FileItem> i = fileItems.iterator();
            FileItem actual = null;
            String fileName = "";            
            while (i.hasNext()) {
                actual = (FileItem)i.next();                
                fileName = actual.getName();
                int uu = 0;               
                if( fileName != null && !fileName.equals("") && actual.getFieldName().equals("nameFile") ) {                	
                	File fichero = new File(fileName);
	                logger.info("El nombre del fichero es :" + fichero.getName());
	                long sizeFile = actual.getSize();
	                if(parametrosDTO.getExtFiles() != null && parametrosDTO.getExtFiles().length >1) {
	                	String [] ext = fichero.getName().split("\\.");
	                	for(int hh = 0;  hh<parametrosDTO.getExtFiles().length; hh++) {
	                		if(parametrosDTO.getExtFiles()[hh].trim().equals(ext[ext.length-1]))
	                			uu++;
	                		}	                	                
	                } else { 
	                	uu=1;
	                }
	                
	                if(uu>0) {
	                	if(sizeFile<=maxBites) {
	                		String directorio = parametrosDTO.getPathLocalImagenesInfografia();
	                		boolean continuar = false;
	                		Integer secuencia = 0;
	                		try { 
								ProcesoBO procesoBo = new ProcesoBO(parametrosDTO.getURL_WS_BASE());
								secuencia = procesoBo.getSecuencia("");
								//directorio += secuencia  + "/";
								continuar = createFolders(directorio);
	                		} catch (Exception e) {
	                			continuar = false;
	                			secuencia = 0;
	                			logger.error("Error al crear las carpetas: " + e.getMessage());
	                		}
	                		if(continuar) {	                		
		                		String extFile = "";
	                			try { 
	                				String nam[] = actual.getName().split("\\.");
	                				extFile = nam[nam.length-1];		                				
	                			} catch (Exception e) {
	                				extFile = "jpg";
	                			}
		                		fichero = new  File(directorio + secuencia + "-InforgrafiaUno." + extFile);
		                		actual.write(fichero);
		                		fileName = fichero.getName();
		                		if(parametrosDTO.getPathShell()!= null && parametrosDTO.getPathShell().length()>0) {
		                			if(parametrosDTO.getPathRemoteInfografia() != null && parametrosDTO.getPathRemoteInfografia().length()>0 && parametrosDTO.getAmbiente().equalsIgnoreCase("desarrollo")) {
		                				transfiereWebServer(directorio, parametrosDTO);
		                			}
		                		}
	                		} else {
	                			fileName = "ERROR";
	                		}
	                		
	                	} else {
	                		logger.info("Se intento subir un archivo de tamano mayor al permitido " + parametrosDTO.getMaxMegas() + " MB");
		                	fileName = "MAXTAM";
	                	}
	                } else { 
	                	logger.info("Se intento subir otro tipo de archivo");
	                	fileName = "TIPOAR";
	                }	                
                }
            }
            return fileName;
        }catch (SizeLimitExceededException le) {
        	logger.info("Se intento subir un archivo de tamano mayor al permitido " + parametrosDTO.getMaxMegas() + " MB");
        	return "MAXTAM";
        }catch(Exception e) {
            logger.error("******************************Error de Aplicación " + e.getMessage(), e);
            return null;
        }
    }	
	
	public boolean transfiereWebServer(String local, ParametrosDTO parametrosDTO) {
		boolean success = false;
		String comando = parametrosDTO.getPathShell() + " " + local + "* " + parametrosDTO.getPathRemoteInfografia();
		String comandoElimina = parametrosDTO.getPathShellElimina() + " " + local;
		logger.debug("comando transfiere: " + comando);
		logger.debug("comando Elimina: " + comandoElimina);
		try {								
			Runtime r = Runtime.getRuntime();
			r.exec(comando).waitFor();
			r.exec(comandoElimina).waitFor();			
			success = true;
		} catch(Exception e) {
			success = false;
			logger.error("Ocurrio un error al ejecutar el Shell " + comando + ": ", e);
		}		
		return success;
	}
	
	public boolean createFolders(String directorio) {
		boolean success = false;
		try {						
			File carpetas = new File(directorio) ;
			if(!carpetas.exists()) {   
				success = carpetas.mkdirs();					
			} else 
				success = true;						
		} catch (Exception e) {
			success = false;
			logger.error("Ocurrio error al crear las carpetas: ", e);
		} 
		return success;
	}


}
