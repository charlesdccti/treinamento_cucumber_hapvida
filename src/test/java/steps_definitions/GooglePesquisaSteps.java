package steps_definitions;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import page_objects.GoogleInicialPage;

public class GooglePesquisaSteps
{
	GoogleInicialPage pagina = new GoogleInicialPage();
	
	@Dado("^que eu esteja na pagina inicial do google$")
	public void queEuEstejaNaPaginaInicialDoGoogle() 
	{
		pagina.abrirPagina();
	}

	
	
	/**
	 * pesquisaSuccess
	 **/
	@Quando("^eu pesquisar por um assunto$")
	public void euPesquisarPorUmAssunto() 
	{
		pagina.preencherFormPesquisa("Teste Automatizado");
		pagina.pesquisar();
	}
	
	@Entao("^me retorna os resultados indexados$")
	public void meRetornaOsResultadosIndexados() 
	{
		String txtAssertPage = pagina.verResultadoPesquisa();
		pagina.fecharPagina();
		
		assertEquals("Aproximadamente", txtAssertPage);
	}

	
	
	/**
	 * pesquisaUndefined
	 **/
	@Quando("^eu pesquisar sem preencher o assunto$")
	public void euPesquisarSemPreencherOAssunto()
	{
		pagina.pesquisar();
	}
	
	@Entao("^continuarei na mesma pagian aguardando um assunto$")
	public void continuareiNaMesmaPagianAguardandoUmAssunto()
	{
		Boolean mesmaPagina = pagina.conferirSeEstouNaPaginaInicial();
		pagina.fecharPagina();
		
		assertEquals(true, mesmaPagina);
	}
}
