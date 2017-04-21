package mx.com.amx.unotv.noticias.upload.images.dto;

import java.io.Serializable;

public class ParametrosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	private String pathLocalImagenes;
	private String pathRemoteImagenes;
	private String pathLocalBanners;
	private String pathRemoteBanners;
	private String pathLocalBannersJSON;
	private String nameBannersJSON;
	private String pathLocalImagenesGaleria;
	private String pathRemoteGallery;
	private String pathLocalImagenesInfografia;
	private String pathRemoteInfografia;
	private Integer maxMegas;
	private Integer maxKBImagenes;
	private Integer maxKBImagenesGaleria;
	private Integer maxKBImagenesInfografia;
	private String pathShell;
	private String pathShellElimina;
	private String URL_WS_BASE;	
	private String [] extFiles;
	private String ambiente;
	
	/**
	 * @return the pathLocalImagenes
	 */
	public String getPathLocalImagenes() {
		return pathLocalImagenes;
	}
	/**
	 * @param pathLocalImagenes the pathLocalImagenes to set
	 */
	public void setPathLocalImagenes(String pathLocalImagenes) {
		this.pathLocalImagenes = pathLocalImagenes;
	}
	/**
	 * @return the pathRemoteImagenes
	 */
	public String getPathRemoteImagenes() {
		return pathRemoteImagenes;
	}
	/**
	 * @param pathRemoteImagenes the pathRemoteImagenes to set
	 */
	public void setPathRemoteImagenes(String pathRemoteImagenes) {
		this.pathRemoteImagenes = pathRemoteImagenes;
	}
	/**
	 * @return the pathLocalBanners
	 */
	public String getPathLocalBanners() {
		return pathLocalBanners;
	}
	/**
	 * @param pathLocalBanners the pathLocalBanners to set
	 */
	public void setPathLocalBanners(String pathLocalBanners) {
		this.pathLocalBanners = pathLocalBanners;
	}
	/**
	 * @return the pathRemoteBanners
	 */
	public String getPathRemoteBanners() {
		return pathRemoteBanners;
	}
	/**
	 * @param pathRemoteBanners the pathRemoteBanners to set
	 */
	public void setPathRemoteBanners(String pathRemoteBanners) {
		this.pathRemoteBanners = pathRemoteBanners;
	}
	/**
	 * @return the pathLocalImagenesGaleria
	 */
	public String getPathLocalImagenesGaleria() {
		return pathLocalImagenesGaleria;
	}
	/**
	 * @param pathLocalImagenesGaleria the pathLocalImagenesGaleria to set
	 */
	public void setPathLocalImagenesGaleria(String pathLocalImagenesGaleria) {
		this.pathLocalImagenesGaleria = pathLocalImagenesGaleria;
	}
	/**
	 * @return the pathRemoteGallery
	 */
	public String getPathRemoteGallery() {
		return pathRemoteGallery;
	}
	/**
	 * @param pathRemoteGallery the pathRemoteGallery to set
	 */
	public void setPathRemoteGallery(String pathRemoteGallery) {
		this.pathRemoteGallery = pathRemoteGallery;
	}
	/**
	 * @return the pathLocalImagenesInfografia
	 */
	public String getPathLocalImagenesInfografia() {
		return pathLocalImagenesInfografia;
	}
	/**
	 * @param pathLocalImagenesInfografia the pathLocalImagenesInfografia to set
	 */
	public void setPathLocalImagenesInfografia(String pathLocalImagenesInfografia) {
		this.pathLocalImagenesInfografia = pathLocalImagenesInfografia;
	}
	/**
	 * @return the pathRemoteInfografia
	 */
	public String getPathRemoteInfografia() {
		return pathRemoteInfografia;
	}
	/**
	 * @param pathRemoteInfografia the pathRemoteInfografia to set
	 */
	public void setPathRemoteInfografia(String pathRemoteInfografia) {
		this.pathRemoteInfografia = pathRemoteInfografia;
	}
	/**
	 * @return the maxMegas
	 */
	public Integer getMaxMegas() {
		return maxMegas;
	}
	/**
	 * @param maxMegas the maxMegas to set
	 */
	public void setMaxMegas(Integer maxMegas) {
		this.maxMegas = maxMegas;
	}
	/**
	 * @return the maxKBImagenes
	 */
	public Integer getMaxKBImagenes() {
		return maxKBImagenes;
	}
	/**
	 * @param maxKBImagenes the maxKBImagenes to set
	 */
	public void setMaxKBImagenes(Integer maxKBImagenes) {
		this.maxKBImagenes = maxKBImagenes;
	}
	/**
	 * @return the maxKBImagenesGaleria
	 */
	public Integer getMaxKBImagenesGaleria() {
		return maxKBImagenesGaleria;
	}
	/**
	 * @param maxKBImagenesGaleria the maxKBImagenesGaleria to set
	 */
	public void setMaxKBImagenesGaleria(Integer maxKBImagenesGaleria) {
		this.maxKBImagenesGaleria = maxKBImagenesGaleria;
	}
	/**
	 * @return the maxKBImagenesInfografia
	 */
	public Integer getMaxKBImagenesInfografia() {
		return maxKBImagenesInfografia;
	}
	/**
	 * @param maxKBImagenesInfografia the maxKBImagenesInfografia to set
	 */
	public void setMaxKBImagenesInfografia(Integer maxKBImagenesInfografia) {
		this.maxKBImagenesInfografia = maxKBImagenesInfografia;
	}
	/**
	 * @return the pathShell
	 */
	public String getPathShell() {
		return pathShell;
	}
	/**
	 * @param pathShell the pathShell to set
	 */
	public void setPathShell(String pathShell) {
		this.pathShell = pathShell;
	}
	/**
	 * @return the pathShellElimina
	 */
	public String getPathShellElimina() {
		return pathShellElimina;
	}
	/**
	 * @param pathShellElimina the pathShellElimina to set
	 */
	public void setPathShellElimina(String pathShellElimina) {
		this.pathShellElimina = pathShellElimina;
	}
	/**
	 * @return the uRL_WS_BASE
	 */
	public String getURL_WS_BASE() {
		return URL_WS_BASE;
	}
	/**
	 * @param uRL_WS_BASE the uRL_WS_BASE to set
	 */
	public void setURL_WS_BASE(String uRL_WS_BASE) {
		URL_WS_BASE = uRL_WS_BASE;
	}
	/**
	 * @return the extFiles
	 */
	public String[] getExtFiles() {
		return extFiles;
	}
	/**
	 * @param extFiles the extFiles to set
	 */
	public void setExtFiles(String[] extFiles) {
		this.extFiles = extFiles;
	}
	/**
	 * @return the ambiente
	 */
	public String getAmbiente() {
		return ambiente;
	}
	/**
	 * @param ambiente the ambiente to set
	 */
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	/**
	 * @return the pathLocalBannersJSON
	 */
	public String getPathLocalBannersJSON() {
		return pathLocalBannersJSON;
	}
	/**
	 * @param pathLocalBannersJSON the pathLocalBannersJSON to set
	 */
	public void setPathLocalBannersJSON(String pathLocalBannersJSON) {
		this.pathLocalBannersJSON = pathLocalBannersJSON;
	}
	/**
	 * @return the nameBannersJSON
	 */
	public String getNameBannersJSON() {
		return nameBannersJSON;
	}
	/**
	 * @param nameBannersJSON the nameBannersJSON to set
	 */
	public void setNameBannersJSON(String nameBannersJSON) {
		this.nameBannersJSON = nameBannersJSON;
	}
	
		
	
}
