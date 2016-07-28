//angular.module('simpleTests', ['ngMessages']);

angular.module('simpleTests', ['ngMessages', 'ngRoute']);

angular.module('simpleTests').config(function($httpProvider){
	$httpProvider.interceptors.push('TrataErroInterceptor');
	$httpProvider.interceptors.push('LoadingInterceptor');
});