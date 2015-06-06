package test;

import java.util.LinkedList;
import java.util.List;

import pos.data.JDBCLibroDAO;
import pos.domain.Libro;

public class TestLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Libro> lislib = new LinkedList<Libro>();
		JDBCLibroDAO lindao = new JDBCLibroDAO();
		
		lislib = lindao.sellectAll();
		
		for(Libro l : lislib)
		{
		System.out.print(l.GetIDLibro()+",");
		System.out.print(l.GetNombreLibro()+",");
		System.out.print(l.GetAutor());
		System.out.println();
		System.out.println("=================");
		}

	}

}
