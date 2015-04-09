var myApp = angular.module('myApp',['ngRoute']);
 
myApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
          	.when('/home', {
              templateUrl: 'templates/home.html',
              controller: 'PatientController'
          	})
          	.when('/home2', {
              templateUrl: 'templates/home2.html',
              controller: 'PatientController'
          	})
          	.when('/home3', {
              templateUrl: 'templates/home3.html',
              controller: 'PatientController'
          	})          	
            .otherwise({
            	redirectTo: 'home'
            });
          
}]);

myApp.directive('ngBlur', ['$parse', function($parse) {
	   return function(scope, element, attr) {
	     var fn = $parse(attr['ngBlur']);
	     element.bind('blur', function(event) {
	       scope.$apply(function() {
	         fn(scope, {$event:event});
	       });
	     });
	   }
	 }]);