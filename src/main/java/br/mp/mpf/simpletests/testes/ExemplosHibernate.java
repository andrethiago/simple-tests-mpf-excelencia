package br.mp.mpf.simpletests.testes;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.Release;
import br.mp.mpf.simpletests.model.TipoTeste;
import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.util.HibernateUtil;

public class ExemplosHibernate {

    public static void main(String[] args) {
	ExemplosHibernate eh = new ExemplosHibernate();

	eh.listarTodosUsuariosHql();
	eh.listarReleasePorIdGetvsLoad(1L);
	eh.listarCasoDeTesteHqlComParametros();
	eh.listarCasoDeTesteComCriteria();
	eh.listarCasoDeTestePorExemplo();
	// eh.listarProjetosSql();

	// eh.incluirNovoCasoDeTeste();
	// eh.alterarCasoDeTesteIncluido();
	// eh.removerCasoDeTeste();

	System.exit(0);
    }

    private void listarTodosUsuariosHql() {

	Session session = HibernateUtil.getSession();

	List<Usuario> usuarios = session.createQuery("from Usuario").list();

	for (Usuario usuario : usuarios) {
	    System.out.println(usuario);
	}

	session.close();

    }

    private void listarReleasePorIdGetvsLoad(long idRelease) {

	// 1. Com get; ir debugando e ver que ele já faz o select no get
	Session session = HibernateUtil.getSession();
	Release release = (Release) session.get(Release.class, idRelease);
	System.out.println(release);
	session.close();

	// 2. Com load ; ir debugando e ver que ele só faz o select quando o
	// sysout é chamado
	session = HibernateUtil.getSession();
	release = (Release) session.load(Release.class, idRelease);
	System.out.println(release);
	session.close();

	// 3. Com get e id inexistente
	session = HibernateUtil.getSession();
	release = (Release) session.get(Release.class, 10L);
	if (release != null) {
	    System.out.println(release);
	} else {
	    System.out.println("Release não encontrada.");
	}
	session.close();

	// 4. Com load e id inexistente
	// session = HibernateUtil.getSession();
	// release = (Release) session.load(Release.class, 10L);
	// if(release != null) {
	// System.out.println(release);
	// } else {
	// System.out.println("Release não encontrada.");
	// }
	// session.close();

	// 5. Com get mudando o mapeamento do projeto para EAGER (antes eram 2
	// selects; agora ele faz join)
	session = HibernateUtil.getSession();
	release = (Release) session.get(Release.class, idRelease);
	if (release != null) {
	    System.out.println(release);
	} else {
	    System.out.println("Release não encontrada.");
	}
	session.close();

	// 6. Mostrando exemplos de eager fetch do projeto - @Fetch (JOIN,
	// SELECT, SUBSELECT)

	// 7. Sem fechar a sessão; a segunda chamada não vai ao banco, pois o
	// objeto já está na sessão
	session = HibernateUtil.getSession();
	release = (Release) session.get(Release.class, idRelease);
	if (release != null) {
	    System.out.println(release);
	} else {
	    System.out.println("Release não encontrada.");
	}
	session.get(Release.class, idRelease);
	session.close();
    }

    private void listarCasoDeTesteHqlComParametros() {
	Session session = HibernateUtil.getSession();

	Query query = session.createQuery("from CasoDeTeste where projeto = :p and tipo = :tipo");
	Projeto projeto = new Projeto();
	projeto.setId(1L);
	query.setParameter("p", projeto);
	query.setParameter("tipo", TipoTeste.FUNCIONAL);

	List<CasoDeTeste> casos = query.list();

	for (CasoDeTeste caso : casos) {
	    System.out.println(caso);
	}

	session.close();
    }

    private void listarCasoDeTesteComCriteria() {
	Session session = HibernateUtil.getSession();

	Criteria criteria = session.createCriteria(CasoDeTeste.class);

	Projeto projeto = new Projeto();
	projeto.setId(1L);
	criteria.add(Restrictions.eq("projeto", projeto));
	criteria.add(Restrictions.eq("tipo", TipoTeste.FUNCIONAL));
	// criteria.add(Restrictions.in("tipo", TipoTeste.values()));
	// criteria.add(Restrictions.ilike("nome", "%conclusão%"));
	// criteria.add(Restrictions.or(Restrictions.eq("tipo",
	// TipoTeste.FUNCIONAL),
	// Restrictions.eq("tipo", TipoTeste.AUTOMATIZADO)));

	List<CasoDeTeste> casos = criteria.list();

	for (CasoDeTeste caso : casos) {
	    System.out.println(caso);
	}
	session.close();
    }

    private void listarCasoDeTestePorExemplo() {
	Session session = HibernateUtil.getSession();

	CasoDeTeste casoExemplo = new CasoDeTeste();
	casoExemplo.setTipo(TipoTeste.FUNCIONAL);
	casoExemplo.setNome("conclusão");

	Example example = Example.create(casoExemplo).enableLike(MatchMode.ANYWHERE).ignoreCase();

	List<CasoDeTeste> casos = session.createCriteria(CasoDeTeste.class).add(example).list();

	for (CasoDeTeste caso : casos) {
	    System.out.println(caso);
	}

	session.close();

    }
}
