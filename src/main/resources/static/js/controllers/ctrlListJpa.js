(function() {
    'use strict';

    angular.module('playerModule').controller('ctrlListJpa', ['$scope', '$http', 'ngToast', function ($scope, $http, ngToast) {

        $http.get('http://localhost:8080/playerslistjpa').success(function (data) {
            $scope.players = data;
            $scope.playersOrder = 'player.name';
            $scope.db = "JPA";
        });

        $scope.deleteItem = function (itemId) {
            $http({
                url: 'http://localhost:8080/deleteplayerjpa',
                dataType: 'json',
                method: 'DELETE',
                data: itemId,
                headers: {
                    "Content-Type": "application/json"
                }
            }).success(function () {
                console.log("DELETE SUCCESS");
                ngToast.create({
                    className: 'danger',
                    content: 'Zawodnik o identyfikatorze: ' + itemId + ' został usunięty !'
                })
                $http.get('http://localhost:8080/playerslistjpa').success(function (data) {
                    $scope.players = data;
                }).error(function () {
                    console.log("DELETE ERROR");
                });
            });
        }
    }]);
})();

