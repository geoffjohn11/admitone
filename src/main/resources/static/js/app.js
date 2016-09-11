var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/search',{
             templateUrl: '/views/search.html',
             controller: 'searchController'
                })
        .otherwise(
            { redirectTo: '/'}
        );
});
