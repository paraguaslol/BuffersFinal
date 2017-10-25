package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;

public class LaunchView extends JFrame {

	private JButton btn_comparar,btn_buscar,btn_copiar,btnGuardar,btnRecuperar,btnRecuperarTodos;
	private JTextArea textArea;
	private JTextField f1,f2,palabra,titulo,autor,anyo,editor,paginas;
	private JLabel lbl_f1,lbl_f2,lbl_p,lbl_titulo,lbl_autor,lbl_anyo,lbl_editor,lbl_paginas;
	private JCheckBox cb;
	private JPanel textficheros,botonesficheros,libros,botoneslibros,textlibros,ficheros,pantalla,app;
	
	public LaunchView() {
		setBounds(200,200,1000,502);
		setTitle("Proyecto Buffers");	
        
        app = new JPanel();
        getContentPane().add(app, BorderLayout.CENTER);
        
        ficheros = new JPanel();
        app.add(ficheros);
        ficheros.setLayout(new GridLayout(0, 1, 0, 0));
        textficheros = new JPanel();
        ficheros.add(textficheros);
        
        f1 = new JTextField("",10);
        f2 = new JTextField("",10);
        palabra = new JTextField("",10);
        
        lbl_f1 = new JLabel("Fichero 1:");
        lbl_f2 = new JLabel("Fichero 2:");
        lbl_p = new JLabel("Palabra:");
        
        cb = new JCheckBox("Primera aparición");
        GroupLayout gl_textficheros = new GroupLayout(textficheros);
        gl_textficheros.setHorizontalGroup(
        	gl_textficheros.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(5)
        			.addComponent(lbl_f1)
        			.addGap(5)
        			.addComponent(f1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(lbl_f2)
        			.addGap(5)
        			.addComponent(f2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(lbl_p)
        			.addGap(5)
        			.addComponent(palabra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(cb))
        );
        gl_textficheros.setVerticalGroup(
        	gl_textficheros.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(9)
        			.addComponent(lbl_f1))
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(6)
        			.addComponent(f1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(9)
        			.addComponent(lbl_f2))
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(6)
        			.addComponent(f2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(9)
        			.addComponent(lbl_p))
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(6)
        			.addComponent(palabra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_textficheros.createSequentialGroup()
        			.addGap(5)
        			.addComponent(cb))
        );
        textficheros.setLayout(gl_textficheros);
        
        botonesficheros = new JPanel();
        ficheros.add(botonesficheros);
        
        btn_comparar = new JButton("Comparar contenido");
        btn_comparar.setPreferredSize(new Dimension(150, 26));
        btn_buscar = new JButton("Buscar palabra");
        btn_buscar.setPreferredSize(new Dimension(150, 26));
        btn_copiar = new JButton("Copiar fichero");
        btn_copiar.setPreferredSize(new Dimension(150, 26));
        GroupLayout gl_botonesficheros = new GroupLayout(botonesficheros);
        gl_botonesficheros.setHorizontalGroup(
        	gl_botonesficheros.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_botonesficheros.createSequentialGroup()
        			.addGap(108)
        			.addComponent(btn_comparar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(btn_buscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(btn_copiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        gl_botonesficheros.setVerticalGroup(
        	gl_botonesficheros.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_botonesficheros.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_botonesficheros.createParallelGroup(Alignment.LEADING)
        				.addComponent(btn_comparar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_buscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_copiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        botonesficheros.setLayout(gl_botonesficheros);
        
        libros = new JPanel();
        app.add(libros);
        libros.setLayout(new GridLayout(0, 1, 0, 0));
        textlibros = new JPanel();
        libros.add(textlibros);
        lbl_titulo = new JLabel("Titulo");
        
    	//Libro
		titulo = new JTextField("",10);
		lbl_autor = new JLabel("Autor");
		autor = new JTextField("",10);
		lbl_anyo = new JLabel("Anyo");
		anyo = new JTextField("",10);
		lbl_editor = new JLabel("Editor");
		editor = new JTextField("",10);
		lbl_paginas = new JLabel("Paginas");
		paginas = new JTextField("",10);
		GroupLayout gl_textlibros = new GroupLayout(textlibros);
		gl_textlibros.setHorizontalGroup(
			gl_textlibros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(5)
					.addComponent(lbl_titulo)
					.addGap(5)
					.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lbl_autor)
					.addGap(5)
					.addComponent(autor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lbl_anyo)
					.addGap(5)
					.addComponent(anyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lbl_editor)
					.addGap(5)
					.addComponent(editor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lbl_paginas)
					.addGap(5)
					.addComponent(paginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_textlibros.setVerticalGroup(
			gl_textlibros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(8)
					.addComponent(lbl_titulo))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(5)
					.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(8)
					.addComponent(lbl_autor))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(5)
					.addComponent(autor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(8)
					.addComponent(lbl_anyo))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(5)
					.addComponent(anyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(8)
					.addComponent(lbl_editor))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(5)
					.addComponent(editor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(8)
					.addComponent(lbl_paginas))
				.addGroup(gl_textlibros.createSequentialGroup()
					.addGap(5)
					.addComponent(paginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		textlibros.setLayout(gl_textlibros);
		
		botoneslibros = new JPanel();
		libros.add(botoneslibros);
		
		btnGuardar = new JButton("Guardar libro");
		btnGuardar.setPreferredSize(new Dimension(150, 26));
		btnRecuperar = new JButton("Recuperar libro");
		btnRecuperar.setPreferredSize(new Dimension(150, 26));
		btnRecuperarTodos = new JButton("Recuperar Todos");
		btnRecuperarTodos.setPreferredSize(new Dimension(150, 26));
		GroupLayout gl_botoneslibros = new GroupLayout(botoneslibros);
		gl_botoneslibros.setHorizontalGroup(
			gl_botoneslibros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_botoneslibros.createSequentialGroup()
					.addGap(169)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(btnRecuperar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(btnRecuperarTodos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_botoneslibros.setVerticalGroup(
			gl_botoneslibros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_botoneslibros.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_botoneslibros.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRecuperar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRecuperarTodos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		botoneslibros.setLayout(gl_botoneslibros);
        
        pantalla = new JPanel();
        app.add(pantalla);
        
        textArea = new JTextArea(18, 80);
        JScrollPane scroll = new JScrollPane(textArea);
        pantalla.add(scroll);
        textArea.setBounds(50,50,50,50);
        textArea.setEditable(false);
	}	
	
	public JButton getComparar() {
		return btn_comparar;
	}

	public void setComparar(JButton comparar) {
		this.btn_comparar = comparar;
	}

	public JButton getBuscar() {
		return btn_buscar;
	}

	public void setBuscar(JButton buscar) {
		this.btn_buscar = buscar;
	}

	public JButton getCopiar() {
		return btn_copiar;
	}

	public void setCopiar(JButton copiar) {
		this.btn_copiar = copiar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return f1;
	}

	public void setFichero1(JTextField fichero1) {
		this.f1 = fichero1;
	}

	public JTextField getFichero2() {
		return f2;
	}

	public void setFichero2(JTextField fichero2) {
		this.f2 = fichero2;
	}

	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public JCheckBox getPrimera() {
		return cb;
	}

	public void setPrimera(JCheckBox primera) {
		this.cb = primera;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.textficheros,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getAnyo() {
		return anyo;
	}

	public void setAnyo(JTextField anyo) {
		this.anyo = anyo;
	}

	public JTextField getEditor() {
		return editor;
	}

	public void setEditor(JTextField editor) {
		this.editor = editor;
	}

	public JTextField getPaginas() {
		return paginas;
	}

	public void setPaginas(JTextField paginas) {
		this.paginas = paginas;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnRecuperar() {
		return btnRecuperar;
	}

	public void setBtnRecuperar(JButton btnRecuperar) {
		this.btnRecuperar = btnRecuperar;
	}

	public JButton getBtnRecuperarTodos() {
		return btnRecuperarTodos;
	}

	public void setBtnRecuperarTodos(JButton btnRecuperarTodos) {
		this.btnRecuperarTodos = btnRecuperarTodos;
	}

	public void limpiarCampos() {
		titulo.setText("");
		autor.setText("");
		anyo.setText("");
		editor.setText("");
		paginas.setText("");
	}
	
}
