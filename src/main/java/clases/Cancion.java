package clases;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;

import javax.sound.sampled.Clip;

import enums.Estilos;

public class Cancion extends ObjetoConSonido {

	private Artista artista;
	private int duracion;
	private ArrayList<Estilos> EstiloCancion;
	private int cantidadReproducciones;
	private Clip reproducirCancion;
}
