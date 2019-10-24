getSysServiceRightList
===
SELECT
  `right_code`,
  `right_name`,
  `updatime`,
  `status`
FROM
  `sys_service_right`
WHERE `status`=1;


getSysPagesList
===
SELECT sp.`id`,
  sp.`page_name`,
  sp.`match_url_suffix`,
  sp.`status`,
  sp.`updatime`
 FROM 
`sys_pages` sp
JOIN  `sys_pages_service_right`  spsr ON sp.id=spsr.page_id 
JOIN  `sys_pages_service_right_user` spsru ON spsru.page_service_right_id = spsr.id 
WHERE sp.status=1 AND spsr.service_right_code=#{serviceType} AND spsru.sys_user_id=#{userNo};

