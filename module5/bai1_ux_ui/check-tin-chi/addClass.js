var courseUrl = prompt("Nhập link môn học: ");
var studentIdNumber = prompt("Nhập mã sinh viên: ");
function Add_Click1(mess,year,semester,studentIdNumber,curriculumId, key,iv) {
    $('#displayThongBao').empty();
    mess = mess.trim();
    year = (year+"").trim();
    semester = (semester+"").trim();
    studentIdNumber = (studentIdNumber+"").trim();
    curriculumId = (curriculumId+"").trim();
    key = key.trim();
    iv = iv.trim();
    //
    var capt = document.getElementById("ctl00_PlaceHolderContentArea_ctl00_ctl01_txtCaptchar").value;
    var kq="";
    $.ajax({
        type: "POST",
        beforeSend: function() {                                
            //show();
        },
        url: "../Modules/regonline/ajax/LoadCaptcha.aspx/CheckCapt",            
        data: '{captValue: "' + capt + '" }',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: true,            
        success: function (data) {                
            kq = data.d;
            //console.log(kq);
            if (kq + '' == '1') {
                //
                if (document.getElementById("ctl00_PlaceHolderContentArea_ctl00_ctl01_txt_ClassID").value == '') {
                    alert('Bạn chưa nhập Mã Đăng ký Lớp');
                    document.getElementById("ctl00_PlaceHolderContentArea_ctl00_ctl01_txt_ClassID").focus();
                    LoadCaptcha();
                    return;
                }
                //add class
                    //alert(curriculumId);
                    var t = curriculumId.indexOf(',');
                    if (t >= 0) curriculumId = curriculumId.substring(0, t);
                    //alert(curriculumId);
                    var classRegCode = document.getElementById("ctl00_PlaceHolderContentArea_ctl00_ctl01_txt_ClassID").value;

                    var para = classRegCode +"," +year +"," +semester +"," +studentIdNumber +"," +curriculumId +"," +capt;
                    var encrypted = EncryptString(para, key, iv);
                    //console.log(para);
                    //console.log(encrypted);
                    ProcessAddClass(encrypted);
                    LoadCaptcha();
            } else {
                alert("MÃ XÁC NHẬN không chính xác. Vui lòng nhập lại!");
                $("#ctl00_PlaceHolderContentArea_ctl00_ctl01_txtCaptchar").focus();
            }
        },
        failure: function (response) {
            var r = $.parseJSON(response.responseText);
            alert("Message: " + r.Message);
            alert("StackTrace: " + r.StackTrace);
            alert("ExceptionType: " + r.ExceptionType);
            
            kq = "failed";  
            //console.log(kq);
        },
        complete: function (response) {
            var r = $.parseJSON(response.responseText);
            kq = r.d;      
            if (kq + '' == '0') {
                LoadCaptcha();
            }
            //hide();
            console.log(kq);
        }
    });         
}
setInterval(() => fetch(courseUrl)
.then(res => res.text())
.then(data => data.split(`Số chỗ Còn lại`)[1].split(`</td>`)[1].replace(/\s/g, '').replace(`</div>`,``))
.then(data => data.split(`<tdcolspan="2"class="heightcell">`)[1])
.then(data => {
    let check = data.includes(`<divstyle="color:Red;">`);
    if(check){
        return data.replace(`<divstyle="color:Red;">`, ``)
    }
    return data;
})
.then(data => {
    console.log("Đang check...");
    if(parseInt(data) != 0){
        Add_Click1('Bạn có muốn Đăng ký Lớp này?    ',74,76,studentIdNumber,'697    ','AMINHAKEYTEM32NYTES1234567891234    ','7061737323313233    ')
    } else {
        console.log("Còn 0 chổ");
    }
    window.focus();
}), 1000)