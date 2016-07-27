angular.module('simpleTests').controller('ProjetosController', function ($scope, $http, ProjetosService){
	
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
			$http.post('http://localhost:8080/simpletests/projetos', projeto).success(function(data) {
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
			$http.put('http://localhost:8080/simpletests/projetos', projeto).success(function(data) {
				if(data.sucesso) {
					$scope.projeto = {};
					$scope.mensagemSucesso = data.mensagem;
					$scope.escondeFormulario();
					carregarProjetos();
				} else {
					$scope.mensagemAviso = data.erro.mensagem;
				}
			});
		}
		
		
	};
	
	$scope.excluirProjeto = function(projeto) {
		$http.delete('http://localhost:8080/simpletests/projetos/' + projeto.id).success(function(data) {
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
	
	var carregarPorId = function(id) {
		$http.get('http://localhost:8080/simpletests/projetos/'+id).success(function(data) {
			$scope.projeto = data.dados;
		})
	};
	
	var carregarProjetos = function() {
		ProjetosService.getProjetos().success(function(data) {
			$scope.projetos = data.dados;
			// adicionando uma data de início do projeto
			angular.forEach($scope.projetos, function(projeto) {
				projeto.data = new Date();
			});
		})
	};
	
	carregarProjetos();
	
	
});