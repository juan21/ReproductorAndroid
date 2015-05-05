package com.example.reproduct4;


public class Musica {
	private int idImagen; 
	private String textoEncima; 
	private String textoDebajo; 
	  
	public Musica (int idImagen, String textoEncima, String textoDebajo) { 
	    this.idImagen = idImagen; 
	    this.textoEncima = textoEncima; 
	    this.textoDebajo = textoDebajo; 
	}
	
	public String get_textoEncima() { 
	    return textoEncima; 
	}
	
	public String get_textoDebajo() { 
	    return textoDebajo; 
	}
	
	public int get_idImagen() {
	    return idImagen; 
	} 

}