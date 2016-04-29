(function() {
    'use strict';
    var playerModule = angular.module('playerModule', ['ngAudio','ngResource']).run(['$rootScope', 'ngAudio', function ($rootScope, ngAudio) {
        $rootScope.themeMusic = ngAudio.play("sounds/theme.mp3");
        $rootScope.buttonClickSound = ngAudio.load("sounds/buttonClick.mp3");
        $rootScope.buttonHoverSound = ngAudio.load("sounds/buttonHover.mp3");
        $rootScope.deletePlayerSound = ngAudio.load("sounds/delete.mp3");
        $rootScope.addPlayerSound = ngAudio.load("sounds/addPlayer.mp3");
    }]);

    playerModule.controller('DetailsControllerJpa', ['$scope','serviceDetailsJpa', function ($scope, serviceDetailsJpa) {
         serviceDetailsJpa.async().then(function(player) {
             $scope.player=player;
        });
        $scope.db = "JPA";
    }]);

    playerModule.controller('DetailsControllerMongo', ['$scope','factoryDetailsMongo', function ($scope,factoryDetailsMongo) {
        var entries = factoryDetailsMongo.query(function() {
            $scope.player = entries;
        });
            $scope.db = "MONGO";
    }]);

})();

