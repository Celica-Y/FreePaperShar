$(document).ready(function(){
    var Category = [
        {"id": "1",category:"タウン情報誌"},
        {"id": "2",category:"求人"},
        {"id": "3",category:"クーポン"},
        {"id": "4",category:"音楽"},
        {"id": "5",category:"映画"},
        {"id": "6",category:"通販"},
        {"id": "7",category:"ファッション・メイク"},
        {"id": "8",category:"アート・デザイン"},
        {"id": "9",category:"住宅"},
        {"id": "10",category:"インテリア"},
        {"id": "11",category:"植物"},
        {"id": "12",category:"飲食"},
        {"id": "13",category:"学生発行"},
        {"id": "14",category:"旅行"},
        {"id": "15",category:"海外"},
        {"id": "16",category:"漫画"},
        {"id": "17",category:"アニメ"},
        {"id": "18",category:"ゲーム"},
        {"id": "19",category:"スポーツ"},
        {"id": "20",category:"学校・習い事"},
        {"id": "21",category:"乗り物"},
        {"id": "22",category:"健康"},
        {"id": "23",category:"その他"}
    ];
// カテゴリーのプルダウン生成
    for(var i=0;i<Category.length;i++){
        let op = document.createElement("option");
        op.value = Category[i].id;  //value値
        op.text = Category[i].category;   //テキスト値
        document.getElementById("category").appendChild(op);
    }

// 年月のプルダウン作成
        const today = new Date();
        const thisYear = today.getFullYear();


        const createOption = (id, startNum, endNum, current) => {
        const selectDom = document.getElementById(id);
        let optionDom = '';
        for (let i = startNum; i <= endNum; i++) { //降順
            if (i === current) {
            option = '<option value="' + i + '" selected>' + i + '</option>';
            } else {
            option = '<option value="' + i + '">' + i + '</option>';
            }
            optionDom += option;
        }
        selectDom.insertAdjacentHTML('beforeend', optionDom);
        }
        createOption('year', 2000, thisYear);
        createOption('month', 1, 12);
});