angular.module('simpleTests').factory('ProjetosService', function($http, SimpleTestConstants) {
	return {
		getProjetos : function() {
			return $http.get(SimpleTestConstants.url + '/projetos');
		},
		
		getProjeto: function(id) {
			return $http.get(SimpleTestConstants.url + '/projetos/' + id);
		},
		
		incluir : function(projeto) {
			return $http.put(SimpleTestConstants.url + '/projetos', projeto);
		},
		
		alterar : function(projeto) {
			return $http.post(SimpleTestConstants.url + '/projetos', projeto);
		},
		
		excluir : function(projeto) {
			return $http.delete(SimpleTestConstants.url + '/projetos/' + projeto.id);
		}
	
	
	}
});