package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar,actionListener_copiar,actionListener_guardar,
	actionListener_recuperar,actionListener_recuperarTodos,actionListener_rotar;
	
	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}
	public void contol() {	
		//listener para comparar contenido
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);
		//listener para buscar palabra
		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		//listener para copiar fichero
		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_copiarFichero();
			}
		};
		view.getCopiar().addActionListener(actionListener_copiar);
		//litener para guardar libro
		actionListener_guardar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_guardarLibro();
			}
		};
		view.getBtnGuardar().addActionListener(actionListener_guardar);
		//listener para recuperar libro
		actionListener_recuperar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_recuperarLibro();
			}
		};
		view.getBtnRecuperar().addActionListener(actionListener_recuperar);
		//listener para recuperar todos
		actionListener_recuperarTodos = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_recuperarTodos();
			}
		};
		view.getBtnRecuperarTodos().addActionListener(actionListener_recuperarTodos);
	}

	private void call_compararContenido(){
		String fichero1 = view.getFichero1().getText();
		String fichero2 = view.getFichero2().getText();
		boolean iguales;
		try {
			iguales = model.compararContenido(fichero1, fichero2);
			if (iguales) 
				view.getTextArea().setText("Los ficheros son iguales.");
			else
				view.getTextArea().setText("Los ficheros son distintos.");
			//manejo de excepciones si no encuentra fichero o nombre
		} catch (FileNotFoundException e) {
			if (fichero1.length() == 0) {
					view.showError("Introduce un nombre para fichero1");
			} else if (fichero2.length() == 0) {
					view.showError("Introduce un nombre para fichero2");
			} else
				view.showError("No existe el fichero llamado \""+e.getMessage()+"\"");
		} catch (IOException e) {
			view.showError("Se ha producido un error");
		}
	}
	private void call_buscarPalabra() {
		String fichero1 = view.getFichero1().getText();
		String busqueda = view.getPalabra().getText().trim();
		boolean primera_aparicion = view.getPrimera().isSelected();
		int resultado;
		try {
			resultado = model.buscarPalabra(fichero1, busqueda, primera_aparicion);	
			//se ha encontrado una palabra
			System.out.println("res: " +resultado);
			if (resultado>0) {
				if (primera_aparicion)
					view.getTextArea().setText("\""+busqueda+"\""+" aparece por primera vez en la linea "+resultado);
				else
					view.getTextArea().setText("\""+busqueda+"\""+" aparece por ultima vez en la linea "+resultado);
			} else if (resultado == -1) {
				view.getTextArea().setText("No se ha encontrado ninguna coincidencia");
			}
		}  catch (FileNotFoundException e) {
			if (fichero1.length() == 0)
				view.showError("Introduce un nombre para el fichero 1");
			else
				view.showError("El fichero \""+e.getMessage()+"\" no existe");
		} catch (IOException e) {
			view.showError("Error");
		}
	}
	private void call_copiarFichero() {
		String fichero1 = view.getFichero1().getText();
		String fichero2 = view.getFichero2().getText();
		int copiados = 0;
		try {
			copiados = model.copiarFichero(fichero1, fichero2);
			view.getTextArea().setText("Fichero \""+fichero2+"\" creado. Se han copiado "+copiados+" bytes.");
		} catch (IOException e) {
			view.showError("Se ha producido un error");
		}
	}
	private void call_guardarLibro() {
		String titulo,autor,año,editor,paginas;
		boolean guardadoCorrecto = true;
		int opcion = 0;
		//cogemos el valor de los TextFields
		titulo = view.getTitulo().getText();
		autor = view.getAutor().getText();
		año = view.getAnyo().getText();
		editor = view.getEditor().getText();
		paginas = view.getPaginas().getText();
		
		if (titulo.length() != 0) {	
			//comprobamos si existe y si queremos sobreescribir
			if(model.ficheroExiste(new File("libros\\"+titulo))) {
				opcion = sobreescribir();
				if (opcion== 0) { //opcion sobreescribir
					try {
						model.guardar_libro(titulo, titulo, autor, año, editor, paginas);
					} catch (IOException e) {
						guardadoCorrecto = false;
						view.showError("Se ha producido un error");
					}
				}	
			}
		} else
			view.showError("El campo TITULO es obligatorio para crear un nuevo libro");
		view.limpiarCampos();
		
		if(opcion == 0 && guardadoCorrecto)
			view.getTextArea().setText("El libro \""+titulo+"\" ha sido guardado correctamente");
	}
	
	private int sobreescribir() {
		int opcion = -1;
		opcion = JOptionPane.showConfirmDialog(view, "¿Quiere sobreescribir el fichero?", "El fichero ya existe", JOptionPane.YES_NO_OPTION);
		return opcion;	
	}
	
	private void call_recuperarLibro() {
		String titulo;
		LibroVO libro;
		
		//obtenemos titulo del libro a buscar
		titulo = view.getTitulo().getText();
		if (titulo.length() != 0) {		
			try {
				//si existe mostramos la informacion
				libro = model.recuperar_libro(titulo);
				view.getTextArea().setText(libro.toString());
			} catch (FileNotFoundException e) {
				view.showError("No se ha encontrado ninguna coincidencia");
			} catch (ClassNotFoundException | IOException e) {
				view.showError("Se ha producido un error");
			}
		}		
	}
	private void call_recuperarTodos() {
		ArrayList<LibroVO> libros = new ArrayList<LibroVO>();
		StringBuilder resultado = new StringBuilder();
		String encabezado;

		try {
			libros = model.recuperar_todos();
			//comprobamos si hemos obtenido algun resultado
			encabezado = libros.size() == 0 ?  " NO HAY RESULTADOS" :  " "+libros.size()+" RESULTADOS:\n";
			resultado.append(encabezado);
			for (int i=0; i<libros.size(); i++){
				resultado.append("  - "+libros.get(i).getTitulo()+"\n");
			}
			view.getTextArea().setText(resultado.toString());
		} catch (Exception e) {
			view.showError("Se ha producido un error");
		}
	}

}
