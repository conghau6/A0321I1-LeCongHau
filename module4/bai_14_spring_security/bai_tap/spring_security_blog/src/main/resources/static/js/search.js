function search() {
    var title = $("#title").val();
    $.ajax({
        url: "http://localhost:8080/api/blogs/search",
        data: {
            title: title
        },
        type: 'get',
        dataType: 'json',
        success: function (response) {
            var result = "";
            for(let i=0; i<response.length; i++){
                result += `
                    <div>
                    <h5>Thể loại: <span>${response[i].category.nameCategory}</span></h5>
                    <h5>${response[i].header}</h5>
                    <p>${response[i].content}</p>
                    <p>Ngày tạo <span>${response[i].date}</span></p>
                    <hr>
                    </div>`;
            }
            $("#blogs-list").html(result);
            $("#pagination").hide();
        }
    });
}