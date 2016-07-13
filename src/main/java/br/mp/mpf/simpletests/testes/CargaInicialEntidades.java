package br.mp.mpf.simpletests.testes;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.LocalDate;

import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Historia;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.Release;
import br.mp.mpf.simpletests.model.SuiteDeTeste;
import br.mp.mpf.simpletests.model.TipoTeste;
import br.mp.mpf.simpletests.util.HibernateUtil;

public class CargaInicialEntidades {

    public static void main(String[] args) {
	CargaInicialEntidades cie = new CargaInicialEntidades();

	List<Projeto> projetos = cie.listaProjetos();
	if (CollectionUtils.isEmpty(projetos)) {
	    cie.incluiProjetos(cie);
	    cie.listaProjetos();
	}

	// inclui releases
	Projeto sistemaUnico = cie.getProjeto(Long.valueOf(1L));
	List<Release> releasesUnico = cie.listarReleases(sistemaUnico);
	if (CollectionUtils.isEmpty(releasesUnico)) {
	    cie.incluirReleases(sistemaUnico);
	    cie.listarReleases(sistemaUnico);
	}

	// inclui historias
	Release sprintUnico01 = cie.getRelease(Long.valueOf(1L));
	List<Historia> historias = cie.listarHistorias(sprintUnico01);
	if (CollectionUtils.isEmpty(historias)) {
	    cie.incluirHistorias(sprintUnico01);
	    cie.listarHistorias(sprintUnico01);
	}

	// inclui caso de teste
	List<CasoDeTeste> casosDeTestes = cie.listarCasosDeTeste(sistemaUnico);
	if (CollectionUtils.isEmpty(casosDeTestes)) {
	    cie.incluirCasosDeTeste(sistemaUnico);
	    casosDeTestes = cie.listarCasosDeTeste(sistemaUnico);
	}

	// inclui suites de teste
	List<SuiteDeTeste> suitesDeTestes = cie.listarSuitesDeTeste(sistemaUnico);
	if (CollectionUtils.isEmpty(suitesDeTestes)) {
	    cie.incluirSuitesDeTeste(sistemaUnico, casosDeTestes);
	    suitesDeTestes = cie.listarSuitesDeTeste(sistemaUnico);
	}

	System.exit(0);
    }

