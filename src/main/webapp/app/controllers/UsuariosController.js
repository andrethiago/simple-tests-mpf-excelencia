angular.module('simpleTests').controller('UsuariosController', function($scope, $http) {
	
	var carregarUsuarios = function() {
		$http.get('http://localhost:8080/simpletests/usuarios').success(function(data) {
			$scope.usuarios = data.dados;
		});
	};
	
	carregarUsuarios();
	
});