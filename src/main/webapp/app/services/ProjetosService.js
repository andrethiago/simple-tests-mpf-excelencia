angular.module('simpleTests').factory('ProjetosService', function($http) {
	return {
		getProjetos : function() {
			return $http.get('http://localhost:8080/simpletests/projetos');
		},
		
		incluir : function(projeto) {
			return $http.put('http://localhost:8080/simpletests/projetos', projeto);
		},
		
		alterar : function(projeto) {
			return $http.post('http://localhost:8080/simpletests/projetos', projeto);
		},
		
		excluir : function(projeto) {
			return $http.delete('http://localhost:8080/simpletests/projetos/' + projeto.id);
		}
	
	
	}
});