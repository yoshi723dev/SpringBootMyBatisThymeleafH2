
$(document).ready( function(){
	// 住所検索
	$("#post_serarch").click(function() {
		// 郵便番号取得
		var zipcode = $('input[name="postalcd"]').val();
		$.ajax({
			url:"http://a.deezus.net/api/zip/search?keyword=" + zipcode,
			type:"GET",
			dataType:"json",
			timespan:1000
		}).done(function(data,textStatus,jqXHR) {
			var address = data["pref"] + data["city"] + data["cho"];
			console.log(address);
			$(input[name="address"]).val(address);
		}).fail(function(jqXHR, textStatus, errorThrown ) {
			// エラー
		});
	});

});



