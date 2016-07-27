angular.module('simpleTests').factory('ProjetosService', function($http) {
	var consultarProjetos = function() {
		return $http.get('http://localhost:8080/simpletests/projetos');
	};
	
	return {
		getProjetos : consultarProjetos 
	}
});