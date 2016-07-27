angular.module('simpleTests').controller('UsuariosController', function($scope, $http, UsuariosService) {
	
	$scope.usuarios = [];
	$scope.mensagemSucesso = null;
	$scope.mensagemAviso = null;
	$scope.mensagemErro = null;
	$scope.exibeFormulario = false;
	
	$scope.exibirFormulario = function(usuario) {
		$scope.exibeFormulario = true;
		$scope.usuario = angular.copy(usuario);
	};
	
	$scope.escondeFormulario = function() {
		$scope.exibeFormulario = false;
	};
	
	$scope.salvarUsuario = function(usuario) {
		
		if(!usuario.id) {
			UsuariosService.incluir(usuario).success(function(data) {
				if(data.sucesso) {
					$scope.usuario = {};
					$scope.mensagemSucesso = data.mensagem;
					$scope.escondeFormulario();
					carregarUsuarios();
				} else {
					$scope.mensagemAviso = data.erro.mensagem;
				}
			});
		} else {
			UsuariosService.alterar(usuario).success(function(data) {
				if(data.sucesso) {
					$scope.usuario = {};
					$scope.mensagemSucesso = data.mensagem;
					$scope.escondeFormulario();
					carregarUsuarios();
				} else {
					$scope.mensagemAviso = data.erro.mensagem;
				}
			});
		}
		
	};
	
	$scope.excluirUsuario = function(usuario) {
		UsuariosService.excluir(usuario).success(function(data) {
			$scope.mensagemSucesso = data.mensagem;
			carregarUsuarios();
		}).error(function(data) {
			console.log('error')
			$scope.mensagemErro = data.mensagem;
		});
	}
	
	var carregarUsuarios = function() {
		UsuariosService.getUsuarios().success(function(data) {
			$scope.usuarios = data.dados;
		});
	};
	
	carregarUsuarios();
	
});