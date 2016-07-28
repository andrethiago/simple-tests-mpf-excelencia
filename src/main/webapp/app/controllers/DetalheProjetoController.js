angular.module('simpleTests').controller('DetalheProjetoController', function ($scope, $routeParams, ProjetosService){
	
	ProjetosService.getProjeto($routeParams.id).then(
		function sucesso(resposta) {
			$scope.projeto = resposta.data.dados;
		},
		function falha(resposta) {
			console.log('ERRO');
			console.log(resposta);
		}
	);
	
	
});