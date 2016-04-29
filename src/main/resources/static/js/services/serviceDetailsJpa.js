(function() {
    'use strict';

    angular.module('playerModule').factory('serviceDetailsJpa', function ($http,$routeParams) {
        var myService = {
            async: function() {
                // $http returns a promise, which has a then function, which also returns a promise
                var promise = $http.get('http://localhost:8080/getplayerjpa/' + $routeParams.itemId).then(function (response) {
                    // The then function here is an opportunity to modify the response
                    console.log(response);
                    // The return value gets picked up by the then in the controller.
                    return response.data;
                });
                // Return the promise to the controller
                return promise;
            }
        };
        return myService;
    });
})();

