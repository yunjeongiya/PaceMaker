SELECT id, start_date, comment
FROM plan
WHERE user_id = userId AND course_id = courseId AND state = true

-> if null ) makePlan으로 이동
-> else ) startDate = start_date, comment = comment, planId = id DTO로 저장

SELECT progress.id as progress_id, title, link, done
FROM progress INNER JOIN lecture
ON progress.lecture_id = lecture.id
WHERE plan_id = planId

-> list <progress(progress_id, title, link, done)> DTO로 저장
-> start_date, comment, list<progress> 출력