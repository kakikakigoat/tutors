$(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	doDataRefresh(); //初回に実行

	//ajax
	function doDataRefresh()
	{
		$.ajax( // promiseを返す
				{
					url:"/checkdb",
					type:"POST"
				})
				.done(function(returnData){
					if(returnData.length > 3) {
						console.log(returnData);
						var data = JSON.parse(returnData);
						//ベルを光らせる
						$('#alert').addClass('alert');
						$('.alert-box-item-wrapper').remove();
						$('.alert-box-item-content').remove();
						$('.alert-box-item-time').remove();
						for(let i = 0; i < data.length; i++) {
							$('.alert-box')
							.append('<div class="alert-box-item-wrapper">'
									+'<a href="http://ec2-13-114-198-225.ap-northeast-1.compute.amazonaws.com:8080/profile/tutor"></a>'
									+'<div class="alert-box-item-content">'
									+data[i].userName+'さんよりTUTOR申請がありました。</div><div class="alert-box-item-time">'
									+data[i].applicationDate+'</div></div>');
						}
						
					} else {
						$('.alert-box-item-content').text('TUTOR申請はありません');
					}
				})
				.fail(function(xhr) {console.log('error')});
		return false;
	}


	(function(){
		var t = setInterval(function()
				{
			doDataRefresh(); // 定期的に行いたい処理
				}, 60000); // refresh間隔＝1分＝60秒＝60000ms
	})();



	

	$('#check1').change(function() {
		$("#blood").prop("disabled", true);
	});
	
	//alert-box
	$('.alert-wrapper').click(function(){
		if($('.alert-box').hasClass('alert-box-show')) {
			$('.alert-box').removeClass('alert-box-show');
		} else {
			$('.alert-box').addClass('alert-box-show');
		}
	});


	//曜日チェック
	$('#monCheck').change(function() {
		if($(this).prop('checked')) {
			$("#monTimeFrom").prop("disabled", false);
			$("#monTimeTo").prop("disabled",false);
		} else {
			$("#monTimeFrom").prop("disabled", true);
			$("#monTimeTo").prop("disabled", true);
		}
	});
	$('#tueCheck').change(function() {
		if($(this).prop('checked')) {
			$("#tueTimeFrom").prop("disabled", false);
			$("#tueTimeTo").prop("disabled",false);
		} else {
			$("#tueTimeFrom").prop("disabled", true);
			$("#tueTimeTo").prop("disabled", true);
		}
	});
	$('#wedCheck').change(function() {
		if($(this).prop('checked')) {
			$("#wedTimeFrom").prop("disabled", false);
			$("#wedTimeTo").prop("disabled",false);
		} else {
			$("#wedTimeFrom").prop("disabled", true);
			$("#wedTimeTo").prop("disabled", true);
		}
	});
	$('#thuCheck').change(function() {
		if($(this).prop('checked')) {
			$("#thuTimeFrom").prop("disabled", false);
			$("#thuTimeTo").prop("disabled",false);
		} else {
			$("#thuTimeFrom").prop("disabled", true);
			$("#thuTimeTo").prop("disabled", true);
		}
	});
	$('#friCheck').change(function() {
		if($(this).prop('checked')) {
			$("#friTimeFrom").prop("disabled", false);
			$("#friTimeTo").prop("disabled",false);
		} else {
			$("#friTimeFrom").prop("disabled", true);
			$("#friTimeTo").prop("disabled", true);
		}
	});
	$('#satCheck').change(function() {
		if($(this).prop('checked')) {
			$("#satTimeFrom").prop("disabled", false);
			$("#satTimeTo").prop("disabled",false);
		} else {
			$("#satTimeFrom").prop("disabled", true);
			$("#satTimeTo").prop("disabled", true);
		}
	});
	$('#sunCheck').change(function() {
		if($(this).prop('checked')) {
			$("#sunTimeFrom").prop("disabled", false);
			$("#sunTimeTo").prop("disabled",false);
		} else {
			$("#sunTimeFrom").prop("disabled", true);
			$("#sunTimeTo").prop("disabled", true);
		}
	});
});
