angular.module('simpleTests').controller('CasosDeTesteController', function ($scope, CasosDeTesteService, ProjetosService){
	
	$scope.casoDeTeste = null;
	$scope.casos = [];
	$scope.projetos = []
	$scope.mensagemSucesso = null;
	$scope.mensagemAviso = null;
	$scope.mensagemErro = null;
	
	
	
	$scope.salvarCasoDeTeste = function(casoDeTeste) {
		
		CasosDeTesteService.incluir(casoDeTeste).then(
			function success(response) {
				if(response.data.sucesso) {
					$scope.casoDeTeste = {};
					$scope.mensagemSucesso = response.data.mensagem;
					carregarCasosDeTeste();
				} else {
					$scope.mensagemAviso = response.data.erro.mensagem;
				}
			}, 
			function error(response) {
				console.log('Deu erro');
			}
		);
		
	};
	
	$scope.excluirProjeto = function(casoDeTeste) {
		CasosDeTesteService.excluir(casoDeTeste).then(
			function success(response) {
				if(response.data.sucesso) {
					$scope.mensagemSucesso = response.data.mensagem;
					carregarCasosDeTeste();
				} else {
					$scope.mensagemAviso = response.data.erro.mensagem;
				}
			}, 
			function error(response) {
				console.log('Deu erro');
			}
		);
	}
	
	var carregarCasosDeTeste = function() {
		CasosDeTesteService.getCasosDeTeste().then(
			function(response) {
				$scope.casos = response.data.dados;
			}
		)
	};
	
	var carregarProjetos = function() {
		ProjetosService.getProjetos().success(function(data) {
			$scope.projetos = data.dados;
		})
	};
	
	var carregarTiposDeTeste = function() {
		CasosDeTesteService.getTipos().success(function(data) {
			$scope.tiposDeTeste = data.dados;
		})
	};
	
	carregarCasosDeTeste();
	carregarTiposDeTeste();
	carregarProjetos();
	
	
});