package mx.com.amx.unotv.noticias.upload.images.util;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import mx.com.amx.unotv.noticias.upload.images.dto.ParametrosDTO;

import org.apache.log4j.Logger;


public class CargaProperties {
	
	private Logger logger=Logger.getLogger(CargaProperties.class);
			
	public ParametrosDTO obtenerPropiedades(String properties) {
		ParametrosDTO parametros = new ParametrosDTO();
		try {
			Properties propsTmp = new Properties();
			propsTmp.load(this.getClass().getResourceAsStream( "/general.properties" ));
			String ambiente = propsTmp.getProperty("ambiente");
			String rutaProperties = propsTmp.getProperty(properties.replace("ambiente", ambiente));			
			Properties props = new Properties();
			props.load(new FileInputStream(new File(rutaProperties)));				
			
			parametros.setPathLocalImagenes(props.getProperty("pathLocalImagenes"));
			parametros.setPathLocalImagenesGaleria(props.getProperty("pathLocalImagenesGaleria"));
			parametros.setPathLocalImagenesInfografia(props.getProperty("pathLocalImagenesInfografia"));
			parametros.setPathLocalImagenesClaroIdeas(props.getProperty("pathLocalImagenesClaroIdeas"));
			
			parametros.setPathRemoteImagenes(props.getProperty("pathRemoteImagenes"));
			parametros.setPathRemoteGallery(props.getProperty("pathRemoteGallery"));
			parametros.setPathRemoteInfografia(props.getProperty("pathRemoteInfografia"));
			parametros.setPathRemoteImagenesClaroIdeas(props.getProperty("pathRemoteImagenesClaroIdeas"));
			
			parametros.setPathShell(props.getProperty("pathShell"));
			parametros.setPathShellElimina(props.getProperty("pathShellElimina"));
			parametros.setExtFiles(props.getProperty("extFiles") == null? null: props.getProperty("extFiles").split(","));
			parametros.setMaxMegas(Integer.parseInt(props.getProperty("maxMegas")));
			parametros.setURL_WS_BASE(props.getProperty("URL_WS_BASE"));
			parametros.setAmbiente(props.getProperty("ambiente"));
			
			parametros.setMaxKBImagenes(Integer.parseInt(props.getProperty("maxKBImagenes")));
			parametros.setMaxKBImagenesGaleria(Integer.parseInt(props.getProperty("maxKBImagenesGaleria")));
			parametros.setMaxKBImagenesInfografia(Integer.parseInt(props.getProperty("maxKBImagenesInfografia")));
			
			parametros.setPathLocalBanners(props.getProperty("pathLocalBanners"));
			parametros.setPathRemoteBanners(props.getProperty("pathRemoteBanners"));
			parametros.setPathLocalBannersJSON(props.getProperty("pathLocalBannersJSON"));
			parametros.setNameBannersJSON(props.getProperty("nameBannersJSON"));
			
		} catch (Exception ex) {
			parametros = new ParametrosDTO();
			logger.error("No se encontro el Archivo de propiedades: ", ex);
		}
		return parametros;
    }
	
}
