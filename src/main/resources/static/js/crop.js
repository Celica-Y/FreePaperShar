
$(function() {
// 会員登録ページの切り抜き
  var $preview = $('.crop');
  
  // 画像の読み込みと切り抜きへの表示
      function readFile(input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          
          reader.onload = function (e) {
            $('#upload').addClass('ready');
            $uploadCrop.croppie('bind', {
              url: e.target.result
            }).then(function(){
              console.log('jQuery bind complete');
            });
            
          }
          
          reader.readAsDataURL(input.files[0]);
        }
      }
      
      //  croppieの表示
      var $uploadCrop = $preview.croppie({
        viewport: {
          width: 200,
          height: 200,
          type: 'circle'
        },
        boundary: {
          width: 300,
          height: 300
        },
        enableExif: true
      });
      
      
      //croppieのポップアップ 
      $('#upload').click(function(e) {
        $('#cropImagePop').fadeIn();
    });
    
    // キャンセル時
    $('.modal-btn-cancel').click(function(e) {
      $('#cropImagePop').hide();
  });

  
  // プレビューの表示（決定ボタンで確定）
    $('#upload').on('change', function () { readFile(this); });
      $('.upload-result').on('click', function (ev) {
        $uploadCrop.croppie('result', {
          type: 'canvas',
          size: 'viewport'
        }).then(function (resp) {
          $("#upload-view").attr('src', resp);
          $('input[name="profilePicture"]').val(resp);
          $("#cropImagePop").modal('hide');
          
        });
      });

      $('.upload-result').click(function(e) {
        $('#cropImagePop').hide();
      });

      })