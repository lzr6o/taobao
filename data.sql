USE taobao;

INSERT INTO `category` (`id`, `name`, `type`, `parent_id`, `order_num`, `create_time`, `update_time`)
VALUES
	(3,'新鲜水果',1,0,1,'2019-12-18 01:17:00','2019-12-28 17:11:26'),
	(4,'橘子橙子',2,3,1,'2019-12-18 01:17:00','2019-12-28 16:25:10'),
	(5,'海鲜水产',1,0,2,'2019-12-18 01:17:00','2019-12-28 16:25:20'),
	(6,'精选肉类',1,0,3,'2019-12-18 01:17:00','2019-12-28 16:25:21'),
	(7,'螃蟹',2,5,1,'2019-12-18 01:17:00','2019-12-28 16:25:15'),
	(8,'鱼类',2,5,2,'2019-12-18 01:17:00','2019-12-28 16:25:16'),
	(9,'冷饮冻食',1,0,4,'2019-12-20 13:45:28','2019-12-28 16:25:22'),
	(10,'蔬菜蛋品',1,0,5,'2019-12-20 13:45:28','2019-12-28 16:25:23'),
	(11,'草莓',2,3,2,'2019-12-18 01:17:00','2019-12-28 15:44:42'),
	(12,'奇异果',2,3,3,'2019-12-18 01:17:00','2019-12-28 16:25:12'),
	(13,'海参',2,5,3,'2019-12-18 01:17:00','2019-12-28 16:25:17'),
	(14,'车厘子',2,3,4,'2019-12-18 01:17:00','2019-12-28 16:25:12'),
	(15,'火锅食材',2,27,5,'2019-12-18 01:17:00','2020-02-11 00:42:33'),
	(16,'牛羊肉',2,6,1,'2019-12-18 01:17:00','2019-12-28 16:25:18'),
	(17,'冰淇淋',2,9,1,'2019-12-18 01:17:00','2019-12-28 16:25:18'),
	(18,'蔬菜综合',2,10,1,'2019-12-18 01:17:00','2020-02-11 00:48:27'),
	(19,'果冻橙',3,4,1,'2019-12-18 01:17:00','2020-02-11 00:37:02'),
	(27,'美味菌菇',1,0,7,'2019-12-20 13:45:28','2020-02-10 23:20:36'),
	(28,'其他水果',2,3,4,'2019-12-18 01:17:00','2019-12-28 16:25:12');