    void incluirSuitesDeTeste(Projeto projeto, List<CasoDeTeste> casosDeTestes) {
	SuiteDeTeste suite = new SuiteDeTeste();
	suite.setProjeto(projeto);
	suite.setCasos(new HashSet<>(casosDeTestes));
	suite.setNome("SUITE 01");

	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.save(suite);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	} finally {
	    session.close();
	}
    }

    List<SuiteDeTeste> listarSuitesDeTeste(Projeto projeto) {
	Session session = HibernateUtil.getSession();

	List<SuiteDeTeste> suites = session.createQuery("from SuiteDeTeste where projeto = :p").setEntity("p", projeto)
		.list();
	for (SuiteDeTeste suite : suites) {
	    System.out.println(suite);
	}
	session.close();

	return suites;
    }

    void incluiProjetos(CargaInicialEntidades tce) {
	incluiProjeto("Sistema Único", "Testes do Sistema Único de documentos do MPF.");
	incluiProjeto("Simple Tests", "Testes da aplicação exemplo Simple Tests.");
	incluiProjeto("Cartola FC", "Testes do Fantasy Game Cartola FC.");
    }

    Projeto incluiProjeto(String nome, String descricao) {
	Projeto projeto = new Projeto(nome, descricao);
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.save(projeto);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	} finally {
	    session.close();
	}
	return projeto;
    }

    List<Projeto> listaProjetos() {
	Session session = HibernateUtil.getSession();

	List<Projeto> projetos = session.createQuery("from Projeto").list();
	for (Projeto projeto : projetos) {
	    System.out.println(projeto);
	}
	session.close();

	return projetos;
    }

    Projeto getProjeto(Long id) {
	Session session = HibernateUtil.getSession();
	Projeto projeto = (Projeto) session.byId(Projeto.class).load(id);
	// Projeto projeto = (Projeto) session.get(id);
	session.close();

	return projeto;
    }

    private List<Release> listarReleases(Projeto projeto) {
	Session session = HibernateUtil.getSession();

	List<Release> releases = session.createQuery("from Release where projeto = :p").setEntity("p", projeto).list();
	for (Release release : releases) {
	    System.out.println(release);
	}
	session.close();

	return releases;
    }

    void incluirReleases(Projeto projeto) {
	Date dataInicial = new LocalDate(2014, 2, 1).toDate();
	Date dataFinal = new LocalDate(2014, 2, 21).toDate();
	incluiRelease(projeto, "Sprint 01", "Sprint com funcionalidades do módulo extrajudicial.", dataInicial,
		dataFinal);
	dataInicial = new LocalDate(dataInicial).plusWeeks(4).toDate();
	dataFinal = new LocalDate(dataFinal).plusWeeks(4).toDate();
	incluiRelease(projeto, "Sprint 02", "Sprint com funcionalidades do módulo judicial.", dataInicial, dataFinal);
	dataInicial = new LocalDate(dataInicial).plusWeeks(4).toDate();
	dataFinal = new LocalDate(dataFinal).plusWeeks(4).toDate();
	incluiRelease(projeto, "Sprint 03", "Sprint com as seguintes funcionalidades: visibilidade, designação.",
		dataInicial, dataFinal);
    }

    Release incluiRelease(Projeto projeto, String nome, String descricao, Date dataInicial, Date dataFinal) {
	Release release = new Release();
	release.setNome(nome);
	release.setDescricao(descricao);
	release.setProjeto(projeto);
	release.setDataInicial(dataInicial);
	release.setDataFinal(dataFinal);

	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.save(release);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	} finally {
	    session.close();
	}

	return release;
    }

    Release getRelease(Long id) {
	Session session = HibernateUtil.getSession();
	Release release = (Release) session.get(Release.class, id);
	session.close();

	return release;
    }

    private void incluirHistorias(Release release) {
	incluiHistoria(release, "Conclusão em lote de extrajudiciais",
		"Como um usuário, eu quero consultar procedimentos extrajudiciais e poder concluí-los em conjunto.");
	incluiHistoria(release, "Modificar o status do Procedimento quando houver um desapensamento",
		"Como um usuário do Sistema Único, quando eu efetuar o desapensamento de um procedimento de outro procedimento o status daquele deve ser modificado para 'FINALIZADO'.");
	incluiHistoria(release, "Impresssão da pauta de sessão segundo o formato e parâmetros escolhidos",
		"Como um usuário do Sistema Único, eu quero escolher parâmetros e formato do relatório da pauta de sessão e o sistema deve gerar o relatório segundo essas escolhas.");
	incluiHistoria(release, "Envelopamento em lote de procedimentos de uma sessão do Colegiado",
		"Como um usuário do Sistema Único, eu quero escolher os procedimentos de uma sessão do meu Colegiado e poder envelopá-los em conjunto.");
    }

    private Historia incluiHistoria(Release release, String nome, String descricao) {
	Historia historia = new Historia(release, nome, descricao);
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.save(historia);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	} finally {
	    session.close();
	}
	return historia;
    }

    List<Historia> listarHistorias(Release release) {
	Session session = HibernateUtil.getSession();

	List<Historia> historias = session.createQuery("from Historia where release = :release")
		.setEntity("release", release).list();
	for (Historia historia : historias) {
	    System.out.println(historia);
	}
	session.close();

	return historias;
    }

    void incluirCasosDeTeste(Projeto projeto) {
	incluiCasoDeTeste(projeto, "CT01 - Conclusão em Lote - Conclusão realizada com sucesso",
		"Um usuário autenticado deve ser capaz de concluir procedimentos em lote.",
		"O usuário deve estar autenticado no sistema, ter acesso à funcionalidade e "
			+ "devem existir procedimentos distribuídos para o grupo de distribuição e ofícios selecionados.\n"
			+ "Devem existir procedimentos localizados no setor do usuário entre as datas de recebimento selecionadas.\n"
			+ "O usuário deve utilizar um navegador suportado.",
		"1. Entre no menu Procedimento Extrajudicial/Adm > Concluir Procedimentos em Lote.\n"
			+ "2. Escolha um grupo de distribuição e um ofício.\n"
			+ "3. Escolha a data inicial e final de recebimento.\n" + "4. Clique no botão 'Consultar'.\n"
			+ "5. Selecione todos os procedimentos retornados na consulta.\n"
			+ "6. Clique no botão 'Concluir'.",
		"Os procedimentos devem ser conclusos/movimentados e o sistema deve avisar um a um o destino da conclusão.",
		TipoTeste.FUNCIONAL);

	incluiCasoDeTeste(projeto,
		"CT02 - Status do Procedimento modificado para finalizado quando houver um desapensamento",
		"O sistema deve modificar o status do procedimento para FINALIZADO quando este for desapensado.",
		"O usuário deve estar autenticado no sistema, ter acesso à funcionalidade e "
			+ "o procedimento escolhido deve ser apenso de um outro procedimento.\n"
			+ "O procedimento escolhido deve estar localizado no setor do usuário.\n"
			+ "O usuário deve utilizar um navegador suportado.",
		"1. Escolha o procedimento principal do apenso em questão.\n" + "2. Acesse a aba Referências.\n"
			+ "3. Na lista de referências, escolha a linha em que aparece o procedimento apenso em questão.\n"
			+ "5. Clique no botão 'Finalizar referencia'.",
		"Acesse o procedimento apenso. Onde é exibido o Status deve estar escrito 'FINALIZADO'.",
		TipoTeste.FUNCIONAL);

    }

    CasoDeTeste incluiCasoDeTeste(Projeto projeto, String nome, String descricao, String preCondicoes, String passos,
	    String resultadosEsperados, TipoTeste tipo) {
	CasoDeTeste casoDeTeste = new CasoDeTeste();
	casoDeTeste.setProjeto(projeto);
	casoDeTeste.setNome(nome);
	casoDeTeste.setDescricao(descricao);
	casoDeTeste.setPreCondicoes(preCondicoes);
	casoDeTeste.setPassos(passos);
	casoDeTeste.setResultadoEsperado(resultadosEsperados);
	casoDeTeste.setTipo(tipo);

	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.save(casoDeTeste);
	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	} finally {
	    session.close();
	}

	return casoDeTeste;
    }

    List<CasoDeTeste> listarCasosDeTeste(Projeto projeto) {
	Session session = HibernateUtil.getSession();
	List<CasoDeTeste> casosDeTeste = session.createQuery("from CasoDeTeste where projeto = :p")
		.setEntity("p", projeto).list();

	for (CasoDeTeste caso : casosDeTeste) {
	    System.out.println(caso);
	}

	session.close();
	return casosDeTeste;
    }

}
