$(function () {
// 会員登録のバリデーション
    $('#form').validate({
      errorElement:'p', 
      // バリデーションルール
      rules: {
          Email: {
              required: true,
              email: true
          },
          password: {
              required: true,
              minlength: 6　　　　 
          }
      },

      messages: {
          Email: {
            required: 'メールアドレスを入力してください',
            email: '有効なメールアドレスを入力してください'
          },
          password: {
            required:　'パスワードを入力してください',
            minlength: 'パスワードは6文字以上で入力してください'
          }
      },

      errorPlacement: function(error, element){
          if(element.attr('name')=='password'){
              error.insertAfter('#password')
          } else{
              error.insertAfter(element)
          }
      }
    });

    // 投稿ページのバリデーション
    $('#register-form').validate({
        errorElement:'p', 
        // バリデーションルール
      rules: {
        paperName: {
            required: true
        },
        prefectures: {
            required: true　　　 
        },
        city: {
            required: true　
        },
        category: {
            required: true
        },
        year:{
            required: true
        },
        month:{
            required: true
        }
    },
    messages: {
        paperName: {
            required:  '必須です。入力してください。'
        },
        prefectures: {
            required: '必須です。選択してください。'　　　 
        },
        city: {
            required: '必須です。選択してください。'　
        },
        category: {
            required: '必須です。選択してください。'
        },
        year:{
            required: '必須です。選択してください。'
        },
        month:{
            required: '必須です。選択してください。'
        }
    },
    errorPlacement: function(error, element){
        if(element.attr('name')=='month'){
            error.insertAfter('#month')
        } else{
            error.insertAfter(element)
        }
    }

    });

}());
