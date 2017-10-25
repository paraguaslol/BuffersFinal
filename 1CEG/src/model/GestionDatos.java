package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestionDatos {
	public GestionDatos() {
	}
	public boolean compararContenido (String fichero1, String fichero2) throws FileNotFoundException, IOException{
		File f1 = new File(fichero1);
		File f2 = new File(fichero2);
		boolean iguales=false;
		//lanzamos excepciones antes de empezar el programa para ver si existen los archivos
		if (!f1.exists())
			throw new FileNotFoundException(f1.getName());
		if (!f2.exists())
			throw new FileNotFoundException(f2.getName());
		//comparamos el tamanyo de los ficheros para descartar y ahorrar recursos leyendo
		if (f1.length()==f2.length()) {
			//leemos y comparamos ficheros linea a linea
			BufferedReader br1 = abrir(f1);
			BufferedReader br2 = abrir(f2);
			iguales = comparaLines(br1, br2);
			br1.close();
			br2.close();
		}
		return iguales;
	}
	//metodo que recibe fichero y llama al metodo puedeLeer para lanzar sino la excepcion de permisos 
	private BufferedReader abrir(File fichero) throws FileNotFoundException, IOException {
		if(fichero.canRead()) 
			return new BufferedReader(new FileReader(fichero));
		else
			throw new IOException(); 
	}
	private boolean comparaLines(BufferedReader br1, BufferedReader br2) throws IOException {
		String line1;
		String line2;
		//metodo para recorrer linea a linea de cada file e ir comparandolas
		while (((line1 = br1.readLine()) != null) && ((line2 = br2.readLine())!= null)) {
			if (!line1.equals(line2))
				return false;  
			} 
		return true;
	}
	public boolean ficheroExiste(File fichero) {
		return fichero.exists();
	}
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		File f1 = new File(fichero1);
		String line;
		int cuentaLines=0;
		int ultima_aparicion=0;
		//excepcion existe
		if (!f1.exists())
			throw new FileNotFoundException(f1.getName());
		//comprueba si se ha escrito algo
		if (palabra.length() == 0)
			return 0;
		//abre fichero
	    BufferedReader br1 = abrir(f1);
	    //recorre fichero linea por linea buscando la palabra
	    while ((line = br1.readLine()) != null) {
	    	cuentaLines++;
			if (line.equalsIgnoreCase(palabra)) {
				System.out.println("hi");
				if (primera_aparicion) {
					return cuentaLines;
				} else {
					//guarda la linea donde se encuentra la palabra
					ultima_aparicion = cuentaLines;
				}
			} else if (ultima_aparicion==0){
				ultima_aparicion = -1;	    
			}
	    }
	    return ultima_aparicion;
	}	
	public int copiarFichero(String origen, String destino) throws IOException {
        FileInputStream streamLeer;       
        FileOutputStream streamEscribir;
        int leidos = 0;
        int copiados = 0;        
        //crea un input stream que lee los bytes del file original
        streamLeer = new FileInputStream(origen);
        //crea un output stream que escribe en el file de destino
        streamEscribir = new FileOutputStream(destino);
        //bucle que lee y escribe hasta que no pueda leer mas
        while((leidos = streamLeer.read())!=-1){
        	copiados = leidos;
        	streamEscribir.write(leidos);
        }
        //una vez acaba se cierran los streams
        streamLeer.close();
        streamEscribir.close();     
        return copiados;
	}
	public void guardar_libro(String id, String titulo, String autor, String anyo, String editor, String paginas) throws IOException {
		LibroVO libro;
		FileOutputStream fos = null;
		ObjectOutputStream salida = null;
		//creamos un objeto libro
		libro = new LibroVO(id, titulo, autor, anyo, editor, paginas);
		//creamos el fichero donde guardaremos el objeto libro
		fos = new FileOutputStream("libros\\"+id);
		//guardamos el objeto en el fichero
		salida = new ObjectOutputStream(fos);
		salida.writeObject(libro);
        //cerramos los streams
		if (fos != null)
			fos.close();
		if (salida != null)
			salida.close();
	}	
	public LibroVO recuperar_libro(String id) throws IOException, ClassNotFoundException, FileNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		LibroVO libro = null;
		//cogemos el fichero donde esta el libro almacenado
		fis = new FileInputStream("libros\\"+id);
		//creamos un stream para reconstruir el objeto libro guardado 
		entrada = new ObjectInputStream(fis);
		//leemos la informacion
		libro = (LibroVO) entrada.readObject();
        //cerramos streams
		if (fis != null)
			fis.close();
		if (entrada != null)
			entrada.close();	
		return libro;
	}
	public ArrayList<LibroVO> recuperar_todos() throws ClassNotFoundException, FileNotFoundException, IOException {
		File file = new File("libros");
		File[] ficheros;
		ArrayList<LibroVO> libros = new ArrayList<LibroVO>();
		//obtenemos la lista de ficheros y almacenamos en un array
		ficheros = file.listFiles();
		for (int i=0; i<ficheros.length; i++){
			libros.add(recuperar_libro(ficheros[i].getName()));
		}
		return libros;		
	}	
}