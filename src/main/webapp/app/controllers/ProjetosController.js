angular.module('simpleTests').controller('ProjetosController', function ($scope, $location, ProjetosService){
	
	$scope.projeto = null;
	$scope.projetos = [];
	$scope.mensagemSucesso = null;
	$scope.mensagemAviso = null;
	$scope.mensagemErro = null;
	$scope.exibeFormulario = false;
	
	
	$scope.exibirFormulario = function(projeto) {
		$scope.exibeFormulario = true;
		$scope.projeto = angular.copy(projeto);
	};
	
	$scope.escondeFormulario = function() {
		$scope.exibeFormulario = false;
	};
	
	$scope.salvarProjeto = function(projeto) {
		
		if(projeto.id) {
			ProjetosService.alterar(projeto).success(function(data) {
				if(data.sucesso) {
					$scope.projeto = {};
					$scope.mensagemSucesso = data.mensagem;
					$scope.escondeFormulario();
					carregarProjetos();
				} else {
					$scope.mensagemAviso = data.erro.mensagem;
				}
			});
		} else {
			ProjetosService.incluir(projeto).success(function(data) {
				if(data.sucesso) {
					$scope.projeto = {};
					$scope.mensagemSucesso = data.mensagem;
					//$scope.escondeFormulario();
					//carregarProjetos();
					$location.path('#/projetos');
				} else {
					$scope.mensagemAviso = data.erro.mensagem;
				}
			});
		}
		
		
	};
	
	$scope.excluirProjeto = function(projeto) {
		ProjetosService.excluir(projeto).success(function(data) {
			if(data.sucesso) {
				$scope.mensagemSucesso = data.mensagem;
				carregarProjetos();
			} else {
				$scope.mensagemAviso = data.erro.mensagem;
			}
		}).error(function(data) {
			console.log('error')
			$scope.mensagemErro = data.mensagem;
		});
	}
	
	var carregarProjetos = function() {
		ProjetosService.getProjetos().success(function(data) {
			$scope.projetos = data.dados;
			// adicionando uma data de início do projeto
//			angular.forEach($scope.projetos, function(projeto) {
//				projeto.data = new Date();
//			});
		})
	};
	
	carregarProjetos();
	
	
});