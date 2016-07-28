angular.module('simpleTests').factory('LoadingInterceptor', function($q, $rootScope){
	return {
		request: function(config) {
			console.log('request: ' + config.url);
			$rootScope.carregando = true;
			return config;
		},
		requestError: function(rejection) {
			console.log('requestError');
			$rootScope.carregando = false;
			return $q.reject(rejection);
		},
		response: function (response) {
			console.log('response: ' + response.config.url);
			$rootScope.carregando = false;
			return response;
		},
		responseError: function (rejection) {
			console.log('responseError');
			$rootScope.carregando = false;
			return $q.reject(rejection);
		}
	};
});