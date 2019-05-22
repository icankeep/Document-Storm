$(document).ready(function(){
    $(".file-upload .btn-upload").on("click",function(){
        $(".input-upload").click();
        return false;
    });
    $(".input-upload").on("input",function(){
        $(".file-upload>.upload>input").val(this.value);
    });
})