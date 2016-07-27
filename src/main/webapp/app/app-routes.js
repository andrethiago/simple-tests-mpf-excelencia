// Configurando as rotas
angular.module('simpleTests').config(function($routeProvider) {
	
	$routeProvider.when("/projetos", {
		templateUrl: "projetos.partial.html"
	})
	
});