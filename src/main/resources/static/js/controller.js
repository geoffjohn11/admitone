
app.controller("searchController", [ '$scope', '$resource',
    function($scope, $resource) {
    $scope.search = function(purchase){
        var purchases = $resource('/purchase/:fromId/:toId', {fromId:'@fromId'}, {toId:'@toId'});
        var results = purchases.query({fromId:purchase.fromShowId, toId:purchase.toShowId});
        results.$promise.then(function(data){
          $scope.results = results;
        });
    }
} ]);



