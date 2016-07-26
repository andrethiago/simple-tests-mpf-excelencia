angular.module('simpleTests').controller('ProjetosController', function ($scope, $http){
	
	$scope.projeto = null;
	$scope.projetos = [];
	$scope.mensagemSucesso = null;
	
	$scope.incluirProjeto = function(projeto) {
		$http.put('http://localhost:8080/simpletests/projetos', projeto).success(function(data) {
			$scope.projeto = {};
			$scope.mensagemSucesso = data.mensagem;
			carregarProjetos();
		});
	};
	
	$scope.selecionarProjeto = function(id) {
		$http.get('http://localhost:8080/simpletests/projetos/'+id).success(function(data) {
			$scope.projeto = data.dados;
		});
	};
	
	
	var carregarPorId = function(id) {
		$http.get('http://localhost:8080/simpletests/projetos/'+id).success(function(data) {
			$scope.projeto = data.dados;
		})
	};
	
	var carregarProjetos = function() {
		$http.get('http://localhost:8080/simpletests/projetos').success(function(data) {
			$scope.projetos = data.dados;
		})
	};
	
	carregarProjetos();
	
	
});