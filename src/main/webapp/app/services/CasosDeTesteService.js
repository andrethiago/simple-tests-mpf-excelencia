angular.module('simpleTests').factory('CasosDeTesteService', function($http, SimpleTestConstants) {
	return {
		getCasosDeTeste : function() {
			return $http.get(SimpleTestConstants.url + '/casos');
		},
		
		incluir : function(caso) {
			return $http.put(SimpleTestConstants.url + '/casos', caso);
		},
		
		excluir : function(caso) {
			return $http.delete(SimpleTestConstants.url + '/casos/' + caso.id);
		},
		
		getTipos : function() {
			return $http.get(SimpleTestConstants.url + '/casos/tipos');
		}
	
	
	}
});