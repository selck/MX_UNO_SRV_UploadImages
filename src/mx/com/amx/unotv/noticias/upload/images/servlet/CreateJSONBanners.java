package mx.com.amx.unotv.noticias.upload.images.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import mx.com.amx.unotv.noticias.upload.images.dto.BannerDTO;
import mx.com.amx.unotv.noticias.upload.images.dto.ListBannerDTO;
import mx.com.amx.unotv.noticias.upload.images.dto.ParametrosDTO;
import mx.com.amx.unotv.noticias.upload.images.util.CargaProperties;



public class CreateJSONBanners extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(CreateJSONBanners.class);
	
    public CreateJSONBanners() {
        super();
    }
    public static void main (String [] args){
		String jsonCadena="{\"contadorDocumentos\":\"0\",\"documentosEliminados\":\"\",\"contadorArchivos0\":\"3\",\"archivosEliminados[0]\":\"1\",\"name[0][0]\":\"/portal/unotv/imagenes_galeria/281-GaleriaUno.jpg\",\"link[0][0]\":\"facebook.com\",\"tipoBanner[0][0]\":\"mb03\",\"name[0][2]\":\"/portal/unotv/imagenes_galeria/283-GaleriaUno.jpg\",\"link[0][2]\":\"snapchat\",\"tipoBanner[0][2]\":\"superbanner\",\"name[0][3]\":\"/portal/unotv/imagenes_galeria/284-GaleriaUno.jpg\",\"link[0][3]\":\"instagram.com\",\"tipoBanner[0][3]\":\"mb07\"}";
		logger.info("saveJSON");
		String respuesta="ERROR";
			try {
				JSONObject json = new JSONObject(jsonCadena);
				int max_items=Integer.parseInt(json.getString("contadorArchivos0"));
				
				ArrayList<BannerDTO> litsBanners=new ArrayList<BannerDTO>();
				
				for (int i = 0; i <= max_items; i++) {
					String path="";
					String link="";
					String tipoBanner="";
					BannerDTO bannerDTO=new BannerDTO();
					try {
						path=json.getString("name[0]["+i+"]") ;
						if(!path.equals(""))
							bannerDTO.setUrl_imagen(path);
						
						link=json.getString("link[0]["+i+"]") ;
						if(!link.equals(""))
							bannerDTO.setLink(link);
						
						tipoBanner=json.getString("tipoBanner[0]["+i+"]") ;
						if(!tipoBanner.equals(""))
							bannerDTO.setAd_unit(tipoBanner);
						
						litsBanners.add(bannerDTO);
					} catch (Exception e) {
						continue;
					}
				}
				
				ListBannerDTO objectListBannerDTO=new ListBannerDTO();
				if(litsBanners.size()>0){
					objectListBannerDTO.setBanners(litsBanners);
					TimeZone tz = TimeZone.getTimeZone("America/Mexico_City");
			        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
					df.setTimeZone(tz);
					Date date = new Date();
					String fechaS=df.format(date);
					fechaS=fechaS.substring(0, fechaS.length()-2)+":00";
					objectListBannerDTO.setFecha_generacion(fechaS);
					
					Gson gson = new Gson();
			        String json2 = gson.toJson(objectListBannerDTO);
			        System.out.println(json2);
				}
				
			} catch (Exception e) {
				logger.error("Error saveJSON: ",e);
			}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Intento de peticion Get");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("CreateJSONBanners doPost");
		PrintWriter out = response.getWriter();	      
		try {			
			CargaProperties cargaProperties=new CargaProperties();
	        ParametrosDTO parametrosDTO=cargaProperties.obtenerPropiedades("ambiente.resources.properties");
	        String result = "ERROR";

	        String jsonCadena=request.getParameter("jsonCadena")==null?"":request.getParameter("jsonCadena");
	        logger.info("jsonCadena: "+jsonCadena);
	        if (!jsonCadena.equals("")) {
	        	result=saveJSON(jsonCadena, parametrosDTO);
			}
	        logger.info("Result: "+result);
	        out.print( result );
		}catch(Exception ex){
			logger.error("Ocurrio un error subiendo el archivo: " + ex.getMessage() , ex);
			 out.print( "ERROR" );
		}
	}
	
	public static String saveJSON(String jsonCadena, ParametrosDTO parametrosDTO) throws JSONException, IOException{
		//String jsonCadena="{\"contadorDocumentos\":\"0\",\"documentosEliminados\":\"\",\"contadorArchivos0\":\"3\",\"archivosEliminados[0]\":\"1\",\"name[0][0]\":\"/portal/unotv/imagenes_galeria/281-GaleriaUno.jpg\",\"link[0][0]\":\"facebook.com\",\"tipoBanner[0][0]\":\"mb03\",\"name[0][2]\":\"/portal/unotv/imagenes_galeria/283-GaleriaUno.jpg\",\"link[0][2]\":\"snapchat\",\"tipoBanner[0][2]\":\"superbanner\",\"name[0][3]\":\"/portal/unotv/imagenes_galeria/284-GaleriaUno.jpg\",\"link[0][3]\":\"instagram.com\",\"tipoBanner[0][3]\":\"mb07\"}";
		logger.info("saveJSON");
		String respuesta="ERROR";
			try {
				JSONObject json = new JSONObject(jsonCadena);
				int max_items=Integer.parseInt(json.getString("contadorArchivos0"));
				
				ArrayList<BannerDTO> litsBanners=new ArrayList<BannerDTO>();
				
				for (int i = 0; i <= max_items; i++) {
					String path="";
					String link="";
					String tipoBanner="";
					BannerDTO bannerDTO=new BannerDTO();
					try {
						path=json.getString("name[0]["+i+"]") ;
						if(!path.equals(""))
							bannerDTO.setUrl_imagen(path);
						
						link=json.getString("link[0]["+i+"]") ;
						if(!link.equals(""))
							bannerDTO.setLink(link);
						
						tipoBanner=json.getString("tipoBanner[0]["+i+"]") ;
						if(!tipoBanner.equals(""))
							bannerDTO.setAd_unit(tipoBanner);
						
						litsBanners.add(bannerDTO);
					} catch (Exception e) {
						continue;
					}
				}
				
				ListBannerDTO objectListBannerDTO=new ListBannerDTO();
				if(litsBanners.size()>0){
					objectListBannerDTO.setBanners(litsBanners);
					TimeZone tz = TimeZone.getTimeZone("America/Mexico_City");
			        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
					df.setTimeZone(tz);
					Date date = new Date();
					String fechaS=df.format(date);
					fechaS=fechaS.substring(0, fechaS.length()-2)+":00";
					objectListBannerDTO.setFecha_generacion(fechaS);
					logger.info("Usando GSON...");
					Gson gson = new Gson();
			        String json_a_guardar = gson.toJson(objectListBannerDTO);
					
					FileWriter fw = new FileWriter(parametrosDTO.getPathLocalBannersJSON() + parametrosDTO.getNameBannersJSON());
					fw.write(json_a_guardar);
					fw.flush();
					fw.close();
					
					if(parametrosDTO.getAmbiente().equals("desarrollo"))
						transfiereWebServer(parametrosDTO.getPathLocalBannersJSON(), parametrosDTO);
					respuesta="SUCCESS";
				}
				
			} catch (Exception e) {
				logger.error("Error saveJSON: ",e);
			}
			return respuesta;
	}
	
	private static boolean transfiereWebServer(String local, ParametrosDTO parametrosDTO) {
		logger.debug("Inicia transfiereWebServer");
		boolean success = false;
		String comando = parametrosDTO.getPathShell() + " " + local + "* " + "/var/www/unotv/json/";
		//String comandoElimina = parametrosDTO.getPathShellElimina() + " " + local;
		
		logger.debug("comando: " + comando);
		//logger.debug("comandoElimina: " + comandoElimina);
		try {								
			Runtime r = Runtime.getRuntime();
			r.exec(comando).waitFor();
			//r.exec(comandoElimina).waitFor();			
			success = true;
			
		} catch(Exception e) {
			success = false;
			logger.error("Ocurrio un error al ejecutar el Shell " + comando + ": ", e);
		}
		logger.debug("success: " + success);
		return success;
	}
}
