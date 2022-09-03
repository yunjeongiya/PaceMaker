function dataSend() {
    var scheduleId = $("#scheduleId").val();
    var comment = $("#comment").val();
    var commentUpdateReq = {
        scheduleId : scheduleId,
        comment : comment
    };

    $.ajax({
        url: "/updateComment",
        type: "POST",
        data: commentUpdateReq,
        //몇시 업데이트인지 화면에 보이게 하기!
    });
}

function check(box){
    var doneUpdateReq = {
        done : box.checked,
        progressId: box.name
    };

    $.ajax({
        url: "/updateDone",
        type: "POST",
        data: doneUpdateReq,
        //몇시 업데이트인지 화면에 보이게 하기!
    });
}