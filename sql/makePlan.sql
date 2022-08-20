SELECT id as lecture_id, weight FROM lecture
WHERE course_id = courseId AND id NOT IN
(   SELECT lecture_id FROM plan INNER JOIN progress
    ON plan.id = progress.plan_id
    WHERE plan.user_id = userId AND plan.course_id = courseId AND done = TRUE )

-> list<lecture(lecture_id, weight)> DTO로 저장
-> weight 계산해 스케줄링할 list<lecture_id> 생성

@TRANSACTION
INSERT INTO plan(user_id, start_date, comment, course_id, state)
VALUES (currentUserId, today, NULL, currentCourseId, TRUE)

SELECT LAST_INSERT_ID();
-> planId DTO로 저장

INSERT INTO progress(lecture_id, plan_id, done)
VALUES (list<lectureId>[i], planId, FALSE)
