angular.module('simpleTests').factory('TrataErroInterceptor', function($q){
	return {
		request: function(config) {
			console.log('passou no request');
			return config;
		},
		requestError: function(rejection) {
			return $q.reject(rejection);
		},
		response: function (response) {
			console.log('passou no response');
			console.log(response)
			return response;
		},
		responseError: function (rejection) {
			return $q.reject(rejection);
		}
	};
});