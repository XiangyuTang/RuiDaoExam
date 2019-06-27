(function () {

    window.sets_version = '180104';
    //	window.sets_version = new Date().getTime();

    seajs.on('error',function(data){
        if(!$('#seaErrorModal').length) {
            $('body').append(
                '<div class="fade modal" id="seaErrorModal" tabindex="-1" role="dialog" aria-hidden="true">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content" style="top:80px">' +
                '<div class="modal-header">' +
                '<h4 class="modal-title">网络异常</h4>' +
                '</div>' +
                '<div class="modal-body">' +
                '<p>页面加载异常，请尝试重新加载</p>' +
                '</div>' +
                '<div class="modal-footer">' +
                '<button type="button" onclick="window.location.reload()" class="btn btn-warning">重新加载</button>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>');
        }
        $('#seaErrorModal').modal({backdrop:'static',keyboard:false}).modal('show')
    })
    seajs.config({
        charset: 'utf-8',
        base: SETS_ROOT,
        alias: { // libs:
            //			'jquery':'lib/jquery/1.9.1/jquery.js',
            'urianchor': 'lib/urianchor/jquery.uriAnchor',
            'gevent': 'lib/gevent/jquery.event.gevent-0.1.9',
            'bootsets': 'lib/bootsets/js/sets',
            'jsviews': 'lib/jsviews/1.0.0-alpha/back/jsviews',
            'moment': 'lib/moment/moment',
            'vue': 'lib/vuejs/vue.js',
            'move': 'lib/layout/jquery.event.move',
            'scrollbar': 'lib/scrollbar/jquery.mCustomScrollbar',
            'wheel': 'lib/scrollbar/jquery.mousewheel',
            'datetimepicker': 'lib/datetimepicker/js/bootstrap-datetimepicker'
            //'shimplaceholder' : 'lib/shimplaceholder/jquery.html5-placeholder-shim'
        },
        //		preload : [ 'gevent', 'bootstrap', 'jsviews', 'urianchor', 'jquery', 'seajs-text' ],
        preload: ['gevent', 'bootsets', 'jsviews', 'urianchor', 'vue'],
        map: [[/^(.*\.(?:css|js))(.*)$/i, '$1?__v=' + window.sets_version]]
    });
    seajs._route = {
        production: false,
        appPath: function (appName) {
            if (this.production) {
                return 'dist/' + appName.split('/').pop();
            }
            return appName;
        }
    };

    seajs.use(seajs._route.appPath('core/utils'), function (app) {
        $(function () {
            if (app.isRetina()) {
                $('body').addClass('retina');
            }
        });
    });

})();
