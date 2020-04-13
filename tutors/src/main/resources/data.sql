INSERT IGNORE INTO `region` VALUES
  (1,'北海道'),(2,'青森県'),(3,'岩手県'),(4,'宮城県'),(5,'秋田県'),(6,'山形県'),(7,'福島県'),(8,'茨城県'),(9,'栃木県'),(10,'群馬県'),
  (11,'埼玉県'),(12,'千葉県'),(13,'東京都'),(14,'神奈川県'),(15,'新潟県'),(16,'富山県'),(17,'石川県'),(18,'福井県'),(19,'山梨県'),(20,'長野県'),
  (21,'岐阜県'),(22,'静岡県'),(23,'愛知県'),(24,'三重県'),(25,'滋賀県'),(26,'京都府'),(27,'大阪府'),(28,'兵庫県'),(29,'奈良県'),(30,'和歌山県'),
  (31,'鳥取県'),(32,'島根県'),(33,'岡山県'),(34,'広島県'),(35,'山口県'),(36,'徳島県'),(37,'香川県'),(38,'愛媛県'),(39,'高知県'),
  (40,'福岡県'),(41,'佐賀県'),(42,'長崎県'),(43,'熊本県'),(44,'大分県'),(45,'宮崎県'),(46,'鹿児島県'),(47,'沖縄県');

INSERT IGNORE INTO `subject` VALUES
  (1,'国語'),(2,'算数'),(3,'理科'),(4,'社会'),(5,'英語'),(6,'現代文'),(7,'古文'),(8,'漢文'),(9,'数学'),(10,'化学'),
  (11,'物理'),(12,'生物'),(13,'世界史'),(14,'日本史'),(15,'語学'),(16,'その他');

