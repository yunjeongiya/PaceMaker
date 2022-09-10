function sendComment() {
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

function sendPace() {
    var schedulingResource = [];
    $("#schedulingResource").each(
        (id, courseId, title, link, weight) => {
            var lecture = {
                id : id,
                courseId : courseId,
                title : title,
                link : link,
                weight : weight
            }
            schedulingResource.push(lecture);
            console.log(lecture.id);
            console.log(lecture.courseId);
            console.log(lecture.link);
            console.log(lecture.weight);
        }
    );

    var pace = $("#pace").val();
    var schedulingReq = {
        pace : pace,
        schedulingResource : schedulingResource
    };

    $.ajax({
        url: "/regulatePace",
        type: "POST",
        data: schedulingReq,
    });
}
//[Lecture(id=11, courseId=1, title=로그 Lv1 - 로그의 정의, link=null, weight=1)]];
function lectureStringToObject(List) {

}