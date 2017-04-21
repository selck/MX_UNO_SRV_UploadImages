package mx.com.amx.unotv.noticias.upload.images.dto;

import java.util.List;

public class ListBannerDTO {
	
	List<BannerDTO> banners;
	String fecha_generacion;

	/**
	 * @return the banners
	 */
	public List<BannerDTO> getBanners() {
		return banners;
	}

	/**
	 * @param banners the banners to set
	 */
	public void setBanners(List<BannerDTO> banners) {
		this.banners = banners;
	}

	/**
	 * @return the fecha_generacion
	 */
	public String getFecha_generacion() {
		return fecha_generacion;
	}

	/**
	 * @param fecha_generacion the fecha_generacion to set
	 */
	public void setFecha_generacion(String fecha_generacion) {
		this.fecha_generacion = fecha_generacion;
	}
	
	
}
