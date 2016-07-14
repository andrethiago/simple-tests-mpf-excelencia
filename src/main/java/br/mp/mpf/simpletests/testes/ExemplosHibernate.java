package br.mp.mpf.simpletests.testes;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Defeito;
import br.mp.mpf.simpletests.model.ExecucaoTeste;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.Release;
import br.mp.mpf.simpletests.model.ResultadoExecucaoTeste;
import br.mp.mpf.simpletests.model.StatusExecucao;
import br.mp.mpf.simpletests.model.SuiteDeTeste;
import br.mp.mpf.simpletests.model.TipoTeste;
import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.util.HibernateUtil;

public class ExemplosHibernate {

    public static void main(String[] args) {
	ExemplosHibernate eh = new ExemplosHibernate();

	try {

	    eh.listarTodosUsuariosHql();
	    eh.listarReleasePorIdGetvsLoad(1L);
	    eh.listarCasoDeTesteHqlComParametros();
	    eh.listarCasoDeTesteComCriteria();
	    eh.listarCasoDeTestePorExemplo();
	    eh.listarReleasesSql();

	    eh.listarCasosDeTeste();
	    CasoDeTeste caso = eh.incluirNovoCasoDeTeste();
	    eh.listarCasosDeTeste();
	    eh.alterarCasoDeTesteIncluido(caso);
	    eh.removerCasoDeTeste(caso);
	    eh.listarCasosDeTeste();

	    eh.inserirExecucaoEResultadoExecucaoFalhaParaVerificarCascadeNoDefeito();

	    System.exit(0);
	} catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    private void listarCasosDeTeste() {

	Session session = HibernateUtil.getSession();

	List<CasoDeTeste> casos = session.createQuery("from CasoDeTeste").list();

	for (CasoDeTeste caso : casos) {
	    System.out.println(caso);
	}

	session.close();
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

    private void listarReleasesSql() {
	Session session = HibernateUtil.getSession();

	List<Release> releases = session.createSQLQuery("SELECT * FROM release").addEntity(Release.class).list();

	/*
	 * List<Release> releases = session .createSQLQuery(
	 * "SELECT r.* FROM release r JOIN projeto p on r.id_projeto =  p.id_projeto WHERE p.nome = :nome"
	 * ) .addEntity("r", Release.class).setParameter("nome",
	 * "Sistema Único - Módulo Extrajudicial").list();
	 */

	/*
	 * (List<Object[]> releases = session .createSQLQuery(
	 * "SELECT r.* FROM release r JOIN projeto p ON r.id_projeto = p.id_projeto WHERE p.nome = :nome "
	 * ) .addEntity("r", Release.class).addJoin("p", "r.projeto")
	 * .setParameter("nome", "Sistema Único - Módulo Extrajudicial").list();
	 *
	 * for (Object[] release : releases) { System.out.println(release[0]); }
	 */

	for (Release release : releases) {
	    System.out.println(release);
	}

	session.close();
    }

    private CasoDeTeste incluirNovoCasoDeTeste() {
	CasoDeTeste casoDeTeste = new CasoDeTeste();

	// 1. Caso de Teste está incompleto. Deve dar rollback
	casoDeTeste.setNome("CT99 - Caso de Teste para testar algo");
	casoDeTeste.setDescricao("Testando algo para ver se funciona.");

	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	/*
	 * try { session.save(casoDeTeste); transaction.commit(); } catch
	 * (Exception e) { e.printStackTrace();
	 * System.err.println("Rolling back :-( ."); transaction.rollback(); }
	 *
	 * session.close();
	 */

	// 2. Completando os campos obrigatórios
	casoDeTeste.setPreCondicoes("Pré condições");
	casoDeTeste.setPassos("Passos");
	casoDeTeste.setResultadoEsperado("Xpto xpto");
	casoDeTeste.setTipo(TipoTeste.FUNCIONAL);

	// session = HibernateUtil.getSession();
	casoDeTeste.setProjeto((Projeto) session.get(Projeto.class, 1L));
	// transaction = session.beginTransaction();
	try {
	    session.save(casoDeTeste);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("Rolling back :-( .");
	    transaction.rollback();
	} finally {
	    session.close();
	}

	return casoDeTeste;
    }

    private void alterarCasoDeTesteIncluido(CasoDeTeste caso) {
	System.out.println(caso);

	caso.setPreCondicoes("Novas pré-condições");

	// 1. Update simples. Notar que são feitos 2 updates (1 do caso de teste
	// e outro do projeto); além disso tem o delete da join table
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.update(caso);
	    transaction.commit();
	} catch (Exception e) {
	    transaction.rollback();
	} finally {
	    session.close();
	}

	// 2. Removendo o cascade de projeto e modificando o da join table para
	// delete. Notar que o update do projeto some, mas não o da join table

	System.out.println(caso);
    }

    private void removerCasoDeTeste(CasoDeTeste caso) {
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    // observar que o cascade força o delete das histórias associadas a
	    // este caso de teste
	    session.delete(caso);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	} finally {
	    session.close();
	}

    }

    private void inserirExecucaoEResultadoExecucaoFalhaParaVerificarCascadeNoDefeito() {
	Session session = HibernateUtil.getSession();

	ExecucaoTeste execucaoTeste = new ExecucaoTeste();
	execucaoTeste.setNome("Execução 01");
	execucaoTeste.setRelease((Release) session.get(Release.class, 1L));
	execucaoTeste.adicionar((SuiteDeTeste) session.get(SuiteDeTeste.class, 1L));

	ResultadoExecucaoTeste resultado = new ResultadoExecucaoTeste();
	resultado.setCasoDeTeste(incluirNovoCasoDeTeste());
	resultado.setStatus(StatusExecucao.FALHOU);
	resultado.setExecucao(execucaoTeste);
	resultado.setTestador((Usuario) session.get(Usuario.class, 1L));

	Defeito defeito = new Defeito();
	defeito.setNome("Erro encontrado");
	defeito.setDescricao("Erro encontrado durante execução do teste XXX.");
	defeito.setItemExecucao(resultado);

	resultado.setDefeito(defeito);

	execucaoTeste.adicionar(resultado);

	Transaction transaction = session.beginTransaction();
	try {
	    session.save(execucaoTeste);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	}
    }

}
