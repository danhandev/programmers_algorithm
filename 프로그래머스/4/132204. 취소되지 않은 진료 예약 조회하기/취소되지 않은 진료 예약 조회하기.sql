# 2022년 4월 13일 기준 -> 취소되지 않은
# 흉부외과(CS) 진료 예약
# 진료예약일시를 기준으로 오름차순
SELECT
    a.APNT_NO,
    p.PT_NAME, 
    p.PT_NO,
    a.MCDP_CD,
    d.DR_NAME,
    a.APNT_YMD
FROM APPOINTMENT a
JOIN DOCTOR d ON d.DR_ID = a.MDDR_ID
JOIN PATIENT p ON p.PT_NO = a.PT_NO
WHERE a.MCDP_CD = "CS"
    AND a.APNT_CNCL_YN = "N"
    AND a.APNT_YMD >= '2022-04-13' AND a.APNT_YMD < '2022-04-14'
ORDER BY APNT_YMD ASC;