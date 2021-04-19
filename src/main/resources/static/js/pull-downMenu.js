$(document).ready(function(){
// 都道府県をクリックした時に開始し、codeとnameをajaxで送信
// cityのバリュー受け取り
var A =$("#city option:selected").data("value");
// console.log(A);


    // 都道府県が変更されたら発動
    $('#prefectures').change(function() {
        // var prefCode = $('#prefectures').attr("class");
        var prefCode = $('#prefectures option:selected').attr("class");
		console.log(prefCode);

        var count = $('select[name="city"]').children().length;
		

        for (var i=0; i<count; i++) {
			
			var city = $('select[name="city"] option:eq(' + i + ')');
			if(city.attr("class") == prefCode) {
				// 選択した国と同じクラス名だった場合、違う物を削除
				$(this).not('optgroup,.prefectures').remove();
				console.log(city);
				
				// $('#city').html(city);
				
			}
		}
    })
    
	});
//   });



