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

}());
