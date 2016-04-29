(function() {
    'use strict';

        angular.module('playerModule').controller('ctrlListMongo', ['$scope', '$http', 'ngToast', function ($scope, $http, ngToast) {
            $http.get('http://localhost:8080/playerslistmongo').success(function (data) {
                $scope.players = data;
                $scope.playersOrder = 'player.name';
                $scope.db = "MONGO";
            });

            $scope.deleteItem = function (itemId) {
                $http({
                    url: 'http://localhost:8080/deleteplayermongo',
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
                    $scope.deletePlayerSound.play();
                    $http.get('http://localhost:8080/playerslistmongo').success(function (data) {
                        $scope.players = data;
                    }).error(function () {
                        console.log("DELETE ERROR");
                    });
                });
            }
        }]);
})();

