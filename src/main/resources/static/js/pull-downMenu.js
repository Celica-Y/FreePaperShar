$(document).ready(function(){
 
    // プルダウンのoption内容をコピー
    var pd2 = $("#city option").clone();

    $("#prefectures").change(function () {
        // 都道府県のclass取得
        var lv1Val = $("#prefectures option:selected").attr("class");
		    console.log(lv1Val);
        // 市区町村のdisabled解除
        $("#city").removeAttr("disabled");
        // 市区町そnのoptionを削除
        $("#city option").remove();
 
        // コピーをを表示
        $(pd2).appendTo("#city");
 
        // 選択値以外のクラスのoptionを削除
        var A = $("#city option[prefId != "+lv1Val+"]").remove();
		// console.log(A);
        // 都道府県が変わるたびに「▼選択」optionを先頭に表示
        $("#city").prepend('<option value="" selected="selected">▼市区町村を選択</option>');
        $("#city").change(function () {
          var txt = $('#city option:selected').text();
          console.log(txt);
        })

    });
 
    
});



