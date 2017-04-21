package mx.com.amx.unotv.noticias.upload.images.bo;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class ProcesoBO {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private RestTemplate restTemplate;
	private String URL_WS_BASE="";
	private HttpHeaders headers = new HttpHeaders();
	
	public ProcesoBO(String urlWS) {
		super();
		restTemplate = new RestTemplate();
		ClientHttpRequestFactory factory = restTemplate.getRequestFactory();

	        if ( factory instanceof SimpleClientHttpRequestFactory)
	        {
	            ((SimpleClientHttpRequestFactory) factory).setConnectTimeout( 15 * 1000 );
	            ((SimpleClientHttpRequestFactory) factory).setReadTimeout( 15 * 1000 );
	            logger.info("Inicializando rest template");
	        }
	        else if ( factory instanceof HttpComponentsClientHttpRequestFactory)
	        {
	            ((HttpComponentsClientHttpRequestFactory) factory).setReadTimeout( 15 * 1000);
	            ((HttpComponentsClientHttpRequestFactory) factory).setConnectTimeout( 15 * 1000);
	            logger.info("Inicializando rest template");
	        }
	        restTemplate.setRequestFactory( factory );
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
			URL_WS_BASE = urlWS;
	}
	
	
	public int getSecuencia(String img) {
		int secuencia =0;
		String metodo="getSequenceImage";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			logger.info("URL_WS: "+URL_WS);
			HttpEntity<String> entity = new HttpEntity<String>( img );
			secuencia=restTemplate.postForObject(URL_WS, entity, Integer.class);
		} catch(Exception e) {
			logger.error("Error getSecuencia [BO]: ",e);
		}		
		return secuencia;	
	}
	
	/*public String getSecuenciaString(String img) {
		int secuencia =0;
		String metodo="getSecuencia";
		String URL_WS=URL_WS_BASE+"/"+metodo;
		String salida="Invocando a: "+URL_WS+"|";
		try {
			logger.info("URL_WS: "+URL_WS);
			
			HttpEntity<String> entity = new HttpEntity<String>( img );
			secuencia=restTemplate.postForObject(URL_WS, entity, Integer.class);
			salida+=secuencia;
		} catch(Exception e) {
			logger.error("Error getSecuencia [BO]: ",e);
			salida+=secuencia+"|"+e.getMessage();
		}		
		return salida;	
	}*/
}
