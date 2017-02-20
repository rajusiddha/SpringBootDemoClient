myApp.controller('employeeController', function (emloyeeService,$scope,$http,$location) {
	
	$scope.employees = [];
	$scope.names = ["USER","ADMIN"];
	var backEndUrl = "/employee";
	
    $scope.IsHidden = true;
    
    $scope.ShowHide = function () {
        $scope.IsHidden = $scope.IsHidden ? false : true;
    }
    
    $scope.checkUser = function(role) {
    	 if (role == "ADMIN") { // your question said "more than one element"
    	   return true;
    	  }
    	  else {
    	   return false;
    	  }
    	};
    function loadData() {
        $http.get(backEndUrl)
            .then(function (response) {
                $scope.employees = response.data;
            })
            .catch(function(error) {
                $scope.error = error;
            });
    }
    loadData();
    
    $scope.save = function(uservo) {
    	
    	$http.post(backEndUrl+"/save",uservo)
    	.then(
				function(response){
					return response.data;
				}
		).catch(function(error) {
            $scope.error = error;
        });
		
	}
    
  $scope.remove=function(index){
  	   var employee = $scope.employees[index]; 
      	$http.delete(backEndUrl +'/remove/'+employee.id)
      	.then(
  				function(response){
  					return response.data;
  					
  				}
  		).catch(function(error) {
              $scope.error = error;
          });
      }
  
  $scope.updateEmployee = function(index){
	  $scope.uservo = $scope.employees[index];
//	  emloyeeService.set(uservo);
	  $scope.IsHidden=false;
  }
  
 /* $scope.login=function(userData){
	  $location.path("/employee");
  }
  */
});