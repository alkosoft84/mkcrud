(function() {
    'use strict';

    angular.module('playerModule').controller('ctrlEditMongo', ['$scope', '$http', '$routeParams', '$location', 'ngToast', function ($scope, $http, $routeParams, $location, ngToast) {
        $scope.db = "MONGO";
        if ($routeParams.itemId != null) {
            $http.get('http://localhost:8080/getplayermongo/' + $routeParams.itemId).success(function (player) {
                $scope.player = player;
                $scope.player.player.reputation = $scope.player.player.reputation.toString();
            });
        } else {
            $scope.player = {
                "player": {
                    "name": null,
                    "character": "Good",
                    "reputation": null,
                    "imageLink": null,
                    "story": null
                }
            };
        }

        $scope.reputations = [{value: '1', label: '1'}, {value: '2', label: '2'}, {value: '3', label: '3'}, {
            value: '4',
            label: '4'
        }, {value: '5', label: '5'},
            {value: '6', label: '6'}, {value: '7', label: '7'}];

        $scope.imageLinks = [{value: 'johhny.gif', label: 'Johhny Cage'}, {
            value: 'kung.gif',
            label: 'Kung Lao'
        }, {value: 'liukang.gif', label: 'Liu Kang'}, {
            value: 'scorpion.gif',
            label: 'Scorpion'
        }, {value: 'sonya.gif', label: 'Sonya'},
            {value: 'sub.gif', label: 'Sub Zero'}];


        $scope.onSubmit = function () {
            $http({
                url: 'http://localhost:8080/editplayermongo',
                dataType: 'json',
                method: 'POST',
                data: $scope.player,
                headers: {
                    "Content-Type": "application/json"
                }
            }).success(function () {
                $scope.addPlayerSound.play();
                if ($routeParams.itemId != null) {
                    ngToast.create({
                        className: 'warning',
                        content: 'Zawodnik o identyfikatorze: ' + $routeParams.itemId + ' został zmodyfikowany !'
                    })
                } else {
                    ngToast.create({
                        className: 'info',
                        content: 'Dodano nowego zawodnika'
                    })
                }
                console.log("Submitted");
                console.log($scope.player);
                $location.url('/listmongo');
            }).error(function () {
                console.log("ERROOORRRR Submit");
                console.log($scope.player);
            });
        }

    }]);
})();

