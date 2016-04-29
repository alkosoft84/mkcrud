(function() {
    'use strict';
    angular.module('playerModule').factory('factoryDetailsMongo', function($resource,$routeParams) {
        return $resource(
            'http://localhost:8080/getplayermongo/' + $routeParams.itemId,
            { method: 'getTask', q: '*' }, // Query parameters
            {'query': { method: 'GET' }}
        );
    });
})();

