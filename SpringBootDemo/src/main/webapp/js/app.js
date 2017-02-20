var myApp = angular.module('myApp', ["ngRoute"]);

myApp.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/#', {
            templateUrl : 'index.html'
          
        })
         .when('/login', {
            templateUrl : 'views/login.html',
            controller  : 'employeeController'
        })

        // route for the about page
        .when('/employee', {
            templateUrl : 'views/employee.html',
            controller  : 'employeeController'
        })

});
