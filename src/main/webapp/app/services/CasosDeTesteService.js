angular.module('simpleTests').factory('CasosDeTesteService', function($http, SimpleTestConstants) {
	return {
		getCasosDeTeste : function() {
			return $http.get(SimpleTestConstants.url + '/projetos/1/casos');
		},
		
		incluir : function(caso) {
			return $http.put(SimpleTestConstants.url + '/casosDeTeste', caso);
		},
		
		excluir : function(caso) {
			return $http.delete(SimpleTestConstants.url + '/casosDeTeste/' + caso.id);
		}
	
	
	}
});