// Configurando as rotas
angular.module('simpleTests').config(function($routeProvider) {
	
	$routeProvider.when("/projetos", {
		templateUrl: "projetos.partial.html"
	});
	
	$routeProvider.when("/usuarios", {
		templateUrl: "usuarios.partial.html"
	});
	
	$routeProvider.when("/casosDeTeste", {
		templateUrl: "casosDeTeste.partial.html"
	});
	
	$routeProvider.otherwise({
		redirectTo: '/projetos'
	});
	
});