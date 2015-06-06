package test;

import pos.data.JDBCUsuarioDAO;

public class TestUsuario {

	public static void main(String[] args) {

		JDBCUsuarioDAO jdao = new JDBCUsuarioDAO();
		
		System.out.print(jdao.selectAllUsuarios());
	}

}
