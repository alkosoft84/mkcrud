(function() {
    'use strict';
    angular.module('myApp', [
        'ngRoute','ngResource','ngAudio','ngAnimate','jcs-autoValidate','ngToast',
        'playerModule'
    ])
    .config(['$routeProvider','ngToastProvider', function ($routeProvider,ngToastProvider) {
            ngToastProvider.configure({
                animation: 'fade',
                horizontalPosition:'right',
                verticalPosition:'bottom',
                dismissButton:'true',
                timeout:3000
            });
        $routeProvider.
            when('/intro', {
                templateUrl: 'partials/intro.html'
            }).
            when('/listjpa', {
                templateUrl: 'partials/list.html',
                controller: 'ctrlListJpa'
            }).
            when('/listmongo', {
                templateUrl: 'partials/list.html',
                controller: 'ctrlListMongo'
            }).
            when('/detailsjpa/:itemId', {
                templateUrl: 'partials/details.html',
                controller: 'DetailsControllerJpa'
            }).
            when('/detailsmongo/:itemId', {
                templateUrl: 'partials/details.html',
                controller: 'DetailsControllerMongo'
            }).
            when('/editjpa', {
                templateUrl: 'partials/edit.html',
                controller: 'ctrlEditJpa'
            }).
            when('/editjpa/:itemId', {
                templateUrl: 'partials/edit.html',
                controller: 'ctrlEditJpa'
            }).
            when('/editmongo/:itemId', {
                templateUrl: 'partials/edit.html',
                controller: 'ctrlEditMongo'
            }).
            when('/editmongo/', {
                templateUrl: 'partials/edit.html',
                controller: 'ctrlEditMongo'
            }).
            otherwise({
                redirectTo: '/intro'
            });
    }]).run(function (defaultErrorMessageResolver){
            defaultErrorMessageResolver.getErrorMessages().then(function (errorMessages){
                errorMessages['blednyUser'] = 'Podałes błedny kod użytkownika';
                errorMessages['bladRequired'] = 'Pole jest wymagane';
                errorMessages['bladZaMaloZnakow'] = 'Podaj przynajmniej {0} znaki';
            });
        })

    .directive('ngReallyClick', [function() {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                element.bind('click', function() {
                    var message = attrs.ngReallyMessage;
                    if (message && confirm(message)) {
                        scope.$apply(attrs.ngReallyClick);
                    }
                });
            }
        }
    }]);

})();