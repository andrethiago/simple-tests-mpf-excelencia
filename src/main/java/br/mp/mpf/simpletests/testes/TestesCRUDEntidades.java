package br.mp.mpf.simpletests.testes;

import java.util.List;

import org.hibernate.Session;

import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.util.HibernateUtil;

public class TestesCRUDEntidades {
	
	public static void main(String[] args) {
		TestesCRUDEntidades tce = new TestesCRUDEntidades();
		tce.listaProjetos();
		
		System.exit(0);
	}
	
	void listaProjetos() {
		Session session = HibernateUtil.getSession();
		
		List<Projeto> projetos =  session.createQuery("from Projeto").list();
		
		for(Projeto projeto : projetos) {
			System.out.println(projeto);
		}
		
		session.close();
	}

}
