angular.module('simpleTests').controller('UsuariosController', function($scope, $http) {
	
	$scope.usuarios = [];
	$scope.mensagemSucesso = null;
	
	$scope.incluirUsuario = function(usuario) {
		console.log(usuario);
		$http.put('http://localhost:8080/simpletests/usuarios', usuario).success(function(data) {
			$scope.usuario = {};
			$scope.mensagemSucesso = data.mensagem;
			carregarUsuarios();
		});
	};
	
	var carregarUsuarios = function() {
		$http.get('http://localhost:8080/simpletests/usuarios').success(function(data) {
			$scope.usuarios = data.dados;
		});
	};
	
	carregarUsuarios();
	
});