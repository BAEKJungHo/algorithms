# DATETIME 에서 DATE 로 형 변환

- 출처 : https://programmers.co.kr/learn/courses/30/lessons/59414
- 문제 요약 
  - DATETIME 에서 DATE 로 형 변환

```sql
SELECT ANIMAL_ID, NAME, date_format(datetime, '%Y-%m-%d') AS '날짜' from ANIMAL_INS;
```
