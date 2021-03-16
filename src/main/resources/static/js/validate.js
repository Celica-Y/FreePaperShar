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
              email: '有効なメールアドレスを入力してください'
          },
          password: {
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

}());
