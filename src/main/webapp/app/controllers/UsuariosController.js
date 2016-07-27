angular.module('simpleTests').controller('UsuariosController', function($scope, $http) {
	
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
			$http.put('http://localhost:8080/simpletests/usuarios', usuario).success(function(data) {
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
			$http.post('http://localhost:8080/simpletests/usuarios', usuario).success(function(data) {
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
		$http.delete('http://localhost:8080/simpletests/usuarios/' + usuario.id).success(function(data) {
			$scope.mensagemSucesso = data.mensagem;
			carregarUsuarios();
		}).error(function(data) {
			console.log('error')
			$scope.mensagemErro = data.mensagem;
		});
	}
	
	var carregarUsuarios = function() {
		$http.get('http://localhost:8080/simpletests/usuarios').success(function(data) {
			$scope.usuarios = data.dados;
		});
	};
	
	carregarUsuarios();
	
});