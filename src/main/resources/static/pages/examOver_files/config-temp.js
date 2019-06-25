(function() {

	window.sets_version = '160712';
	//	window.sets_version = new Date().getTime();

	seajs.config({
		charset : 'utf-8',
		base : SETS_ROOT,
		alias : { // libs:
			// 使用压缩后的文件时报错!! 暂时忽略
			'gevent' : 'lib/gevent/jquery.event.gevent-0.1.9',
			// 已经是压缩后的文件
			'bootsets' : 'lib/bootsets/js/sets',
			'jsviews' : 'lib/dist/jsviews.min',
			'moment' : 'lib/dist/moment.min'
		},
		preload : [ 'gevent','jsviews', 'bootsets'],
		map : [ [ /^(.*\.(?:css|js))(.*)$/i, '$1?__v=' + window.sets_version ] ]
	});
	seajs._route = {
		production : false,
		appPath : function(appName) {
			if (this.production) {
				return 'dist/' + appName.split('/').pop();
			}
			return appName;
		}
	};

	seajs.use(seajs._route.appPath('core/utils'), function(app) {
		$(function() {
			if (app.isRetina()) {
				$('body').addClass('retina');
			}
		});
	});

})();