INSERT IGNORE INTO `user` (user_id,mail_address,password,user_name,profile_image,region_id,self_introduction) VALUES
  (1,'a@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','あき','1',14,'名古屋大学工学部電気電子情報工学科卒。

    理系出身ため理系教科の指導と英語の指導が可能です！

    英語はTOEIC835点を取得しており高いレベルでの指導を求められる方への指導も可能です。

    メッセージお待ちしております！'),
  (2,'b@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','悟空','2',2,'もうとっくにご存じなんだろ?
オレは、地球からきさまを倒すためにやってきたサイヤ人……
穏やかな心を持ちながら激しい怒りによって目覚めた伝説の戦士…
超サイヤ人孫悟空だ!!!!!'),
  (3,'c@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ブルマ','3',3,'あんたも来たらー！　どうせ宿賃もないんでしょ？　ごちそうたくさんだすわよ！
どうせ孫くんといっしょですごく食べるんでしょ
ただしいくらあたしが魅力的だからっていっても悪いことしちゃダメよー'),
  (4,'d@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','クリリン','4',4,'悟空よ、いつもおまえにばかり地球の運命をまかせてすまないな。
ぜったいに死ぬなよ 親友……！'),
  (5,'e@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','プーアル','5',1,'ヤムチャさまーっ！！ヤムチャさまーっ！！'),
  (6,'f@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','亀仙人','6',2,'武道を習得するのはケンカに勝つためではなくギャルに「あらん★あなた、とってもつよいのね〜ウッフーン」と言われるためでもない！武道を学ぶことによって心身ともに健康となりそれによって生まれた余裕で人生をおもしろおかしくはりきって過ごしてしまおうというものじゃ！'),
  (7,'g@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ベジータ','7',3,'おだやかだったさ・・おだやかで純粋だった…ただし純粋な悪だがな…ただひたすら強くなることを願った…
そしてすさまじい特訓をくりかえしたさ…　ある時オレは自分の限界に気づいた…
自分への怒りでとつぜん目覚めたんだ…超サイヤ人がな！！！'),
  (8,'h@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','天津飯','8',4,'俺は神以上の修行をして、次の大会も頂くぜ！！'),
  (9,'i@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','チャオズ','9',1,'さよなら天さん'),
  (10,'j@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ゴジータ','10',2,'俺は悟空でもベジータでもない俺は貴様を倒すものだ'),
  (11,'k@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','魔人ブウ','11',3,'たべちゃお　たべちゃお　たべちゃおーーーーー」「クッキーになっちゃえ！'),
  (12,'l@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','フリーザ','12',4,'私の戦闘力は530000です…ですが、もちろんフルパワーであなたと戦う気はありませんからご心配なく'),
  (13,'m@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ザーボン','13',1,''),
  (14,'n@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ギニュー','14',2,''),
  (15,'o@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ブロリー','15',3,''),
  (16,'p@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','人造人間18号','16',4,''),
  (17,'q@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ピッコロ','17',2,''),
  (18,'r@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ピッコロ大魔王','18',3,''),
  (19,'s@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ナルト','19',1,''),
  (20,'t@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','サスケ','20',2,'アンタの言ったとおり……　アンタを恨み、憎み、そしてアンタを殺す為だけにオレは……生きて来た!!'),
  (21,'u@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','カカシ','21',2,'忍びの世界でルールや掟を守れないやつはクズ呼ばわりされる。　けどな仲間を大切にしない奴はそれ以上のクズだ。'),
  (22,'v@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','サクラ','22',3,'あの日から始まったんだよ　サスケくんと私…それにナルトにカカシ先生…　4人でいろんな任務やって、苦しかったしいろいろ大変だったけど、でもやっぱり何より…楽しかった。'),
  (23,'w@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','イタチ','23',3,'すまない。これで最後だ'),
  (24,'x@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','イルカ','24',4,'クラスでよくバカやった…人の気をひきつけたかったから 優秀な方で人の気がひけなかったからよ 全く自分っていうものが無いよりはマシだから ずっとずっとバカやってたんだ'),
  (25,'y@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','ロックリー','25',3,'知っていますか？強いやつには天才型と努力型がいます　君の写輪眼がうちはの血を引く天才型なら…　ボクはただひたすらに体術だけを極めた努力型です'),
  (26,'z@gmail.com','$2a$10$TudfDo4roDs/SVHGRp7/8.egsuG/l1E0A3WDUBIFdlWDzRr041Ey.','シカマル','26',4,'あーあ・・・雲はいいよなぁ・・・自由で');

INSERT IGNORE INTO `teacher` (teacher_user_id,min_wage,max_wage) VALUES
  (1,1300,0),(2,1000,0),(3,1500,0),(4,1800,0),(5,1900,0),(6,1900,0),(7,1900,0),(8,1900,0),
  (9,3800,0),(10,3100,0),(11,9000,0),(12,2000,0),(13,1900,0),(14,1900,0),(15,1900,0),(16,1900,0),
  (17,8700,0),(18,4200,0),(19,4100,0),(20,7000,0),(21,2900,0),(22,2500,0),(23,1900,0),(24,1100,0),(25,1200,0),
  (26,2000,0);

INSERT IGNORE INTO `lesson_subject` (teacher_user_id,subject_id) VALUES
  (1,2),(1,3),(1,5),(1,9),(1,11),(2,1),(2,2),(2,5),(2,8),(3,1),(3,2),(3,9),(3,11),(4,1),(4,4),(4,14),(4,15),
  (5,1),(5,5),(5,7),(5,9),(6,1),(6,8),(6,10),(6,12),(7,1),(7,2),(8,1),(8,4),(9,1),(10,1),(11,1),(11,4),
  (12,1),(12,7),(12,9),(13,2),(14,1),(14,2),(15,1),(15,3),(15,7),(16,2),(16,5),(17,1),(18,1),(19,1),(19,2),
  (20,1),(21,1),(21,5),(21,7),(22,1),(23,1),(23,8),(24,1),(24,6),(25,5),(25,9),(26,14),(26,15);

INSERT IGNORE INTO `lesson_menu` (teacher_user_id,day_of_the_week,lesson_menu_start_time,lesson_menu_end_time) VALUES
(1,"水曜日",'15:00:00','22:00:00'),(1,"金曜日",'14:00:00','23:00:00'),(1,"土曜日",'13:00:00','22:00:00'),(1,"日曜日",'15:00:00','22:00:00'),
(2,"月曜日",'18:00:00','22:00:00'),(2,"火曜日",'18:00:00','22:00:00'),(2,"水曜日",'15:00:00','22:00:00'),
(2,"木曜日",'18:00:00','22:00:00'),
(3,"月曜日",'18:00:00','22:00:00'),(3,"火曜日",'18:00:00','22:00:00'),(3,"水曜日",'15:00:00','22:00:00'),
(3,"木曜日",'18:00:00','22:00:00'),(3,"火曜日",'15:00:00','22:00:00'),
(4,"月曜日",'18:00:00','22:00:00'),(4,"火曜日",'18:00:00','22:00:00'),(4,"水曜日",'15:00:00','22:00:00'),
(4,"木曜日",'18:00:00','22:00:00'),(4,"金曜日",'14:00:00','23:00:00'),(4,"土曜日",'13:00:00','22:00:00'),(4,"日曜日",'15:00:00','22:00:00'),
(5,"月曜日",'18:00:00','22:00:00'),(5,"火曜日",'18:00:00','22:00:00'),(5,"水曜日",'15:00:00','22:00:00'),
(5,"木曜日",'18:00:00','22:00:00'),(5,"金曜日",'14:00:00','23:00:00'),(5,"土曜日",'13:00:00','22:00:00'),(5,"日曜日",'15:00:00','22:00:00'),
(6,"水曜日",'15:00:00','22:00:00'),
(6,"木曜日",'18:00:00','22:00:00'),(6,"金曜日",'14:00:00','23:00:00'),(6,"土曜日",'13:00:00','22:00:00'),(6,"日曜日",'15:00:00','22:00:00'),
(7,"月曜日",'18:00:00','22:00:00'),(7,"火曜日",'18:00:00','22:00:00'),(7,"水曜日",'15:00:00','22:00:00'),
(7,"木曜日",'18:00:00','22:00:00'),(7,"金曜日",'14:00:00','23:00:00'),(7,"土曜日",'13:00:00','22:00:00'),(7,"日曜日",'15:00:00','22:00:00'),
(8,"月曜日",'12:00:00','22:00:00'),(8,"火曜日",'18:00:00','22:00:00'),(8,"水曜日",'15:00:00','22:00:00'),
(9,"月曜日",'12:00:00','22:00:00'),(9,"火曜日",'18:00:00','22:00:00'),(9,"水曜日",'15:00:00','22:00:00'),
(9,"木曜日",'14:00:00','22:00:00'),(9,"金曜日",'14:00:00','23:00:00'),
(10,"月曜日",'12:00:00','22:00:00'),(10,"火曜日",'18:00:00','22:00:00'),(10,"水曜日",'15:00:00','22:00:00'),
(10,"木曜日",'14:00:00','22:00:00'),(10,"金曜日",'14:00:00','23:00:00'),
(11,"月曜日",'12:00:00','22:00:00'),(11,"火曜日",'18:00:00','22:00:00'),(11,"水曜日",'15:00:00','22:00:00'),
(12,"月曜日",'12:00:00','22:00:00'),(12,"火曜日",'18:00:00','22:00:00'),(12,"水曜日",'15:00:00','22:00:00'),
(12,"木曜日",'14:00:00','22:00:00'),(12,"金曜日",'14:00:00','23:00:00'),
(13,"月曜日",'12:00:00','22:00:00'),(13,"火曜日",'18:00:00','22:00:00'),(13,"水曜日",'15:00:00','22:00:00'),
(13,"木曜日",'14:00:00','22:00:00'),(13,"金曜日",'14:00:00','23:00:00'),
(14,"月曜日",'12:00:00','22:00:00'),(14,"火曜日",'18:00:00','22:00:00'),(14,"水曜日",'15:00:00','22:00:00'),
(15,"月曜日",'12:00:00','22:00:00'),(15,"火曜日",'18:00:00','22:00:00'),(15,"水曜日",'15:00:00','22:00:00'),
(15,"木曜日",'14:00:00','22:00:00'),(15,"金曜日",'14:00:00','23:00:00'),
(16,"月曜日",'12:00:00','22:00:00'),(16,"火曜日",'18:00:00','22:00:00'),(16,"水曜日",'15:00:00','22:00:00'),
(17,"月曜日",'12:00:00','22:00:00'),(17,"火曜日",'18:00:00','22:00:00'),(17,"水曜日",'15:00:00','22:00:00'),
(17,"木曜日",'14:00:00','22:00:00'),(17,"金曜日",'14:00:00','23:00:00'),
(18,"月曜日",'12:00:00','22:00:00'),(18,"火曜日",'18:00:00','22:00:00'),(18,"水曜日",'15:00:00','22:00:00'),
(19,"月曜日",'12:00:00','22:00:00'),(19,"火曜日",'18:00:00','22:00:00'),(19,"水曜日",'15:00:00','22:00:00'),
(19,"木曜日",'14:00:00','22:00:00'),(19,"金曜日",'14:00:00','22:00:00'),
(20,"月曜日",'12:00:00','22:00:00'),(20,"火曜日",'18:00:00','22:00:00'),(20,"水曜日",'15:00:00','22:00:00'),
(20,"木曜日",'14:00:00','22:00:00'),(20,"金曜日",'14:00:00','23:00:00'),
(21,"月曜日",'12:00:00','22:00:00'),(21,"火曜日",'18:00:00','22:00:00'),(21,"水曜日",'15:00:00','22:00:00'),
(22,"月曜日",'12:00:00','22:00:00'),(22,"日曜日",'18:00:00','22:00:00'),
(23,"月曜日",'12:00:00','22:00:00'),(23,"火曜日",'18:00:00','22:00:00'),
(24,"月曜日",'12:00:00','22:00:00'),(24,"火曜日",'18:00:00','22:00:00');
