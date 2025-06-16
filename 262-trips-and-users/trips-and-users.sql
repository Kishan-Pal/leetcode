SELECT 
    request_at AS Day, 
    ROUND(
        SUM(CASE WHEN status LIKE '%cancelled%' THEN 1 ELSE 0 END) / COUNT(1),2) AS "Cancellation Rate"
FROM 
    Trips
WHERE
    client_id NOT IN (SELECT users_id FROM Users WHERE role = 'client' AND banned = 'Yes') and 
    driver_id not in (select users_id from Users where role = 'driver' and banned ='Yes') 
    AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY 1 