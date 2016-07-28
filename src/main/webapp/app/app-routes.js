// Configurando as rotas
angular.module('simpleTests').config(function($routeProvider) {
	
	$routeProvider.when("/projetos", {
		templateUrl: "projetos.partial.html",
		controller: 'ProjetosController'
	});
	
	$routeProvider.when("/projetos/:id", {
		templateUrl: "detalharProjeto.html",
		controller: 'DetalheProjetoController'
	});
	
	$routeProvider.when("/novo", {
		templateUrl: "novoProjeto.html",
		controller: 'ProjetosController'
	})
	
	$routeProvider.when("/usuarios", {
		templateUrl: "usuarios.partial.html"
	});
	
	$routeProvider.when("/casosDeTeste", {
		templateUrl: "casosDeTeste.partial.html"
	});
	
	$routeProvider.when("/erro", {
		templateUrl: "erro.html"
	});
	
	$routeProvider.otherwise({
		redirectTo: '/projetos'
	});
	
});