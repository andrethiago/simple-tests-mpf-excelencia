angular.module('simpleTests').controller('CasosDeTesteController', function ($scope, CasosDeTesteService){
	
	$scope.casoDeTeste = null;
	$scope.casos = [];
	$scope.mensagemSucesso = null;
	$scope.mensagemAviso = null;
	$scope.mensagemErro = null;
	
	
	
	$scope.salvarCasoDeTeste = function(caso) {
		
		CasosDeTesteService.incluir(caso).then(
			function success(response) {
				if(response.data.sucesso) {
					$scope.caso = {};
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
	
	$scope.excluirProjeto = function(caso) {
		CasosDeTesteService.excluir(caso).then(
			function success(response) {
				if(response.data.sucesso) {
					$scope.caso = {};
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
	
	carregarCasosDeTeste();
	
	
});