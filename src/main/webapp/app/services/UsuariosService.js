angular.module('simpleTests').factory('UsuariosService', function($http) {
	return {
		getUsuarios : function() {
			return $http.get('http://localhost:8080/simpletests/usuarios');
		},
		
		incluir : function(usuario) {
			return $http.put('http://localhost:8080/simpletests/usuarios', usuario);
		},
		
		alterar : function(usuario) {
			return $http.post('http://localhost:8080/simpletests/usuarios', usuario);
		},
		
		excluir : function(usuario) {
			return $http.delete('http://localhost:8080/simpletests/usuarios/' + usuario.id);
		}
	
	
	}
});