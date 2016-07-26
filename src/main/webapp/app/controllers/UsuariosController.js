angular.module('simpleTests').controller('UsuariosController', function($scope, $http) {
	
	$scope.usuarios = [];
	$scope.mensagemSucesso = null;
	$scope.mensagemErro = null;
	
	$scope.incluirUsuario = function(usuario) {
		$http.put('http://localhost:8080/simpletests/usuarios', usuario).success(function(data) {
			$scope.usuario = {};
			$scope.mensagemSucesso = data.mensagem;
			carregarUsuarios();
		});
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