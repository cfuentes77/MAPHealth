angular.module('myApp').
	controller('PatientController', [ '$scope', '$http', function ($scope, $http) {
	
	$scope.loadPatient = function(patientId) {
	    $http.get('http://localhost:8080/mapWeb-1.0/web/search/patient?query='+patientId).
	    success(function (data) {
	        $scope.response = data;
	    });
	}
	
	$scope.loadUser = function(userId) {
	    $http.get('http://localhost:8080/mapWeb-1.0/web/search/user?query='+userId).
	    success(function (data) {
	        $scope.response = data;
	    });
	}
	
	$scope.saveUser = function(userId) {
		var requestObject = {				 
				id : userId,
				firstName : $scope.response.returnObject.firstName,
				lastName : $scope.response.returnObject.lastName				
		};
		
		var dataObj = {
				requestObject : requestObject
		};
		
	    $http.post('http://localhost:8080/mapWeb-1.0/web/search/update',dataObj).
	    success(function (data) {
	        //alert("Saved");
	    	//$scope.response = "";
	    });
	}
	
}]);
