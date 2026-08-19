SELECT
    request_at AS Day,
    ROUND(
        SUM(
            CASE
                WHEN status IN ('cancelled_by_driver', 'cancelled_by_client')
                THEN 1
                ELSE 0
            END
        ) * 1.0 / COUNT(*),
        2
    ) AS "Cancellation Rate"
FROM Trips t
JOIN Users uc
    ON t.client_id = uc.users_id
JOIN Users ud
    ON t.driver_id = ud.users_id
WHERE uc.banned = 'No'
  AND ud.banned = 'No'
  AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY request_at
ORDER BY request_at;